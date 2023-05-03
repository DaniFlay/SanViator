import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HojaTareas10 {

	public static void main(String[] args) throws InterruptedException {
		//Cliente[] clientes= new Cliente[0];
		ejercicio2();
	//	hackingNasa();
		//ejercicio1("C:\\Users\\Alumno\\Desktop\\probando.txt","POCO");
	}
public static void ejercicio1(String nombre, String cadena) {
	try (BufferedReader r=new BufferedReader(new FileReader(nombre))){
		String linea;
		String[] words;
		int i=1, p=1;
		int[] lines= new int[0];
		while((linea=r.readLine())!=null) {
			words= linea.split("[ .,]");
			for(int j=0; j<words.length;j++) {
				if(words[j].equals(cadena)) {
					lines= Arrays.copyOf(lines, lines.length+1);
					lines[lines.length-1]= i;
				}
			}
			i++;
		}
		System.out.print("La cadena indicada se encuentra en el documento un total de "+lines.length+"veces\n");
		for(int z=0; z<lines.length-1;z++) {
			if(lines[z]==lines[z+1]) {
				for(int q=z;q<lines.length-1;q++) {
					if(lines[q]==lines[q+1]) {
					p++;
					q++;
					}
					else {
						break;
					}
				}
				z=z+p-1;
			}
			System.out.println("En la línea "+lines[z]+" la cadena aparece "+p+" vece(s)");
			p=1;
		}
		System.out.println("En la línea "+lines[lines.length-1]+" la cadena aparece "+p+" vece(s)");
	}catch(IOException ex) {
		System.out.println(ex.toString());
	}
}
public static void ejercicio2() {
	Scanner sc= new Scanner(System.in);
	File f= new File("deportistas.txt");
	if(!f.exists()) {
		try (BufferedWriter w= new BufferedWriter(new FileWriter("deportistas.txt"))){
			String l1= "Nombre\t\t\tEdad\tPeso\tEstatura";
			w.write(l1);
			w.flush();
		}catch(IOException ex) {}
	}
	System.out.println("Pulsa 1 para añadir a un jugador, pulsa 2 para buscar y pulsa 3 para mostrar la lista completa y 4 para salir");
	int a= sc.nextInt();
	sc.nextLine();
	switch(a) {
	case 1:
		try (BufferedWriter w= new BufferedWriter(new FileWriter("deportistas.txt",true))){
			w.newLine();
			w.write(anadir(sc));
			w.flush();
			System.out.println("Jugador añadido!\n");
			ejercicio2();
			break;
		}catch(IOException ex) {}
	case 2: 
		buscar("deportistas.txt",sc);
		System.out.println("\n");
		ejercicio2();
		break;
	case 3: 
		mostrar("deportistas.txt");
		System.out.println("\n");
		ejercicio2();
		break;
	case 4:
		System.out.println("Adiós");
		sc.close();
		break;
	default:
		System.out.println("Número introducido no válido\n");
		ejercicio2();
		break;
	}
	
}
public static String anadir(Scanner sc) {
	System.out.println("Introduce el nombre y los apellidos: ");
	String str="";
	str+= sc.nextLine();
	System.out.println("Introduce la edad: ");
	str=str+"\t"+ sc.nextInt();
	System.out.println("Introduce el peso: ");
	str=str+"\t"+ sc.nextInt();
	System.out.println("Introduce la altura: ");
	str=str+"\t"+ sc.nextDouble();
	return str;
}
public static void buscar(String nombre,Scanner sc) {
	String linea;
	String[] datos;
	int minInt=0, maxInt=0;
	double min=0,max=0;
	try (BufferedReader r= new BufferedReader(new FileReader(nombre))){
		System.out.println("Introduce 1 si quieres buscar por edad, 2 si quieres buscar por peso y 3 si quieres buscar por estatura");
		int q= sc.nextInt();
		if(q==1||q==2) {
			System.out.println("Introduce el valor mínimo");
			minInt= sc.nextInt();
			System.out.println("Introduce el valor máximo");
			maxInt= sc.nextInt();
		}
		else {
			System.out.println("Introduce el valor mínimo");
			min= sc.nextDouble();
			System.out.println("Introduce el valor máximo");
			max= sc.nextDouble();
		}
		System.out.println("Nombre\t\t\tEdad\tPeso\tEstatura");
		r.readLine();
		while((linea=r.readLine())!=null) {
			datos= linea.split("\t");
			if(q==1||q==2) {
			if(Integer.parseInt(datos[q])>=minInt&&Integer.parseInt(datos[q])<=maxInt) {
				System.out.println(datos[0]+"\t"+datos[1]+"\t"+datos[2]+"\t"+datos[3]);
			}
			}
			else {
				if(Double.valueOf(datos[q])>=min&&Double.valueOf(datos[q])<=max) {
					System.out.println(datos[0]+"\t"+datos[1]+"\t"+datos[2]+"\t"+datos[3]);
				}
			}
		}
	} catch (FileNotFoundException e) {
		System.out.println(e.toString());
	} catch (IOException e) {
		System.out.println(e.toString());
	}

}
public static void mostrar(String nombre) {
	try (BufferedReader reader= new BufferedReader(new FileReader(nombre));){
		String linea;
		while((linea=reader.readLine())!=null) {
			System.out.println(linea);
		}
	}catch(IOException ex) {
		System.out.println(ex.toString());
	}
}
public static void ejercicio3() {
	Scanner sc= new Scanner(System.in);
	String ruta="";
	File f= new File("C:/Users/Alumno/Desktop/contactos.txt");
	if(!f.exists()) {
		System.out.println("Introduce la ruta para guardar el archivo");
		ruta=sc.nextLine();
		ruta+="contactos.txt";
	}
	else {
		ruta="C:/Users/Alumno/Desktop/contactos.txt";
	}
	String contacto;
	byte opcion;
	do {
	System.out.println("Escoge una opción:\n1.Añadir un nuevo contacto\n2.Buscar un teléfono\n3.Mostrar todos los contactos\n4.Salir");
	opcion=sc.nextByte();
	sc.nextLine();
	switch(opcion) {
	case 1:
		System.out.println("Introduce el nombre y el teléfono, separados por :");
		contacto= sc.nextLine();
		newContact(ruta, contacto);
		break;
	case 2:
		System.out.println("Introduce el nombre del contacto: ");
		contacto=sc.nextLine();
		buscarContacto(ruta, contacto);
		break;
	case 3:
		infoContactos(ruta);
		break;
	case 4:
		System.out.println("¡Adiós!");
		break;
	default:
		System.out.println("¡Error!");
		break;
	}
	}while(opcion!=4);
	sc.close();
}
public static void newContact(String ruta, String contacto) {
	try (BufferedWriter writer=new BufferedWriter(new FileWriter(ruta,true))){
		writer.newLine();
		writer.write(contacto);
		writer.flush();
	}catch(FileNotFoundException ex) {
		System.out.println(ex.toString());
	} catch (IOException e) {
		System.out.println(e.toString());
	}
	}
public static void buscarContacto(String ruta, String nombre) {
	String linea;
	String[] contacto;
	boolean contains;
	try (BufferedReader reader= new BufferedReader(new FileReader(ruta))){
		while((linea=reader.readLine())!=null) {
			contains=false;
			contacto= linea.split("[:]");
				if(contacto[0].contains(nombre)) {
					contains=true;
				}
			if(contains) {
				System.out.println(linea);
			}
		}
	}catch(IOException ex) {
		System.out.println(ex.toString());
	}
}
public static void infoContactos(String ruta) {
	String[] contacts= new String[0];
	String linea;
	try (BufferedReader reader= new BufferedReader(new FileReader(ruta))){
		while((linea= reader.readLine())!=null) {
			contacts= Arrays.copyOf(contacts,contacts.length+1);
			contacts[contacts.length-1]=linea;
		}
	}catch(IOException ex) {
		System.out.println(ex.toString());
	}finally {
		Arrays.sort(contacts);
		for(int i=0;i<contacts.length;i++) {
			System.out.println(contacts[i]);
		}
	}
}
public static void ejercicio4() {
	Cliente[] clientes= new Cliente[0];
	int a;
	BufferedReader reader=null;
	String linea;
	String ruta="C:/Users/Alumno/Desktop/clientes.txt";
	String[] client=new String[4];
	File f= new File(ruta);
	if(!f.exists()) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	try {
		reader= new BufferedReader(new FileReader(ruta));
		while((linea=reader.readLine())!=null) {
			Cliente cliente=new Cliente();
			client= linea.split(";");
			if(client.length>1) {
			cliente.DNI=client[0];
			cliente.nombreCompleto=client[1];
			cliente.fechaNacimiento=client[2];
			cliente.saldo=Double.valueOf(client[3]);
			clientes= Arrays.copyOf(clientes, clientes.length+1);
			clientes[clientes.length-1]= cliente;
			}
	}
	}catch(NoSuchElementException ex) {
		System.out.println(ex.toString());
	}
	catch(IOException ex) {
		System.out.println(ex.toString());
	}
	GestorBanco banco= new GestorBanco(clientes);
	do {
		System.out.println("1. Alta cliente\n2. Baja cliente\n3. Listar clientes\n4. Guardar y salir");
		a=banco.getSc().nextInt();
		banco.getSc().nextLine();
		switch(a) {
		case 1:
			banco.altaCliente();
			break;
		case 2:
			banco.bajaCliente();
			break;
		case 3:
			banco.mostrar();
			break;
		case 4: 
			banco.guardar(ruta);
			System.out.println("Adiós!");
			break;
		default:
			System.out.println("Introduce el valor correcto");
			break;
		}
	}while(a!=4);
}

public static void hackingNasa() throws InterruptedException {
	for(int i=0;i<=100;i+=10) {
		System.out.println("Hacking NASA "+i+"%...");
		Thread.sleep(3000);
	}
	System.out.println("NASA has been hacked successfully");
}
}
