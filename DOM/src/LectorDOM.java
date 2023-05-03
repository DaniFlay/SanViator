import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LectorDOM {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		String[] A= new String[0];
		String[] B= new String[0];
		String[] C= new String[0];
		String[] D= new String[0];
		String[] E= new String[0];
		String[] F= new String[0];
		String[] G= new String[0];
		String[] H= new String[0];
		String[] R16= new String[0];
		String[] R8= new String[0];
		String[] R4= new String[0];
		String[] FINAL= new String[0];
		String[] FINAL2= new String[0];
		String line, team1 = null,team2 = null, goals1 = null,goals2 = null, date = null;
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		File archivo=new File("C:\\Users\\Alumno\\Downloads\\mundialQatar2022 (1).xml");
		Document xml=builder.parse(archivo);
		Element root=xml.getDocumentElement(); 
		NodeList matchList=root.getChildNodes();

		for(int i=0;i<matchList.getLength();i++) {
			Node match=matchList.item(i);
			NodeList matchElements= match.getChildNodes();
			for(int j=0;j<matchElements.getLength();j++) {
				Node matchElement= matchElements.item(j);
				if(matchElement.getNodeName().equals("equipo1")) {
					team1=matchElement.getTextContent();
				}
				if(matchElement.getNodeName().equals("equipo2")) {
					team2=matchElement.getTextContent();
				}
				if(matchElement.getNodeName().equals("golesEquipo1")) {
					goals1=matchElement.getTextContent();
				}
				if(matchElement.getNodeName().equals("golesEquipo2")) {
					goals2=matchElement.getTextContent();
				}
				if(matchElement.getNodeName().equals("fecha")) {
					date=matchElement.getTextContent();
				}
				line=date+" "+team1+" "+goals1+"-"+goals2+" "+team2;
				if(matchElement.getNodeName().equals("categoria")) {
					if(matchElement.getTextContent().equals("Group A")){
						A=Arrays.copyOf(A, A.length+1);
						A[A.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group B")){
						B=Arrays.copyOf(B, B.length+1);
						B[B.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group C")){
						C=Arrays.copyOf(C, C.length+1);
						C[C.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group D")){
						D=Arrays.copyOf(D, D.length+1);
						D[D.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group E")){
						E=Arrays.copyOf(E, E.length+1);
						E[E.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group F")){
						F=Arrays.copyOf(F, F.length+1);
						F[F.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group G")){
						G=Arrays.copyOf(G, G.length+1);
						G[G.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Group H")){
						H=Arrays.copyOf(H, H.length+1);
						H[H.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Round of 16")){
						R16=Arrays.copyOf(R16, R16.length+1);
						R16[R16.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Quarter-final")){
						R8=Arrays.copyOf(R8, R8.length+1);
						R8[R8.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Semi-final")){
						R4=Arrays.copyOf(R4, R4.length+1);
						R4[R4.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Final")){
						FINAL=Arrays.copyOf(FINAL, FINAL.length+1);
						FINAL[FINAL.length-1]=line;
					}
					else if(matchElement.getTextContent().equals("Play-off for third place")){
						FINAL2=Arrays.copyOf(FINAL2, FINAL2.length+1);
						FINAL2[FINAL2.length-1]=line;
					}
				}
			}
		}
		System.out.println("Grupo A:");
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}
		System.out.println("Grupo B:");
		for(int i=0;i<B.length;i++) {
			
			System.out.println(B[i]);
		}
		System.out.println("Grupo C:");
		for(int i=0;i<C.length;i++) {
			
			System.out.println(C[i]);
		}
		System.out.println("Grupo D:");
		for(int i=0;i<D.length;i++) {
			
			System.out.println(D[i]);
		}
		System.out.println("Grupo E:");
		for(int i=0;i<E.length;i++) {
			
			System.out.println(E[i]);
		}
		System.out.println("Grupo F:");
		for(int i=0;i<F.length;i++) {
			
			System.out.println(F[i]);
		}
		System.out.println("Grupo G:");
		for(int i=0;i<G.length;i++) {
			
			System.out.println(G[i]);
		}
		System.out.println("Grupo H:");
		for(int i=0;i<H.length;i++) {
			
			System.out.println(H[i]);
		}
		System.out.println("Round of 16:");
		for(int i=0;i<R16.length;i++) {
			
			System.out.println(R16[i]);
		}
		System.out.println("Quarter-Finals:");
		for(int i=0;i<R8.length;i++) {
			
			System.out.println(R8[i]);
		}
		System.out.println("Semi-final:");
		for(int i=0;i<R4.length;i++) {
			
			System.out.println(R4[i]);
		}
		System.out.println("3rd place:");
		for(int i=0;i<FINAL2.length;i++) {
			
			System.out.println(FINAL2[i]);
		}
		System.out.println("Final:");
		for(int i=0;i<FINAL.length;i++) {
			
			System.out.println(FINAL[i]);
		}
	}
	
}
