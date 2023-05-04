import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parseador=factory.newSAXParser();
		LectorSAX lector=new LectorSAX();
		File archivo=new File("C:\\Users\\Alumno\\Downloads\\videodbCompleto (2).xml");		
		parseador.parse(archivo, lector);
		creadorXML(lector);
	}
	public static void creadorXML(LectorSAX lector) throws IOException, TransformerException, ParserConfigurationException {
		ArrayList<Pelicula> peliculas= lector.getPeliculas();
		DocumentBuilderFactory factoryXML=DocumentBuilderFactory.newInstance();
		DocumentBuilder builderXML=factoryXML.newDocumentBuilder();
		Document document=builderXML.newDocument();
		Element elementPeliculas= document.createElement("peliculas");
		for(int i=0;i<peliculas.size();i++) {
			Element elementPelicula= document.createElement("pelicula");
			Element elementTitulo= document.createElement("titulo");
			Element elementTituloOriginal= document.createElement("tituloOriginal");
			Element elementPuntuacion= document.createElement("puntuacion");
			Element elementAnyo= document.createElement("anyo");
			
			Text textTitulo= document.createTextNode(peliculas.get(i).getTitulo());
			Text textTituloOriginal= document.createTextNode(peliculas.get(i).getTituloOriginal());
			Text textPuntuacion= document.createTextNode(peliculas.get(i).getPunutacion()+"");
			Text textAnyo= document.createTextNode(peliculas.get(i).getAnyo()+"");

			
			elementTitulo.appendChild(textTitulo);
			elementTituloOriginal.appendChild(textTituloOriginal);
			elementPuntuacion.appendChild(textPuntuacion);
			elementAnyo.appendChild(textAnyo);

			
			elementPelicula.appendChild(elementTitulo);
			elementPelicula.appendChild(elementTituloOriginal);
			elementPelicula.appendChild(elementPuntuacion);
			elementPelicula.appendChild(elementAnyo);
			
			elementPeliculas.appendChild(elementPelicula);
		}
		document.appendChild(elementPeliculas);

		
		saveXMLtoFile(document,"peliculas.xml");
		String srcXmlPath = "C:\\Users\\Alumno\\Desktop\\peliculas.xml";
		String targetHTMLPath = "C:\\Users\\Alumno\\Desktop\\peliculas.html";
		String xsltPath = "C:\\Users\\Alumno\\Desktop\\transformaNetflix.xsl";
		transformXmlByXslt(srcXmlPath,targetHTMLPath,xsltPath);

	}
		public static void saveXMLtoFile(Document document,String fileName) throws IOException,TransformerException {
			DOMSource domSource=new DOMSource(document);
			FileWriter writer=new FileWriter("C:\\Users\\Alumno\\Desktop\\"+fileName);
			StreamResult result=new StreamResult(writer);
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
			transformer.transform(domSource, result);		
			writer.close();	
	}
		public static void transformXmlByXslt(String srcXmlPath,String targetXmlPath,String xsltPath) {

			// Obtener la fábrica de convertidores
			TransformerFactory tff = TransformerFactory.newInstance();

			try {
			// Obtener las instancias del objeto convertidor s
			Transformer tf = tff.newTransformer(new StreamSource(xsltPath));
			//Convertir
			tf.transform(new StreamSource(srcXmlPath), new StreamResult(
			new FileOutputStream(targetXmlPath)));

			System.out.println ("Conversión exitosa");
			} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			System.out.println ("No se pudo obtener la instancia del objeto de conversión");
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println ("No se encontró archivo fuente");
			} catch (TransformerException e) {
			e.printStackTrace();
			System.out.println ("No se pudo convertir al archivo de destino");
			}


			}
}
