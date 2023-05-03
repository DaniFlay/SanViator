import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
	
	private Connection conexion;
	
	
	public EmpleadoDAO() {
		connect();
	}
	public boolean create(Empleado empleado) {
		//Se utilizan statement y prepared statement
		//se obtienen del objeto Connection
		boolean exito=false;
		try {
			/*Statement sentencia= conexion.createStatement();
			String sql= "insert into empleado(nombre,edad,telefono) values ('"+empleado.getNombre()+"',"+empleado.getEdad()+",'"+empleado.getTelefono()+"')";
			int rowsAffected= sentencia.executeUpdate(sql);
			exito=rowsAffected==1?true:false;*/
			String plantillaSQL="insert into empleado (nombre,edad,telefono) values (?,?,?)";
			PreparedStatement prepared= conexion.prepareStatement(plantillaSQL);
			prepared.setString(1, empleado.getNombre());
			prepared.setInt(2, empleado.getEdad());
			prepared.setString(3, empleado.getTelefono());
			//Se utiliza el executeUpdate SIN PARAMETROS
			int lineas=prepared.executeUpdate();
			exito=lineas==1?true:false;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public Empleado read(int idEmpleado) {
		Empleado empleado=null;
		try {
			String plantillaSQL= "select * from empleado where idEmpleado=?";
			PreparedStatement prepared= conexion.prepareStatement(plantillaSQL);
			prepared.setInt(1, idEmpleado);
			ResultSet resultado=prepared.executeQuery();
			if(resultado.next()) {
				// Sacamos las variables, se puede sacar por número de la columna
				//o por el nombre de la columna
				String nombre= resultado.getString(2);
				int edad= resultado.getInt(3);
				String telefono= resultado.getString(4);
				
				empleado=new Empleado(idEmpleado,nombre,edad,telefono);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;
		
	}
	public boolean update(Empleado empleado) {
		boolean exito=false;
		try {
			String plantillaSQL="update empleado set nombre=?, edad=?, telefono=? where idEmpleado=?";
			PreparedStatement prepared=conexion.prepareStatement(plantillaSQL);
			prepared.setString(1, empleado.getNombre());
			prepared.setInt(2,empleado.getEdad());
			prepared.setString(3, empleado.getTelefono());
			prepared.setInt(4, empleado.getId());
			int registrosModificados= prepared.executeUpdate();
			exito =registrosModificados==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public boolean delete(int idEmpleado) {
		boolean exito=false;
		try {
			String plantillaSQL="delete from empleado where idEmpleado=?";
			PreparedStatement prepared=conexion.prepareStatement(plantillaSQL);
			prepared.setInt(1, idEmpleado);
			int registrosModificados= prepared.executeUpdate();
			exito= registrosModificados==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	private void connect() {
		try {
			String url="jdbc:mysql://localhost:3306/empleadosdb";
			String user="root";
			String password="Ds120621";
			this.conexion=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Empleado> getAll(){
		List<Empleado> empleado= new ArrayList<Empleado>();
		try {
			Statement sentencia= conexion.createStatement();
			String sql= "select * from empleado";
			ResultSet resultado= sentencia.executeQuery(sql);
			while(resultado.next()) {
				int idEmpleado= resultado.getInt(1);
				String nombre= resultado.getString(2);
				int edad= resultado.getInt(3);
				String telefono= resultado.getString(4);
				Empleado e= new Empleado(idEmpleado,nombre,edad,telefono);
				empleado.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;
	}
}

