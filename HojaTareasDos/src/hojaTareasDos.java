import java.util.Scanner;

public class hojaTareasDos {

	public static void main(String[] args) {
		ejercicio13();

	}
	public static void ejercicio1() {
		int num1,num2;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introdcue un número:");
		num1= teclado.nextInt();
		System.out.println("Introduce otro número:");
		num2= teclado.nextInt();
		if(num1==num2) {
			System.out.println("Los números introducidos son iguales");
		}
		else {
			System.out.println("Los números introducidos son disntintos");
		}
		teclado.close();	
	}
	public static void ejercicio2() {
		int num1,num2;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un número:");
		num1= teclado.nextInt();
		System.out.println("Introduce otro número (distinto):");
		num2= teclado.nextInt();
		if(num1==num2) {
			System.out.println("Los números introducidos son iguales");
		}
		else if(num1<num2) {
			System.out.println("El número mayor es"+num2);
		}
		else {
			System.out.println("El número mayor es"+num1);
		}
		teclado.close();
	}
	public static void ejercicio3() {
		int num1,num2,num3,l,m,s;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un número:");
		num1= teclado.nextInt();
		System.out.println("Introduce otro número:");
		num2= teclado.nextInt();
		System.out.println("Introduce un tercer número:");
		num3= teclado.nextInt();
		if(num1>num2&&num1>num3){
			l=num1;
			System.out.println(l);
		}
		else if(num2>num1&&num2>num3) {
			l=num2;
			System.out.println(l);
		}
		else if(num3>num2&&num3>num1) {
			l=num3;
			System.out.println(l);
		}
		if(num1<num2&&num1>num3||num1<num3&&num1>num2) {
			m=num1;
			System.out.println(m);
		}
		else if(num2<num1&&num2>num3||num2>num1&&num2<num3) {
			m=num2;
			System.out.println(m);
		}
		else if(num3<num1&&num3>num2||num3>num1&&num3<num2) {
			m=num3;
			System.out.println(m);
		}
		if(num1<num2&&num1<num3) {
			s=num1;
			System.out.println(s);
		}
		else if(num2<num1&&num2<num3) {
			s=num2;
			System.out.println(s);
		}
		else if(num3<num2&&num3<num1) {
			s=num3;	
			System.out.println(s);
		}		
		teclado.close();
	}
	public static void ejercicio4(){
		int a,b,c;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el primer coeficiente:");
		a= teclado.nextInt();
		System.out.println("Introduce el segundo coeficiente:");
		b= teclado.nextInt();
		System.out.println("Introduce el tercer coeficiente:");
		c=teclado.nextInt();
		double d= (Math.pow(b,2)) - ((4*a*c));
		if(d>0) {
			double s1= ((-b+Math.sqrt(d))/(2*a));
			double s2= ((-b-Math.sqrt(d))/(2*a));
			System.out.println("La ecuación tiene 2 solcuiones distintas, y son "+s1+" y "+s2);
		}
		else if(d==0) {
			double s= (-b/2*a);
			System.out.println("La ecuación tiene 2 soluciones iguales y es"+s);
		}
		else {
			System.out.println("La ecuación no tiene ninguna solución real");
		}
		teclado.close();
	}
	public static void ejercicio5() {
		int num;
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un número:");
		num= teclado.nextInt();
		if(num>=0&&num<10) {
			System.out.println("El número introducido tiene 1 cifra");
		}
		else if(num>=10&&num<100) {
			System.out.println("El número introducido tiene 2 cifras");
		}
		else if(num>=100&&num<1000) {
			System.out.println("El número introducido tiene 3 cirfas");
		}
		else if(num>=1000&&num<10000) {
			System.out.println("El número introducido tiene 4 cirfas");
		}
		else if(num>=10000&&num<100000) {
			System.out.println("El número introducido tiene 5 cifras");
		}
		else {
			System.out.println("ERROR! Tienes que introducir un número entre 0 y 99.999");
		}
		teclado.close();
	}
	public static void ejercicio6() {
		int nota;
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce tu nota:");
		nota= teclado.nextInt();
		if(nota>=0&&nota<5) {
			System.out.println("Tienes un suspenso");
		}
		else if(nota==5) {
			System.out.println("Tienes un aprobado");
		}
		else if(nota==6) {
			System.out.println("Tienes un bien");
		}
		else if(nota==7||nota==8) {
			System.out.println("Tienes un notable");
		}
		else if(nota==9||nota==10) {
			System.out.println("Tienes un sobresaliente");
		}
		else {
			System.out.println("La nota introducida no es válida");
		}
		teclado.close();
	}
	public static void ejercicio7() {
		int día;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un número entre 1 y 7:");
		día= teclado.nextInt();
		if(día==1) {
			System.out.println("Es lunes");
		}
		else if(día==2) {
			System.out.println("Es martes");
		}
		else if(día==3) {
			System.out.println("Es miércoles");
		}
		else if(día==4) {
			System.out.println("Es jueves");
		}
		else if(día==5) {
			System.out.println("Es viernes");
		}
		else if(día==6) {
			System.out.println("Es sábado");
		}
		else if(día==7) {
			System.out.println("Es domingo");
		}
		else {
			System.out.println("El número introducido no es válido");
		}
		teclado.close();
	}
	public static void ejercicio8(){
		int d,m,a;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el día:");
		d= teclado.nextInt();
		if(d<1||d>31) {
			System.out.println("Día introducido fuera del rango");
		}
		System.out.println("Introduce el número del mes (1-12):");
		m= teclado.nextInt();
		if(m<1||m>12) {
			System.out.println("El mes introducido fuera del rango");
		}
		System.out.println("Introduce el año:");
		a= teclado.nextInt();
		if(d>=1&&d<=29&&m!=2||d>=1&&d<=27) {
			d+=1;
			System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
		}
		else if(d==28&&m==2) {
			m=3;
			d=1;
			System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
		}
		else if(d==30) {
			if(m==1||m==3||m==5||m==7||m==8||m==10||m==12) {
			d+=1;
			System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
			}
			else if(m==2) {
				System.out.println("Fecha fuera del rango");
			}
			else {
				d=1;
				m+=1;
				System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
			}	
		}
		else if(d==31) {
			if(m==1||m==3||m==5||m==7||m==8||m==10||m==12) {
				m+=1;
				d=1;
				System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
			}
			else {
				System.out.println("Fecha fuera del rango");
			}
		
		}
		else if(d==31&&m==12) {
			a+=1;
			m=1;
			d=1;
			System.out.println("La fecha del día siguiente es: "+d+"/"+m+"/"+a);
		}
		teclado.close();
}
	public static void ejercicio9() {
		int h,m,s;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce la hora:");
		h= teclado.nextInt();
		if(h<0||h>23) {
			System.out.println("La hora fuera del rango");
		}
		System.out.println("Introduce los minutos:");
		m= teclado.nextInt();
		if(m<0||m>59) {
			System.out.println("Los minutos fuera del rango");
		}
		System.out.println("Instroduce los segundos:");
		s= teclado.nextInt();
		if(s<0||s>59) {
			System.out.println("Los segundos fuera del rango");
		}
		if(s<55) {
			s+=5;
			System.out.println("La hora dentro de 5 segundos es: "+h+" horas "+m+" minutos y "+s+" segundos");
		}
		else {
			m+=1;
			int s1=60%s;
			s=0-s1+5;
			if(m<60) {
			System.out.println("La hora dentro de 5 segundos es: "+h+" horas "+m+" minutos y "+s+" segundos");
		
			}
			else {
				h+=1;
				if(h<22) {
				m=0;
				System.out.println("La hora dentro de 5 segundos es: "+h+" horas "+m+" minutos y "+s+" segundos");
				}
				else {
					h=0;
					m=0;
					System.out.println("La hora dentro de 5 segundos es: "+h+" horas "+m+" minutos y "+s+" segundos");
				}
				}
	}
		teclado.close();
}
	public static void ejercicio10() {
		long dni;
		char letra;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el DNI:");
		dni= teclado.nextLong();
		if(dni%23==0) {
			letra='T';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==1) {
			letra='R';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==2) {
			letra='W';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==3) {
			letra='A';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==4) {
			letra='G';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==5) {
			letra='M';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==6) {
			letra='Y';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==7) {
			letra='F';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==8) {
			letra='P';
			System.out.println("La letra de tu DNI es: "+letra);
		}else if(dni%23==9) {
			letra='D';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==10) {
			letra='X';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==11) {
			letra='B';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==12) {
			letra='N';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==13) {
			letra='J';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==14) {
			letra='Z';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==15) {
			letra='S';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==16) {
			letra='Q';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==17) {
			letra='V';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==18) {
			letra='H';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==19) {
			letra='L';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==20) {
			letra='C';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==21) {
			letra='K';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else if(dni%23==22) {
			letra='E';
			System.out.println("La letra de tu DNI es: "+letra);
		}
		else {
			System.out.println("ERROR! Algo ha ido mal");
		}
		teclado.close();
	}
	public static void ejercicio11() {
		int n1,n2,n3;
		n1= (int)(Math.random()*99+1);
		n2= (int)(Math.random()*99+1);
		System.out.println(n1+"+"+n2+"= ");
		Scanner teclado=new Scanner(System.in);
		n3= teclado.nextInt();
		if(n3==n1+n2) {
			System.out.println("El resultado es correcto");
		}
		else {
			System.out.println("El resultado es incorrecto");
		}
		teclado.close();
	}
	public static void ejercicio12() {
		int n1;
		System.out.println("Introduce un número: ");
		Scanner teclado= new Scanner(System.in);
		n1= teclado.nextInt();
		n1= n1>=0? n1 : -n1;
		System.out.println("EL valor absoluto de tu número es: "+n1);
		teclado.close();
	}
	public static void ejercicio13() {
		int n1,n2,n3,n4;
		n1= (int)(Math.random()*99+1);
		n2=(int)(Math.random()*99+1);
		n3=(int)(Math.random()*4);
		Scanner teclado= new Scanner(System.in);
		if(n3==0) {
			System.out.println(n1+"+"+n2+"=");
			n4=teclado.nextInt();
			if(n4==n1+n2) {
				System.out.println("La respuesta es correcta");
			}
			else {
				System.out.println("La respuesta es incorrecta");
			}
		}
		else if(n3==1) {
			System.out.println(n1+"-"+n2+"=");
			n4=teclado.nextInt();
			if(n4==n1-n2) {
				System.out.println("La respuesta es correcta");
			}
			else {
				System.out.println("La respuesta es incorrecta");
			}
		}
		else if(n3==2) {
			System.out.println(n1+"*"+n2+"=");
			n4=teclado.nextInt();
			if(n4==n1*n2) {
				System.out.println("La respuesta es correcta");
			}
			else {
				System.out.println("La respuesta es incorrecta");
				}
		}
		else if(n3==3) {
				System.out.println(n1+"/"+n2+"=");
				n4=teclado.nextInt();
				if(n4==n1/n2) {
					System.out.println("La respuesta es correcta");
					}
				else {
					System.out.println("La respuesta es incorrecta");
					}		
		}
		teclado.close();
	}
}



	
