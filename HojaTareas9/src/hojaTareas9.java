import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class hojaTareas9 {

	public static void main(String[] args) {
		/*ejercicio8();*/
			String ruta1="C:\\Users\\Alumno\\Desktop\\q.txt";
			String ruta2="C:\\Users\\Alumno\\Desktop\\e.txt";
			ejercicio10(ruta1,ruta2);
	}
		
	public static int leerEntero() {
		int o=0;
		try {
			System.out.println("Escribe un entero: ");
			Scanner sc=new Scanner(System.in);
			o=sc.nextInt();
			sc.close();
		}catch(Exception ex) {
			System.out.println("Debes introducir un entero");
			leerEntero();
		}
	return o;
	}

	public static void leerArchivo(FileReader doc) {
		int lectura;
		try {
			while((lectura=doc.read())!=-1) {
				System.out.print((char)lectura);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	public static void leerArchivo2(FileReader doc) {
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(doc);
			String linea;
			while((linea=reader.readLine())!=null) {
				System.out.println(linea);
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				}catch(IOException exc) {
					System.out.println(exc.toString());
				}
			}
		}
	}
	public static void ejercicio3(FileReader doc) {
		BufferedReader reader=null;
		int m=0, n=0;
		try {
			reader=new BufferedReader(doc);
			String linea;
			while((linea=reader.readLine())!=null) {
				String[] u=linea.split(" ");
				for(int i=0; i<u.length;i++) {
					m+=Integer.parseInt(u[i]);
					n++;
				}
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			System.out.println(m);
			System.out.println(m/n);
		}
	}
	public static double calculaMediaImpares(FileReader doc) {
		double result=0;
		int par=0, impar=0;
		BufferedReader reader=null;
		try {
			reader= new BufferedReader(doc);
			String linea;
			while((linea=reader.readLine())!=null) {
				String[] i= linea.split(" ");
				for(int j=0;j<i.length;j++) {
					if(Integer.parseInt(i[j])%2==0) {
						par++;
					}
					else {
						impar++;
						result+=Integer.parseInt(i[j]);
					}
				}
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			System.out.println("Impares: "+impar+"\nPares: "+par+"\nMedia: "+result/impar);
		}
		return result/impar;
	}
	public static void ejercicio5(FileReader doc){
		int edadMenor=10000, edadMayor=0, edad=0, edadSuma=0;
		double alturaMayor=0, alturaMenor=10000, altura=0, alturaSuma=0;
		String nombreAlto="", nombreBajo="", nombreJoven="", nombreMayor="", linea;
		BufferedReader reader=null;
		try {
			reader= new BufferedReader(doc);
			while((linea=reader.readLine())!=null) {
				String[] a= linea.split(";");
				edadSuma+=Integer.parseInt(a[1]);
				alturaSuma+=Double.parseDouble(a[2]);
				edad++;
				altura++;
					if(Integer.parseInt(a[1])>edadMayor) {
						edadMayor=Integer.parseInt(a[1]);
						nombreMayor=a[0];
					}
					if(Integer.parseInt(a[1])<edadMenor) {
						edadMenor=Integer.parseInt(a[1]);
						nombreJoven=a[0];
					}
					if(Double.parseDouble(a[2])<alturaMenor) {
						alturaMenor=Double.parseDouble(a[2]);
						nombreBajo=a[0];
					}
					if(Double.parseDouble(a[2])>alturaMayor) {
						alturaMayor=Double.parseDouble(a[2]);
						nombreAlto=a[0];
					}
				System.out.println(a[0]+" "+a[1]+" "+a[2]);
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			System.out.println("La persona más alta: "+nombreAlto+"\nLa persona más baja: "+nombreBajo+"\nLa persona más joven: "+nombreJoven+"\nLa persona más mayor: "+nombreMayor+"\nLa media de las edades: "+edadSuma/edad+"\nLa altura media: "+alturaSuma/altura);
		}
	}
	public static void ejercicio6() {
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter("archivo.txt"));
			String linea1="Tras dos meses desde el lanzamiento de Android 12,";
			String linea2="Google ha anunciado de forma oficial Android 12 Go";
			String linea3="Edition, su versión de sistema operativo optimizada";
			String linea4="para móviles de entrada. Con esta edición Go de ";
			String linea5="Android 12 Google hace una fuerte apuesta por el ";
			String linea6="rendimiento y la autonomía.";
			writer.write(linea1);
			writer.newLine();
			writer.write(linea2);
			writer.newLine();
			writer.write(linea3);
			writer.newLine();
			writer.write(linea4);
			writer.newLine();
			writer.write(linea5);
			writer.newLine();
			writer.write(linea6);
			writer.flush();
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			if(writer!=null) {
				try {
					writer.close();}catch(IOException e) {
						System.out.println(e.toString());
				}
			}
		}
	}
	public static void ejercicio7() {
		System.out.println("Introduce el nombre del archivo: ");
		Scanner sc=new Scanner(System.in);
		String nombre= sc.nextLine();
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			String linea;
			FileReader r=new FileReader(nombre);
			reader=new BufferedReader(r);
			writer=new BufferedWriter(new FileWriter("copiaDe_"+nombre));
			while((linea=reader.readLine())!=null) {
				String line=linea;
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			sc.close();
		}
	}
	public static void ejercicio8() {
		String[] persona= new String[3];
			System.out.println("Pulsa 0 si quieres añadir una persona, 1 si quieres ver el libro de firmas y 2 para salir");
			Scanner sc=new Scanner(System.in);
			int a=sc.nextInt();
			sc.nextLine();
			if(a==0) {
			System.out.println("Introduce el nombre:");
			persona[0]= sc.nextLine();
			System.out.println("Introduce el primer apellido:");
			persona[1]= sc.nextLine();
			System.out.println("Introduce el segundo apellido:");
			persona[2]= sc.nextLine();
			FileReader reader=null;
			try {
				reader = new FileReader("libroDeFirmas.txt");
			} catch (FileNotFoundException e) {
				System.out.println(e.toString());
			}finally {
			anadir(reader,persona);
			
			}}
			else if(a==1){
				mostrar();
			}
			else {
				System.out.println("Hasta pronto!");
			}
			sc.close();
			}
		
	public static void mostrar() {
		BufferedReader reader=null;
		try {
			String linea;
			FileReader r= new FileReader("libroDeFirmas.txt");
			reader= new BufferedReader(r);
			while((linea=reader.readLine())!=null) {
				System.out.println(linea);
			}
		}catch(IOException ex) {
			System.out.println(ex.toString()+" añade una persona para crear el libro");
		}finally {
			ejercicio8();
		}
	}
	public static void anadir(FileReader doc, String[] q) {
		int counter=0;
		boolean check=false;
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			FileReader r= new FileReader("libroDeFirmas.txt");
			reader= new BufferedReader(r);
			String linea;
			while((linea=reader.readLine())!=null) {
			String[] a=linea.split(" ");
			if(a.length==3) {
			for(int i=0;i<3;i++) {
				if(a[i].equals(q[i])) {
					counter++;
				}
			}
			}
			if(counter==3) {
				check=true;
				throw new nombreNoValido();
			}
			reader.close();
			r.close();
			counter=0;
			}
		}catch(nombreNoValido name) {
			System.out.println(name.toString());
		}catch(IOException ex) {
			System.out.println("Se ha creado un archivo nuevo");
		}finally {
			try {
				if(check==false) {
					writer=new BufferedWriter(new FileWriter("libroDeFirmas.txt",true));
					writer.write(q[0]+" "+q[1]+" "+q[2]+"\n");
					writer.flush();
					System.out.println("Se ha añadido la persona");
					ejercicio8();
				}
				else {
					ejercicio8();
				}
			}catch(IOException r) {
				System.out.println(r.toString());
			}
		}
	}
	public static void ejercicio9(FileReader doc){
		Scanner sc= new Scanner(System.in);
		BufferedReader reader= null;
		String[] bloques= new String[0];
		try {
			String linea;
			
			int j=0;
			reader= new BufferedReader(doc);
			while((linea=reader.readLine())!=null) {
				for(int i=0;i<12;++i) {
					bloques=Arrays.copyOf(bloques, bloques.length+1);
					linea=reader.readLine();
					bloques[j]=linea;
					j++;
				}
				
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}finally {
			blocks(bloques);
			sc.close();
	}
		}
	
public static void blocks(String[] a) {
	Scanner sc=new Scanner(System.in);
	int c=0, b=12;
	while(true) {
		sc.nextLine();
		if(sc.hasNextLine()) {
	for(int i=c; i<b;i++) {
		System.out.println(a[i]);
	}c+=12;
	b+=12;

		System.out.println();}}
	}
public static void ejercicio10(String doc1, String doc2) {
	BufferedReader reader=null;
	BufferedReader reader2=null;
	File f1= new File(doc1);
	File f2= new File(doc2);
	int linea=1;
	boolean check3=true, check4=true;
	int[]l=new int[0];
	int[] caracter=new int[0];
	boolean[] check= new boolean[0];
	try {
		String linea1="", linea2="";
		reader= new BufferedReader(new FileReader(doc1));
		reader2= new BufferedReader(new FileReader(doc2));
		while((linea1=reader.readLine())!=null&&(linea2=reader2.readLine())!=null) {
			if(f1.length()!=f2.length()) {
				check3=false;
			}
			if(!linea1.equals(linea2)) {
				check= Arrays.copyOf(check, check.length+1);
				check[check.length-1]=false;
				l=Arrays.copyOf(l, l.length+1);
				l[l.length-1]=linea;
				char[] a=linea1.toCharArray();
				char[] b=linea2.toCharArray();
				if(a.length==b.length) {
					l=Arrays.copyOf(l, l.length+1);
					l[l.length-1]=linea;
				for(int i=0;i<a.length;i++) {
					if(a[i]!=b[i]) {
						caracter= Arrays.copyOf(caracter, caracter.length+1);
						caracter[caracter.length-1]=i+1;
					}
				}
			}
				else {
					if(a.length>b.length) {
						caracter= Arrays.copyOf(caracter, caracter.length+1);
						caracter[caracter.length-1]=a.length-1;
					}
					else {
						caracter= Arrays.copyOf(caracter, caracter.length+1);
						caracter[caracter.length-1]=b.length-1;
					}
					
				}
			}
			else {
				check= Arrays.copyOf(check, check.length+1);
				check[check.length-1]=true;
				l=Arrays.copyOf(l, l.length+1);
				l[l.length-1]=linea;
				caracter= Arrays.copyOf(caracter, caracter.length+1);
			}
				linea++;
		}
		for(int i=0; i<check.length;i++) {
		if(check[i]==false) {
			System.out.println("Hay una distinción en la linea "+l[i]+" en el caracter "+caracter[i]);
		}
		}
		if(check3==false) {
			System.out.println("Los documentos tienen un distinto número de líneas");
		}
		for(int i=0;i<check.length;i++) {
			if(check[i]==false) {
				check4=false;
			}
		}
		if(check3==true&&check4==true){
			System.out.println("Los archivos son iguales!");
		}
	}catch(IOException ex) {
		System.out.println(ex.toString());
	}
}
	}



