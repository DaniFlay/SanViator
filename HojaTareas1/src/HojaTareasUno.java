import java.util.Scanner;

public class HojaTareasUno {

	public static void main(String[] args) {
		ejercicio14();

	}
	
	public static void ejercicio1() {
		Scanner teclado =new Scanner(System.in);
		System.out.println("Introduce un número:");
		int num=teclado.nextInt();
		System.out.println("El número introducido es: "+ num);
		teclado.close();
	}
	public static void ejercicio2() {
		Scanner teclado =new Scanner(System.in);
		System.out.println("Introduce tu edad: ");
		byte edad=teclado.nextByte();
		edad+=3;
		System.out.println("Tendrás " + edad + " años dentro de 3 años. Que mayor! ");
		teclado.close();
	}
	public static void ejercicio3() {
		Scanner teclado =new Scanner(System.in);
		System.out.println("En qué años naciste? ");
		int añoN=teclado.nextInt();
		System.out.println("En qué año estamos? ");
		int añoA=teclado.nextInt();
		int año= (añoA - añoN);
		System.out.println("Tienes " + año + " años");
		teclado.close();
	}
	public static void ejercicio4() {
		Scanner teclado =new Scanner(System.in);
		System.out.println("Introduce la primera nota (con decimales): ");
		float nota1= teclado.nextFloat();
		System.out.println("Introduce la segunda nota (con decimales): ");
		float nota2= teclado.nextFloat();
		System.out.println("Introduce la tercera nota (con decimales): ");
		float nota3= teclado.nextFloat();
		float notaMedia= (nota1+nota2+nota3)/3;
		System.out.println("Tu media es " + notaMedia);
		teclado.close();
	}
	public static void ejercicio5() {
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el radio de la cirunferencia: ");
		double radio=teclado.nextDouble();
		double longitud= Math.PI * (radio * 2);
		double area= Math.PI * ( radio * radio);
		System.out.println("La longitud es " + longitud + "y el área es " + area);
		teclado.close();
	}
	public static void ejercicio6() {
		byte a=17;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce tu edad: ");
		byte edad= teclado.nextByte();
		String valor= edad>a? "mayor": "menor";
		System.out.println("Eres " + valor + " de edad");
		teclado.close();
	}
	public static void ejercicio7() {
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int num= teclado.nextInt();
		String valor= num % 2==0? "PAR" : "IMPAR";
		System.out.println("Tu número es " + valor);
		teclado.close();	
	}
	public static void ejercicio8() {
		boolean tareas,llover,biblioteca,salir;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Has acabado las tareas? (responder true/false)");
		tareas= teclado.nextBoolean();
		System.out.println("Vas a la biblioteca? (responder true/false)");
		biblioteca= teclado.nextBoolean();
		System.out.println("Está lloviendo? (responder true/false)");
		llover= teclado.nextBoolean();
		salir=(!llover&&tareas)||(tareas&&biblioteca)?true:false;
		System.out.println(salir);
		teclado.close();
	}
	public static void ejercicio9() {
		double p,m,t;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Cuantos kilos de peras has vendido en el 1º trimestre?");
		int p1= teclado.nextInt();
		System.out.println("Cuantos kilos de manzanas has vendido en el 1º trimestre?");
		int m1= teclado.nextInt();
		System.out.println("Cuantos kilos de peras has vendido en el 2º trimestre?");
		int p2= teclado.nextInt();
		System.out.println("Cuantos kilos de manzanas has vendido en el 2º trimestre?");
		int m2= teclado.nextInt();
		System.out.println("Cuantos kilos de peras has vendido en el 3º trimestre?");
		int p3= teclado.nextInt();
		System.out.println("Cuantos kilos de manzanas has vendido en el 3º trimestre?");
		int m3= teclado.nextInt();
		System.out.println("Cuantos kilos de peras has vendido en el 4º trimestre?");
		int p4= teclado.nextInt();
		System.out.println("Cuantos kilos de manzanas has vendido en el 4º trimestre?");
		int m4= teclado.nextInt();
		p= (p1+p2+p3+p4) * 1.95;
		m= (m1+m2+m3+m4) * 2.35;
		t= p+m;
		System.out.println("Has obtenido " + p + " euros de beneficios en venta de peras y " + m + " euros de beneficios en venta de manzanas y en total " + t + " euros de beneficios");
		teclado.close();
	}
	public static void ejercicio10() {
		int a=0;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un número:");
		int b= teclado.nextInt();
		int c= b>a? b : -b;
		System.out.println("El valor absoluto del número introducido es " + c);
		teclado.close();
	}
	public static void ejercicio11() {
		double a,b,c,s1,s2;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el valor a:");
		a= teclado.nextDouble();
		System.out.println("Introduce el valor b:");
		b= teclado.nextDouble();
		System.out.println("Introduce el valor c:");
		c= teclado.nextDouble();
		s1= (((-b+(Math.sqrt(b*b-(4*a*c))))/2*a));
		s2= (((-b-(Math.sqrt(b*b-(4*a*c))))/2*a));
		System.out.println("Las soluciones de la ecuación son "+s1+" y "+s2);
		teclado.close();
	}
	public static void ejercicio12() {
		int h,m,s;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el número de segundos:");
		s= teclado.nextInt();
		if(s<60) {
			System.out.println("Son 0 horas, 0 minutos y "+s+" segundos");
		}
		else if(s>=60&&s<3600) {
			int s1=s%60;
			m=s/60;
			System.out.println("Son 0 horas, "+m+" minutos y "+s1+" segundos");
		}
		else{
			int s1=s%60;
			m= s/60;
			int m1= m%60;
			h= m/60;
			System.out.println("Son "+h+" horas "+m1+" minutos y "+s1+" segundos");
			teclado.close();
		}
	}
	public static void ejercicio13() {
		double a,b,area;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce la altura del triangulo:");
		a= teclado.nextDouble();
		System.out.println("Introduce la base del triangulo:");
		b= teclado.nextDouble();
		area= (a*b)/2;
		System.out.println("El área del trangulo es: "+area);
		teclado.close();
	}
	public static void ejercicio14() {
		double pi=15.5,pa=20, d=0.95;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el número de las entradas infantiles:");
		int i= teclado.nextInt();
		System.out.println("Introduce el número de entradas adultas:");
		int a= teclado.nextInt();
		double importe= (i*pi)+(a*pa);
		if(importe>99) {
			importe= importe*d;
			System.out.println("El importe total es de "+importe+" euros");
		}
		else {
			System.out.println("El importe total es de "+importe+" euros");
			teclado.close();
		}
	}
}
