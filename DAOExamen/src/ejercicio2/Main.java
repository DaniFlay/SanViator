package ejercicio2;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Empleado e1=new Empleado("Juana","informatica","Valladolid",30,2000);
		Empleado e2=new Empleado("Daniel","informatica","Valladolid",23,2500);
		Empleado e3=new Empleado("JuanRa","informatica","Burgos",21,1800);
		Empleado e4=new Empleado("Alex","ventas","Valladolid",28,1900);
		Empleado e5=new Empleado("Marta","ventas","Valladolid",25,1500);
		
		GestorEmpleados gestor= new GestorEmpleados();
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("gestorEmpleados");
		EntityManager em= factory.createEntityManager();
		gestor.insertar(em, e1);
		gestor.insertar(em, e2);
		gestor.insertar(em, e3);
		gestor.insertar(em, e4);
		gestor.insertar(em, e5);
		
		gestor.actualizarSueldo(em,"informatica", "valladolid", 15);
		
		List<Empleado> empleados=gestor.todosEmpleados(em, true);
		Iterator<Empleado> iteratorEmpleados= empleados.iterator();
		while(iteratorEmpleados.hasNext()) {
			System.out.println(iteratorEmpleados.next());
		}
	}

}
