import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformadorXSLT {

	public static void main(String[] args) {
		String srcXmlPath = "C:\\Users\\Alumno\\Downloads\\NetflixOriginals (2).xml";
		String targetHTMLPath = "C:\\Users\\Alumno\\Desktop\\pelis.html";
		String xsltPath = "C:\\Users\\Alumno\\Downloads\\transformaPelis.xsl";
		transformXmlByXslt(srcXmlPath,targetHTMLPath,xsltPath);

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
