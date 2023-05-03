import java.util.Scanner;

public class HojaTareas3 {

	public static void main(String[] args) {
		ejercicio12();
	}
	public static void ejercicio1() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un número:");
		int a= sc.nextInt();
		while(a!=0) {
			if(a>0) {
				System.out.println("El número es positivo\n");
			}
			else {
				System.out.println("El número es negativo\n");
			}
			if(a%2==0) {
				System.out.println("El número es par\n");
			}
			else {
				System.out.println("El número es impar\n");
			}
			System.out.println("El cuadrado de tu número es: "+Math.pow(a, 2));
		break;
		}
		sc.close();
	}
	public static void ejercicio2() {
		int a=0,b=0, suma=0, mayor=0, media=0;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("Introduce la edad del alumno: ");
			b= sc.nextInt();
			if(b>=0) {
				if(b>=18) {
					mayor++;
				}
				suma=suma+b;
				a++;
				media=suma/a;
			}
		}while(b>=0);
		System.out.println("La suma de las edades de los alumnos es: "+suma+"\n"+"Hay "+mayor+" mayores de edad\n"+"La media de las edades es: "+media+"\nEl número de los alumnos es: "+a);
		sc.close();
	}
	public static void ejercicio3() {
		int n1,n2;
		n1= (int)(Math.random()*100+1);
		Scanner sc= new Scanner(System.in);
		do {
		System.out.println("Adivina el número");
		n2=sc.nextInt();
		if(n2<n1&&n2!=-1) {
				System.out.println("Tu número es menor:");
			}
			else if(n2>n1&&n2!=-1){
				System.out.println("Tu número es mayor");
			}
			}while(n2!=n1&&n2!=-1);
		if(n2==n1) {
			System.out.println("Has acertado el número");
		}
		else if(n2==-1){
			System.out.println("Te has rendido");
	}
		sc.close();
	}
	public static void ejercicio4() {
		int altura=0, contador1=0,contador2=0, alto=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Introduce la altura del árbol");
			altura= sc.nextInt();
			if(altura>alto) {
				alto=altura;
				contador2=contador1;
			}
			contador1++;
		}while(altura!=-1);
		System.out.println("El árbol más alto es el número "+contador2+" y tiene la altura de "+alto);
		sc.close();
	}
	public static void ejercicio5() {
		int contador=0, n1=0, n2=0, n3=0;
		Scanner sc= new Scanner(System.in);
		do{
			n1= (int)(Math.random()*100+1);
			n2= (int)(Math.random()*100+1);
			System.out.println(n1+"+"+n2+"=");
			n3= sc.nextInt();
			if(n3==n1+n2) {
				contador++;
			}
		}while(n3==n1+n2);
	System.out.println("Respuestas correctas: "+contador);
		sc.close();
	}
	public static void ejercicio6() {
		int contador=0;
		for(contador=0;contador<100;contador++) {
			if(contador%2==0&&contador%3==0&&contador%8!=0) {
				System.out.println(contador);
			}
		}
		
	}
	public static void ejercicio7() {
		int contador=0;
		for(contador=0;contador<100;contador++) {
			if(contador%7==0) {
				System.out.println(contador);
			}
		}
}
	public static void ejercicio8() {
		int n1=0, n2=1;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un número: ");
		n1=sc.nextInt();
		for(int contador=1; contador<=n1;contador++) {
			n2=n2*contador;
		}
		System.out.println("El factorial de tu número es: "+n2);
		sc.close();
	}
	public static void ejercicio9() {
		int s=0,a=0,n=0,sb=0,i=0;
		float nota;
		Scanner sc= new Scanner(System.in);
		
		for(i=0; i<6;i++) {
			System.out.println("Introduce la nota: ");
			nota= sc.nextFloat();
			if(nota<5&&nota>=0){
				s++;
			}
			else if(nota>=5&&nota<7) {
				a++;
			}
			else if(nota>=7&&nota<9) {
				n++;
			}
			else if(nota>=9&&nota<=10) {
				sb++;
			}
			else {
				System.out.println("Nota inválida");
				i--;
				continue;
			}
			
		}
			System.out.println("Suspensos: "+s+"\nAprobados: "+a+"\nNotable: "+n+"\nSobresalientes: "+sb);
			sc.close();
	}
	public static void ejercicio10() {
		int n=0,r=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un número: ");
		n=sc.nextInt();
		do {
			r=n%2;
			n=n/2;
			System.out.print(r);			
		}while(n>1);
		System.out.print("1");
		sc.close();
	}
	public static void ejercicio11() {
		int p=0, n=0, j=2,pr=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un número: ");
		n=sc.nextInt();
		for(int i=2;i<=n;i++) {
			for(j=1;j<=i;j++) {
			if(i%j==0) {
				p++;
			}
			}
			if(p==2) {
				pr++;
			}
			p=0;
		}
		System.out.println(pr);
		sc.close();
	}
	public static void ejercicio12() {
		int n=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce un número: ");
		n=sc.nextInt();
		for(int i=0;i<=n;i++) {
			for(int z=n;z>i;z--) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
		sc.close();
	}
	}

