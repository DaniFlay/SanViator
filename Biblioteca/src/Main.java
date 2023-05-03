import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		Scanner sc=new Scanner(System.in);
		DAO dao= new DAO();
		int opcion=0;
		do {
			System.out.println("1-Añadir un nuevo libro");
			System.out.println("2-Modificar un libro");
			System.out.println("3-Buscar un libro por ISBN");
			System.out.println("4-Buscar un libro por autor");
			System.out.println("5-Buscar un libro por título");
			System.out.println("6-Buscar un libro por precio");
			System.out.println("7-Eliminar un libro");
			System.out.println("8-Mostrar todos los libros");
			System.out.println("9-Número de libros");
			System.out.println("10-Salir");
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				anadir(sc,dao);
				break;
			case 2:
				modificar(sc,dao);
				break;
			case 3:
				buscarISBN(sc,dao);
				break;
			case 4:
				buscarAutor(sc,dao);
				break;
			case 5:
				buscarTitulo(sc,dao);
				break;
			case 6:
				buscarPrecio(sc,dao);
				break;
			case 7:
				eliminar(sc,dao);
				break;
			case 8:
				dao.mostrar();
				break;
			case 9:
				System.out.println(dao.numero());
				break;
			case 10:
				System.out.println("Adios!");
				break;
			}
		}while(opcion!=10);
	}
	public static void anadir(Scanner sc,DAO dao) {
		Libro l=null;
		System.out.println("Introduce el ISBN: ");
		String ISBN=sc.nextLine();
		System.out.println("Introduce el titulo: ");
		String titulo=sc.nextLine();
		System.out.println("Introduce el autor: ");
		String autor=sc.nextLine();
		System.out.println("Introduce el precio: ");
		Double precio=sc.nextDouble();
		l=new Libro(ISBN,titulo,autor,precio);
		dao.create(l);
	}
	public static void modificar(Scanner sc,DAO dao) {
		Libro l=null;
		System.out.println("Introduce el ISBN: ");
		String ISBN=sc.nextLine();
		System.out.println("Introduce el titulo: ");
		String titulo=sc.nextLine();
		System.out.println("Introduce el autor: ");
		String autor=sc.nextLine();
		System.out.println("Introduce el precio: ");
		Double precio=sc.nextDouble();
		l=new Libro(ISBN,titulo,autor,precio);
		dao.update(l);
	}
	public static void buscarISBN(Scanner sc,DAO dao) {
		System.out.println("Introduce el ISBN: ");
		String a= sc.nextLine();
		sc.nextLine();
		System.out.println(dao.buscarPorISBN(a));
	}
	public static void buscarAutor(Scanner sc, DAO dao) {
		System.out.println("Introduce el autor: ");
		String a= sc.nextLine();
		for(Libro str:dao.buscarPorAutor(a)) {
			System.out.println(str);
		}
	}
	public static void buscarTitulo(Scanner sc,DAO dao) {
		System.out.println("Introduce el titulo: ");
		String a= sc.nextLine();
		for(Libro str:dao.buscarPorTitulo(a)) {
			System.out.println(str);
		}
	}
	public static void buscarPrecio(Scanner sc,DAO dao) {
		System.out.println("Introduce el precio minimo: ");
		double min=sc.nextDouble();
		System.out.println("Introduce el precio máximo: ");
		double max= sc.nextDouble();
		for(Libro str:dao.buscarPorPrecio(min+"",max+"")) {
			System.out.println(str);
		}
	}
	public static void eliminar(Scanner sc,DAO dao) {
		System.out.println("Introduce el ISBN: ");
		String a= sc.nextLine();
		dao.delete(a);
	}
}
