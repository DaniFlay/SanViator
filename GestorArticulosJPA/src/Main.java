import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("gestorPeriodistas");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		int num;
		do {
			System.out.println("1.Alta de nuevo periodista");
			System.out.println("2.Baja de un periodista");
			System.out.println("3.Nuevo artículo");
			System.out.println("4.Mostrar artículos de un periodista");
			System.out.println("5.Mostrar todos los artículos de un año");
			System.out.println("6.Salir");
			Scanner sc= new Scanner(System.in);
			num= sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1:
				altaPeriodista(sc,manager,transaction);
				break;
			case 2:
				bajaPeriodista(sc,manager,transaction);
				break;
			case 3:
				nuevoArticulo(sc,manager,transaction);
				break;
			case 4:
				articulosPeriodista(sc,manager,transaction);
				break;
			case 5:
				articulosAnyo(sc,manager,transaction);
				break;
			case 6:
				System.out.println("Adiós!");
				break;
			}
		}while(num!=6);
	}
	public static void altaPeriodista(Scanner sc,EntityManager manager,EntityTransaction transaction) {
		System.out.println("Introduce el dni del periodista: ");
		String dni= sc.nextLine();
		System.out.println("Introduce el nombre del periodista: ");
		String nombre= sc.nextLine();
		System.out.println("Introduce el telefono del periodista: ");
		String telefono= sc.nextLine();
		List<Articulo> a= new ArrayList<Articulo>();
		Periodista p= new Periodista(dni,nombre,telefono,a);
		transaction.begin();
		manager.persist(p);
		transaction.commit();
	}
	public static void bajaPeriodista(Scanner sc,EntityManager manager,EntityTransaction transaction) {
		System.out.println("Introduce el dni del periodista: ");
		String dni= sc.nextLine();
		Periodista p=manager.find(Periodista.class, dni);
		if(p!=null) {
			transaction.begin();
			manager.remove(p);
			transaction.commit();
		}
	}
	public static void nuevoArticulo(Scanner sc,EntityManager manager,EntityTransaction transaction) {
		System.out.println("Introduce el título: ");
		String titulo= sc.nextLine();
		System.out.println("Introduce el año: ");
		int anyo=sc.nextInt();
		System.out.println("Introduce el número de palabras: ");
		int nPalabras= sc.nextInt();
		System.out.println("Introduce el dni del periodista: ");
		sc.nextLine();
		String dni=sc.nextLine();		
		Articulo a=new Articulo(titulo,anyo,nPalabras);
		new ArrayList<Articulo>();
		
		Periodista p= manager.find(Periodista.class, dni);

		if(p!=null) {
			List<Articulo> aList=p.getArticulos();
			aList.add(a);
			transaction.begin();
			p.setArticulos(aList);
			transaction.commit();
		}else{
			System.out.println("No se ha encontrado ningún periodista con DNI "+dni);
		}
	}
	public static void articulosPeriodista(Scanner sc,EntityManager manager,EntityTransaction transaction) {
		System.out.println("Introduce el dni: ");
		String dni= sc.nextLine();
		Periodista p= manager.find(Periodista.class, dni);
		List<Articulo> articulos= p.getArticulos();
		ComparacionAnyo a= new ComparacionAnyo();
		ComparacionPalabras q= new ComparacionPalabras();
		Collections.sort(articulos,a.thenComparing(q));
		for(int i=0;i<articulos.size();i++) {
			System.out.println(articulos.get(i));
		}
	}
	public static void articulosAnyo(Scanner sc, EntityManager manager, EntityTransaction transaction) {
		System.out.println("Intrdouce el año: ");
		int anyo= sc.nextInt();
		String jpql= "select p from Periodista p";
		Query q= manager.createQuery(jpql);
		List<Periodista> periodistas = q.getResultList();
		List<periodistaArticulo> listaConjunta= new ArrayList<periodistaArticulo>();
		for(int i=0;i<periodistas.size();i++) {
			List<Articulo> articulos= periodistas.get(i).getArticulos();
			for(int j=0; j<articulos.size();j++) {
				if(articulos.get(j).getAnyo()==anyo) {
					periodistaArticulo a= new periodistaArticulo(periodistas.get(i).getNombre(),articulos.get(j).getTitulo(),articulos.get(j).getnPalabras());
					listaConjunta.add(a);
				}
			}
		}
		comparacionNumero n= new comparacionNumero();
		comparacionNombre m= new comparacionNombre();
		Collections.sort(listaConjunta,m.thenComparing(n));
		for(int i=0;i<listaConjunta.size();i++) {
			System.out.println(listaConjunta.get(i));
		}
	}
}
