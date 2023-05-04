import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorSAX extends DefaultHandler {
	String textoLeido="";
	String fecha="";
	String team1="";
	String team2="";
	String goles1="";
	String goles2="";
	int idPartido=1;
	@Override
	public void startDocument() throws SAXException {

	}
	@Override
	public void endDocument() throws SAXException {

	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("equipo1")) {
			team1=textoLeido;
		}
		else if(qName.equals("equipo2")) {
			team2=textoLeido;
		}
		else if(qName.equals("golesEquipo1")) {
			goles1=textoLeido;
		}
		else if(qName.equals("golesEquipo2")) {
			goles2=textoLeido;
		}
		else if(qName.equals("fecha")) {
			fecha=textoLeido;
		}else if(qName.equals("partido")){
			
			System.out.println(idPartido+"  "+fecha+" "+team1+" "+goles1+"-"+goles2+" "+team2+"\n");
			idPartido++;
		}
		 
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		textoLeido= new String(ch,start,length);
	}
	
	
}
