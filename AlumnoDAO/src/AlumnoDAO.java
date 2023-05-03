import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AlumnoDAO {
	private Connection conexion;
	
	public AlumnoDAO() {
		connect();
	}
	public boolean create(Alumno alumno) {
		boolean exito =false;
		try {
			String sql= "insert into alumno (ID, nombre,fNacimiento, notaMedia, curso) values (?,?,?,?,?)";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(1, alumno.getID());
			prepared.setString(2, alumno.getNombre());
			prepared.setDate(3, alumno.getfNacimiento());
			prepared.setDouble(4, alumno.getNotaMedia());
			prepared.setString(5, alumno.getCurso());
			int lineas=prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public Alumno read(int ID) {
		Alumno alumno=null;
		try {
			String sql="select * from alumno where ID=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(1, ID);
			ResultSet resultado= prepared.executeQuery();
			if(resultado.next()) {
				int id=resultado.getInt("ID");
				String name= resultado.getString("nombre");
				Date dt =resultado.getDate("fNacimiento");
				double nota=resultado.getDouble("notaMedia");
				String curso=resultado.getString("curso");
				alumno=new Alumno(id,name,dt,nota,curso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumno;
		
	}
	public boolean update(Alumno alumno) {
		boolean exito=false;
		try {
			String sql="update alumno set ID=?, nombre=?, fNacimiento=?, notaMedia=?, curso=? where ID=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(1, alumno.getID());
			prepared.setString(2, alumno.getNombre());
			prepared.setDate(3, alumno.getfNacimiento());
			prepared.setDouble(4, alumno.getNotaMedia());
			prepared.setString(5, alumno.getCurso());
			prepared.setInt(6, alumno.getID());
			int lineas=prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public boolean delete(int id) {
		boolean exito= false;
		try {
			String sql="delete from alumno where ID=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(1, id);
			int lineas= prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public List<Alumno> todosAlumnos(){
		List<Alumno> alumnos= new ArrayList<Alumno>();
		Alumno alumno=null;
		try {
			String sql="select * from alumno";
			Statement query= conexion.createStatement();
			ResultSet resultado= query.executeQuery(sql);
			while(resultado.next()) {
				int id=resultado.getInt("ID");
				String name= resultado.getString("nombre");
				Date dt =resultado.getDate("fNacimiento");
				double nota=resultado.getDouble("notaMedia");
				String curso=resultado.getString("curso");
				alumno=new Alumno(id,name,dt,nota,curso);
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	public List<Alumno> alumnosXCurso(String curso){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno=null;
		try {
			String sql="select * from alumno where curso =?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setString(1, curso);
			ResultSet resultado= prepared.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("ID");
				String name= resultado.getString("nombre");
				Date dt =resultado.getDate("fNacimiento");
				double nota=resultado.getDouble("notaMedia");
				alumno=new Alumno(id,name,dt,nota,curso);
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	public List<Alumno> alumnosEnRango(int notaMin, int notaMax){
		List<Alumno> alumnos= new ArrayList<Alumno>();
		Alumno alumno=null;
		try {
			String sql="select * from alumno where notaMedia>=? and notaMedia<=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(1, notaMin);
			prepared.setInt(2, notaMax);
			ResultSet resultado= prepared.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("ID");
				String name= resultado.getString("nombre");
				Date dt =resultado.getDate("fNacimiento");
				double nota=resultado.getDouble("notaMedia");
				String curso= resultado.getString(5);
				alumno=new Alumno(id,name,dt,nota,curso);
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	private void connect() {
		try {
			String url="jdbc:mysql://localhost:3306/alumnos";
			String user="root";
			String password="Ds120621";
			this.conexion=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void connectOFF() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
