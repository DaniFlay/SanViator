import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hojaTareas6 {

	public static void main(String[] args) {
		ejercicio22();

	}
	public static void ejercicio1() {
		String str="";
		short contador=0;
		char a;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		str= sc.nextLine();
		for(int i=0; i<str.length();i++) {
			a=str.charAt(i);
			if(a==' ') {
				contador++;
			}
		}
		System.out.print("La frase introducida contiene "+contador+" espacios");
		sc.close();
	}
	public static void ejercicio2() {
		String str="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		str= sc.nextLine();
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		sc.close();
	}
	public static void ejercicio3() {
		String str="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		str=sc.nextLine();
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)!='a'&&str.charAt(i)!='e'&&str.charAt(i)!='i'&&str.charAt(i)!='o'&&str.charAt(i)!='u') {
				System.out.print(str.charAt(i));
			}
		}
		sc.close();
	}
	public static void ejercicio4() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase= sc.nextLine();
		System.out.println("Introduce la palabra buscada: ");
		String palabra= sc.nextLine();
		System.out.print("Tu palabra aparece "+contarPalabras(frase,palabra)+" veces");
		sc.close();
	}
	
	public static int contarPalabras(String frase, String palabra) {
		short contador=0;
		String[] palabras= frase.split("[ ,.?!]");
		for(int i=0; i<palabras.length;i++) {
			if(palabras[i].equals(palabra)) {
				contador++;
			}
		}
		return contador;
	}
	
	public static void ejercicio5() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce la primera palabra: ");
		String palabra1= sc.nextLine();
		System.out.println("Introduce la segunda palabra: ");
		String palabra2= sc.nextLine();
		boolean a= anagramas(palabra1,palabra2);
		if(a==true) {
			System.out.println("Las palabras son anagramas");
		}
		else {
			System.out.println("Las palabras no son anagramas");
		}
		sc.close();
	}
	
	public static boolean anagramas(String palabra1, String palabra2) {
		boolean c;
		char[] a= palabra1.toCharArray();
		char[] b= palabra2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(Arrays.equals(a, b)) {
			c=true;
			}
		else {
			c=false;
		}
		return c;
	}
	public static void ejercicio6() {
		Scanner sc= new Scanner(System.in);
		int x=0, contador=0;
		System.out.println("Introduce el texto");
		String texto=sc.nextLine();
		texto=texto.toLowerCase();
		char[] textoEntero= texto.toCharArray();
		char[] caracteres= new char[x];
		Arrays.sort(textoEntero);
		for(int i=0;i<textoEntero.length-1;i++) {
			if(textoEntero[i]!=textoEntero[i+1]) {
				caracteres= Arrays.copyOf(caracteres, caracteres.length+1);
				caracteres[x]=textoEntero[i];
				x++;
			}
		}
		if(textoEntero[textoEntero.length-2]==textoEntero[textoEntero.length-1]) {
			caracteres= Arrays.copyOf(caracteres, caracteres.length+1);
			caracteres[x]=textoEntero[textoEntero.length-2];
		}
		x=0;
		for(int i=0; i<caracteres.length;i++) {
			for(int j=0;j<textoEntero.length;j++) {
				if(caracteres[i]==textoEntero[j]) {
					contador++;
				}
			}
			System.out.println("La letra "+caracteres[i]+" aparece "+contador+" vece(s)");
			contador=0;
		}
		sc.close();
	}
	public static void ejercicio7() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce el texto: ");
		String texto= sc.nextLine();
		System.out.println("Introduce la palabra a cambiar: ");
		String palabraVieja= sc.nextLine();
		System.out.println("Introduce la nueva palabra: ");
		String palabraNueva= sc.nextLine();
		System.out.println(replace(texto,palabraVieja,palabraNueva));
		sc.close();
	}
	public static String replace(String texto, String palabraVieja, String palabraNueva) {
		String textoNuevo= texto.replace(palabraVieja, palabraNueva);
		return textoNuevo;
	}
	public static void ejercicio8() {
		Scanner sc= new Scanner(System.in);
		String textoOrdenado="";
		System.out.println("Introduce el texto: ");
		String textoAntiguo= sc.nextLine();
		String [] partes= textoAntiguo.split("[ ,.!?¿¡]");
		Arrays.sort(partes);
		for(int i=0; i<partes.length;i++) {
			textoOrdenado+=partes[i]+" ";
		}
		System.out.println(textoOrdenado);
		sc.close();
	}
	public static void ejercicio9() {
		Scanner sc= new Scanner(System.in);
		String[] lista= new String[0];
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
			lista=newContact(lista, contacto);
			break;
		case 2:
			System.out.println("Introduce el nombre del contacto: ");
			contacto=sc.nextLine();
			buscarContacto(lista, contacto);
			break;
		case 3:
			infoContactos(lista);
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
	public static String[] newContact(String[] lista, String contacto) {
		lista=Arrays.copyOf(lista, lista.length+1);
		lista[lista.length-1]=contacto;
		return lista;
	}
	public static void buscarContacto(String[] lista, String nombre) {
		for(int i=0; i<lista.length;i++) {
			boolean x= lista[i].regionMatches(0, nombre, 0, nombre.length());
			if(x==true) {
				System.out.println(lista[i]);
			}
		}
	}
	public static void infoContactos(String[] lista) {
		for(int i=0; i<lista.length;i++) {
			System.out.println(lista[i]);
		}
	}
	public static void ejercicio10() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número: ");
		tablaDeMultiplicar(sc.nextInt());
		sc.close();
	}
	public static void tablaDeMultiplicar(int numero) {
		System.out.print("<!DOCTYPE html>\n<html lang=\"es\">\n<head>"
				+ "\n\t<title>Tabla de Multiplicar</title>\n</head>"
				+ "\n<style>\n\ttable, th, td {\n\t\tborder:1px solid black;\n\t}\n"
				+ "</style>\n<body>\n\t<table>\n\t\t<tr>\n\t\t\t<th>Operación</th>\n"
				+ "\t\t\t<th>Resultado</th>\n\t\t</tr>\n");
		for(int i=1;i<11;i++) {
			System.out.print("\t\t<tr>\n");
			System.out.print("\t\t\t<td>"+numero+"x"+i+"</td>\n");
			System.out.print("\t\t\t<td>"+(numero*i)+"</td>\n");
			System.out.print("\t\t</tr>\n");
		}
		System.out.print("\t</table>\n</body>\n</html>");
	}
	public static void ejercicio11() {
		String jugador1,jugador2, palabra;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del primer jugador: ");
		jugador1=sc.nextLine();
		System.out.println("Introduce el nombre del segundo jugador: ");
		jugador2=sc.nextLine();
		System.out.println(jugador1+" Introduce la palabra secreta:  ");
		palabra= sc.nextLine();
		ahorcado(jugador1,jugador2,palabra);
		sc.close();
	}
	public static void ahorcado(String nombre1, String nombre2, String palabra) {
		Scanner sc=new Scanner(System.in);
		char letra;
		byte paso=-1, contador=1;
		char[] tabla= palabra.toCharArray();
		char[] palabraAcertada=new char[0];
		for(int i=0;i<palabra.length();i++) {
			palabraAcertada=Arrays.copyOf(palabraAcertada, palabraAcertada.length+1);
			palabraAcertada[i]='_';
		}
		for(int i=0; i<palabraAcertada.length;i++) {
			System.out.print(palabraAcertada[i]+" ");
		}
		while(true) {
			contador=0;
			System.out.print("\n");
			System.out.println("Introduce la letra: ");
			letra=sc.next().charAt(0);
			for(int p=0;p<tabla.length;p++) {
				if(tabla[p]==letra) {
					
					palabraAcertada[p]=tabla[p];
					contador++;
				}
			}
			for(int i=0; i<palabraAcertada.length;i++) {
				System.out.print(palabraAcertada[i]+" ");
				
			}
			System.out.print("\n");
			if(contador==0) {
				paso++;
				System.out.println(dibujarAhorcado(paso));
			}
			else if(contador!=0&&paso==-1){
				continue;
			}
			else {
				System.out.println(dibujarAhorcado(paso));
			}
			contador=0;
			if(Arrays.equals(palabraAcertada, tabla)||paso==11) {
				break;
			}
		}
		if(Arrays.equals(palabraAcertada, tabla)) {
			System.out.println(nombre2+" es ganador");
		}
		else {
			System.out.println(nombre1+" es ganador");
		}
		sc.close();
	}
	public static String dibujarAhorcado(byte paso) {
		String[] pasos=new String[12];
		pasos[0]=" ____";
		pasos[1]="|\n|\n|\n|\n|\n|____";
		pasos[2]=" ___\n|\n|\n|\n|\n|\n|____";
		pasos[3]=" ___\n|/\n|\n|\n|\n|\n|____";		
		pasos[4]=" ___\n|/  |\n|\n|\n|\n|\n|____";		
		pasos[5]=" ___\n|/  |\n|   0\n|   \n|\n|\n|____";
		pasos[6]=" ___\n|/  |\n|   0\n|   |\n|\n|\n|____";
		pasos[7]=" ___\n|/  |\n|   0\n|  /|\n|\n|\n|____";		
		pasos[8]=" ___\n|/  |\n|   0\n|  /|\\\n|\n|\n|____";		
		pasos[9]=" ___\n|/  |\n|   0\n|  /|\\\n|   |\n|\n|____";		
		pasos[10]=" ___\n|/  |\n|   0\n|  /|\\\n|  /|\n|\n|____";			
		pasos[11]=" ___\n|/  |\n|   0\n|  /|\\\n|  /|\\\n|\n|____";		
		return pasos[paso];
	}
	public static boolean isIsogram(String word) {
		boolean check= true;
		char[] letters= word.toCharArray();
		for(int i=0; i<letters.length;i++) {
			for(int j=i+1;j<letters.length;j++) {
				if(Character.toLowerCase(letters[i])==Character.toLowerCase(letters[j])) {
					check=false;
					break;
				}
				else if(letters.length==0) {
					break;
				}
			}
		}
		System.out.print("isIsogram "+word+"="+check);
		return check;
	}

	public static void ejercicio20() {
		Pattern pattern= Pattern.compile("^[0-9]{8}[-]{0,1}[A-Za-z]$");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		Matcher match= pattern.matcher(a);
		System.out.print(match.matches());
		sc.close();
	}
	public static void ejercicio21() {
		Scanner sc= new Scanner(System.in);
		String a= sc.nextLine();
		Pattern p= Pattern.compile("^(979)[0-9]{7}$");
		Matcher match=p.matcher(a);
		System.out.print(match.matches());
		sc.close();
	}
	public static void ejercicio22() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce tu fecha de nacimiento: ");
		Pattern p= Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		String a=sc.nextLine();
		Matcher match=p.matcher(a);
		if(match.matches()==true) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String b="24-06-1987";
		LocalDate date1= LocalDate.parse(a, dtf);
		LocalDate date2=LocalDate.parse(b,dtf);
		if(ChronoUnit.DAYS.between(date1, date2)>0) {
			System.out.print("Tienes "+ChronoUnit.DAYS.between(date1, date2)+" días más que Messi");
		}
		else if(ChronoUnit.DAYS.between(date1, date2)<0) {
			System.out.print("Tienes "+Math.abs(ChronoUnit.DAYS.between(date1, date2))+" días menos que Messi");
		}
		else {
			System.out.print("Tienes los mismos días que Messi");
		}
		}
		else {
			System.out.println("Formato de fecha incorrecto!");
		}
		sc.close();
	}
	public static void ejercicio23() {
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Introduce tu fecha de nacimiento: ");
		Pattern p= Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
		String a= sc.nextLine();
		String b="01/01/";
		char[]d= a.toCharArray();
		for(int i=6;i<d.length;i++) {
			b+=d[i];
		}
		Matcher match=p.matcher(a);
		if(match.matches()==true) {
			LocalDate date1=LocalDate.parse(a,dtf);
			LocalDate date2=LocalDate.parse(b,dtf);
			System.out.println("Hay "+Math.abs(ChronoUnit.DAYS.between(date1, date2))+" días entre el 1 de enero y tu cumpleaños");
		}
		sc.close();
	}
	public static void ejercicio24() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce to e-mail: ");
		Pattern p=Pattern.compile("^[A-Za-z0-9+_-]+@(.+)+.com|.es|.net");
		String a=sc.nextLine();
		Matcher match=p.matcher(a);
		if(match.matches()==true) {
			System.out.println("El e-mail es válido");
		}
		else {
			System.out.println("El e-mail NO es válido");
		}
		sc.close();
	}
	public static void ejercicio25() {
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		System.out.println("Introduce una frase: ");
		Pattern p=Pattern.compile("^[A-Z]{1}+[a-z]*$");
		String[] words=sc.nextLine().split(" ");
		for(int i=0;i<words.length;i++) {
			Matcher match=p.matcher(words[i]);
			if(match.matches()==true) {
				check=true;
			}
			else {
				check=false;
			}
		}
		System.out.println(check);
		sc.close();
	}
	public static void ejercicio26() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce tu código postal: ");
		Pattern p=Pattern.compile("^(47)+((00[1-9])|(01[0-7])|(07[0-1])|(080)|(15[1-3])|(197))$");
		Matcher match=p.matcher(sc.nextLine());
		System.out.println(match.matches());
		sc.close();
	}
	public static void j() {
		int counter=0;
		for(int i=0;i<10;i++) {
			System.out.print("("+counter+",'Madera',484,"+i+"),\r\n");
			counter++;
					System.out.print("("+counter+",'Tornillo',398,"+i+"),\r\n");
					counter++;
							System.out.print("("+counter+",'Ventana',157,"+i+"),\r\n");
							counter++;
									System.out.print("("+counter+",'Puerta',490,"+i+"),\r\n");
									counter++;
											System.out.print( "("+counter+",'Volante',156,"+i+"),\r\n");
											counter++;
													System.out.print("("+counter+",'Plastilina',21,"+i+"),\r\n");
													counter++;
															System.out.print( "("+counter+",'Goma',164,"+i+"),\r\n");
															counter++;
																	System.out.print("("+counter+",'Plastico',519,"+i+"),\r\n");
																	counter++;
																			System.out.print( "("+counter+",'Teclado',276,"+i+"),\r\n");
																			counter++;
																					System.out.print( "("+counter+",'Raton',180,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Gatillo',266,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Rifle',231,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Martillo',52,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Hacha',83,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Sierra',461,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Licuadora',314,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Airfryer',69,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Sarten',278,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Frigorifico',114,"+i+"),\r\n");
																					counter++;
																					System.out.print( "("+counter+",'Proyector',978,"+i+"),\r\n");
																					counter++;
																					
		}
	}
	  }
		 


