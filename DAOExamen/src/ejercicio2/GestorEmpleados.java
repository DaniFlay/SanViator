package ejercicio2;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class GestorEmpleados {

	public void insertar(EntityManager em,Empleado e ) {
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		em.persist(e);
		tran.commit();
	}
	public boolean borrar(EntityManager em, int idEmpleado) {
		String jpql="delete from empleado e where e.idEmpleado="+idEmpleado;
		Query q=em.createQuery(jpql);
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		int valor=q.executeUpdate();
		tran.commit();
		return valor==1?true:false;
	}
	public boolean borrarV2(EntityManager em, int idEmpleado) {
		boolean borrado=false;
		Empleado e= new Empleado(idEmpleado,"Pepito","Informatica","Valladolid",25,2000);
		Empleado emp=em.find(Empleado.class, e);
		if(emp!=null) {
			EntityTransaction tran= em.getTransaction();
			tran.begin();
			em.remove(emp);
			tran.commit();
			borrado=true;
		}
		return borrado;
	}
	public List<Empleado> buscarNombre(EntityManager em, String nombre){
		String jpql="select e from empleado e where e.nombre like '%"+nombre+"%'";
		Query query= em.createQuery(jpql);
		List<Empleado> empleados= query.getResultList();
		return empleados;
	}
	public List<Empleado> buscarDepartamento(EntityManager em, String departamento){
		Query query= em.createNamedQuery("Empleado.buscarPorDepartamento");
		query.setParameter("departamento", departamento);
		List<Empleado> empleados=query.getResultList();
		return empleados;
	}
	public List<Empleado> todosEmpleados(EntityManager em, boolean orden){
		String jpql= "select e from Empleado e order by e.sueldo ";
		if(orden) {
			jpql+="desc";
		}
		Query query=em.createQuery(jpql);
		List<Empleado> empleados= query.getResultList();
		return empleados;
	} 
	public boolean actualizarSede(EntityManager em,int idEmpleado, String sede) {
		Query query= em.createNamedQuery("Empleado.actualizarSede");
		query.setParameter(1, sede);
		query.setParameter(2, idEmpleado);
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		int valor=query.executeUpdate();
		tran.commit();
		return valor==1?true:false;
	}
	public int actualizarSueldo(EntityManager em,String departamento,String sede, double porcentaje) {
		Query query=em.createNamedQuery("Empleado.actualizarSueldo");
		query.setParameter("departamento", departamento);
		query.setParameter("sede", sede);
		query.setParameter("porcentaje", porcentaje/100);
		EntityTransaction tran= em.getTransaction();
		tran.begin();
		int empleados=query.executeUpdate();
		tran.commit();
		return empleados;
	}
}
