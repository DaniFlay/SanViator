
public class TestEmpleadoDAO {

	public static void main(String[] args) {
		EmpleadoDAO dao= new EmpleadoDAO();
		Empleado e1= new Empleado("David Perez",25,"365245781");
		Empleado e2= new Empleado("Jualian Gonzalez",40,"741247857");
		Empleado e3= new Empleado("Nuria Laos",23,"743124852");
		Empleado e4= new Empleado("Daniel Juarez",57,"964751285");
		Empleado e5= new Empleado("Manuel Potros",32,"257412864");
		Empleado[] empleados= {e1,e2,e3,e4,e5};
		for(Empleado e:empleados) {
			dao.create(e);
		}
		for(int i=1;i<=5;i++) {
			Empleado e= dao.read(i);
			System.out.println(e.getNombre()+"\t"+e.getEdad()+"\t"+e.getTelefono());
			
		}
		Empleado empleadoAct=dao.read(2);
		Empleado e =new Empleado(empleadoAct.getId(),empleadoAct.getNombre(),empleadoAct.getEdad()+1,empleadoAct.getTelefono());
		dao.update(e);
		dao.delete(2);
	}

}
