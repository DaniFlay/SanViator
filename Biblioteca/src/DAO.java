import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DAO {
	private Connection conexion;
	public DAO() {
		connect();
	}
	public boolean create(Libro l) {
		boolean exito = false;
		try {
			String sql="insert into libro (ISBN,titulo,autor, precio) values (?,?,?,?)";
			PreparedStatement prepared=conexion.prepareStatement(sql);
			prepared.setString(1, l.getISBN());
			prepared.setString(2, l.getTitulo());
			prepared.setString(3, l.getAutor());
			prepared.setDouble(4, l.getPrecio());
			int lineas=prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public Libro buscarPorISBN(String a){
		Libro l=null;
		try {
			String sql="select * from libro where ISBN=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setString(1, a);
			ResultSet result=prepared.executeQuery();
			while(result.next()) {
				l=new Libro(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	public List<Libro> buscarPorTitulo(String a){
		Libro l=null;
		List<Libro> libros= new ArrayList<Libro>();
			try {
				String sql="select * from libro where titulo like ?";
				PreparedStatement prepared= conexion.prepareStatement(sql);
				prepared.setString(1, "%"+a+"%");
				ResultSet result=prepared.executeQuery();
				while(result.next()) {
					l=new Libro(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
					libros.add(l);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libros;
	}
	public List<Libro> buscarPorAutor(String a){
			List<Libro> libros= new ArrayList<Libro>();
			Libro l=null;
			try {
				String sql="select * from libro where autor like ?";
				PreparedStatement prepared= conexion.prepareStatement(sql);
				prepared.setString(1, "%"+a+"%");
				ResultSet result=prepared.executeQuery();
				while(result.next()) {
					l=new Libro(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
					libros.add(l);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libros;
	}	
		
	public List<Libro> buscarPorPrecio(String min,String max){
			List<Libro> libros=new ArrayList<Libro>();
			try {
				String sql="select * from libro where precio between ? and ?";
				PreparedStatement prepared= conexion.prepareStatement(sql);
				prepared.setDouble(1, Double.parseDouble(min));
				prepared.setDouble(2, Double.parseDouble(max));
				ResultSet result=prepared.executeQuery();
				while(result.next()) {
					Libro l=new Libro(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
					libros.add(l);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return libros;
	}
	public boolean update(Libro l) {
		boolean exito =false;
		try {
			String sql="update libro set titulo=?, autor=?, precio=? where ISBN=?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setString(1, l.getTitulo());
			prepared.setString(2, l.getAutor());
			prepared.setDouble(3, l.getPrecio());
			prepared.setString(4, l.getISBN());
			int lineas=prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public boolean delete(String ISBN) {
		boolean exito=false;
		try {
			String sql="delete from libro where ISBN =?";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			prepared.setString(1, ISBN);
			int lineas= prepared.executeUpdate();
			exito=lineas==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	public void mostrar() {
		List<String> autores= new ArrayList<String>();
		List<String> libros= new ArrayList<String>();
		String titulo;
		Iterator<String> iterator=null;
		try {
			String sql="select autor from libro";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			ResultSet result=prepared.executeQuery();
			while(result.next()) {
				autores.add(result.getString(1));
			}
			for(int i=0;i<autores.size();i++) {
				System.out.println(autores.get(i));
				String sql2="select titulo from libro where autor=?";
				PreparedStatement prepared2= conexion.prepareStatement(sql2);
				prepared2.setString(1, autores.get(i));
				ResultSet result2= prepared2.executeQuery();
				while(result2.next()) {
					titulo=result2.getString(1);
					libros.add(titulo);
				}
				iterator=libros.iterator();
				for(int j=0;j<libros.size();j++) {
				System.out.println("\t"+iterator.next());
				}
				libros.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int numero() {
		Libro l=null;
		List<Libro> libros= new ArrayList<Libro>();
		try {
			String sql="select * from libro";
			PreparedStatement prepared= conexion.prepareStatement(sql);
			ResultSet result=prepared.executeQuery();
			while(result.next()) {
				l=new Libro(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4));
				libros.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros.size();
	}
	private void connect() {
		try {
			String url="jdbc:mysql://localhost:3306/libros";
			String user="root";
			String password="Ds120621";
			this.conexion=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
