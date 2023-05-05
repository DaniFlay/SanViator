
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXML {

	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		Coche coche= new Coche(1,"Ferrari","360 moderna",1998,340,"cv",79500,"euro");
		Coche coche2= new Coche(2,"BMW","Serie 3",2005,180,"cv",18200,"euro");
		Coche coche3= new Coche(3,"Lada","Kalina",2004,90,"cv",10732,"euro");
		Coche coche4= new Coche(4,"Lada","Niva",1997,83,"cv",7500,"euro");
		Coche coche5= new Coche(5,"Lada","Samara",1984,71,"cv",4800,"euro");
		Coche[] coches= {coche,coche2,coche3,coche4,coche5};
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.newDocument();
		
		Element elementCatalogo= document.createElement("catalogoCoches");
		
		for(Coche c:coches) {
			Element elementCoche= document.createElement("coche");
			Element elementMarca= document.createElement("marca");
			Element elementModelo= document.createElement("modelo");
			Element elementAnyo= document.createElement("anyo");
			Element elementPotencia= document.createElement("potencia");
			Element elementPrecio= document.createElement("precio");
			
			Text textMarca= document.createTextNode(c.getMarca());
			Text textModelo= document.createTextNode(c.getModelo());
			Text textAnyo= document.createTextNode(c.getAnyo()+"");
			Text textPotencia= document.createTextNode(c.getPotencia()+"");
			Text textPrecio= document.createTextNode(c.getPrecio()+"");
			
			elementMarca.appendChild(textMarca);
			elementModelo.appendChild(textModelo);
			elementAnyo.appendChild(textAnyo);
			elementPotencia.appendChild(textPotencia);
			elementPrecio.appendChild(textPrecio);
			
			elementCoche.setAttribute("id", c.getAttId()+"");
			elementPotencia.setAttribute("cv", c.getAttUnidad());
			elementPrecio.setAttribute("moneda", c.getAttMoneda());
			
			elementCoche.appendChild(elementMarca);
			elementCoche.appendChild(elementModelo);
			elementCoche.appendChild(elementAnyo);
			elementCoche.appendChild(elementPotencia);
			elementCoche.appendChild(elementPrecio);
			
			elementCatalogo.appendChild(elementCoche);
		}
		
		document.appendChild(elementCatalogo);
		
		saveXMLtoFile(document,"catalogoCoches.xml");
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
}
