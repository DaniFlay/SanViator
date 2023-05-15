import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TenistaDAO {
	private Connection conexion=null;
	public TenistaDAO() {
		conexion=crearConexion();
		
	}
	private Connection crearConexion() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/ATP";
		String user="root";
		String password="Ds120621";
		try {
			DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public boolean crear(Tenista t) {
		int resultado=1;
		String sql= "insert into tenista(idTenista,nombre,fechaNacimientos,puntos,titulosGS) values (?,?,?,?,?)";
		try {
			PreparedStatement prepared=conexion.prepareStatement(sql);
			prepared.setInt(1, t.getIdTenista());
			prepared.setString(2,t.getNombre());
			prepared.setDate(3, t.getFechaNacimiento());
			prepared.setInt(4, t.getPuntos());
			prepared.setInt(5, t.getTitulosGS());
			resultado=prepared.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado==1?true:false;	
	}
	public Tenista leer(int idTenista) {
		Tenista t=null;
		String sql="select * from tenista where idtenista="+idTenista;
		try {
			Statement statement=conexion.createStatement();
			ResultSet result= statement.executeQuery(sql);
			if(result.next()) {
				String nombre=result.getString(2);
				Date fecha= result.getDate(3);
				int puntos= result.getInt(4);
				int titulos=result.getInt(5);
				t= new Tenista(idTenista,nombre,fecha,puntos,titulos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	public boolean actualizar(Tenista t) {
		String sql="update tenista set nombre=?, fechanacimiento=', puntos=?, titulosGS=? where idTenista=?";
		int valores=1;
		try {
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setInt(5, t.getIdTenista());
			prepared.setString(1,t.getNombre());
			prepared.setDate(2, t.getFechaNacimiento());
			prepared.setInt(3, t.getPuntos());
			prepared.setInt(4, t.getTitulosGS());
			valores = prepared.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valores==1?true:false;
	}
	public boolean borrar(int idTenista) {
		String sql="delete from tenista where idtenista="+idTenista;
		int valores=0;
		try {
			Statement statement= conexion.createStatement();
			valores=statement.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return valores==1?true:false;
	}
	public List<Tenista> todosTenistas(boolean ordenPuntos){
		List<Tenista> tenistas=new ArrayList<Tenista>();
		try {
			String sql="select * from tenista order by puntos";
			if(ordenPuntos) {
				sql+=" desc";
			}
			Statement statement= conexion.createStatement();
			ResultSet result= statement.executeQuery(sql);
			while(result.next()) {
				int idTenista= result.getInt(1);
				String nombre= result.getString(2);
				Date fecha= result.getDate(3);
				int puntos= result.getInt(4);
				int titulos= result.getInt(5);
				Tenista t= new Tenista(idTenista,nombre,fecha,puntos,titulos);
				tenistas.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenistas;
		
	}
	public List<Tenista> todosTenistas(int minTitulos,boolean ordenFecha){
		List<Tenista> tenistas=new ArrayList<Tenista>();
		try {
			String sql="select * from tenista where titulosgs >="+minTitulos+" order by fechanacimiento ";
			if(ordenFecha) {
				sql+="desc";
			}
			Statement statement= conexion.createStatement();
			ResultSet result= statement.executeQuery(sql);
			while(result.next()) {
				int idTenista= result.getInt(1);
				String nombre= result.getString(2);
				Date fecha= result.getDate(3);
				int puntos= result.getInt(4);
				int titulos= result.getInt(5);
				Tenista t= new Tenista(idTenista,nombre,fecha,puntos,titulos);
				tenistas.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenistas;
	}
}
