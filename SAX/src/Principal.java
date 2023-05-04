import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parseador=factory.newSAXParser();
		LectorSAX lectorSAX=new LectorSAX();
		File archivo=new File("C:\\Users\\Alumno\\Downloads\\mundialQatar2022 (1).xml");		
		parseador.parse(archivo, lectorSAX);
	}

}
