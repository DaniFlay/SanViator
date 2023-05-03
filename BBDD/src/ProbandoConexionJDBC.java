import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProbandoConexionJDBC {

	public static void main(String[] args) {
		try {
			String url="jdbc:mysql://localhost:3306/futbolistasDB";
			String user= "root";
			String password="Ds120621";
			Connection conexion= DriverManager.getConnection(url, user, password);
			Statement sentencia=conexion.createStatement();
			//nombre,edad,altura,nombreEquipo
			
			Futbolista f1=new Futbolista("Cristiano Ronaldo",38,1.87,"Al-Nassr");
			Futbolista f2= new Futbolista("Vini JR",22,1.75,"Real Madrid");
			Futbolista f3= new Futbolista("Federico Valverde",22,1.77,"Real Madrid");
			Futbolista f4= new Futbolista("Eduardo Camavinga",19,1.80,"Real Madrid");
			Futbolista f5= new Futbolista("Karim Benzema",35,1.80,"Real Madrid"); 
			Futbolista f6= new Futbolista("Gonzalo Plata",25,1.75,"Real Valladolid");
			Futbolista f7= new Futbolista("Robert Lewandowski",32,1.85,"FC Barcelona");
			Futbolista f8= new Futbolista("Andres Iniesta",39,1.74,"Kobe");
			Futbolista f9= new Futbolista("Neymar JR",32,1.75,"Paris-Saint Germain");
			Futbolista f10= new Futbolista("Antoine Griezmann",31,1.76,"Atletico Madrid");
			Futbolista[] futbolistas= {f1,f2,f3,f4,f5,f6,f7,f8,f9,f10};
			for(int i=0;i<futbolistas.length;i++) {
				String sql="insert into futbolista (nombre,edad,altura,nombreEquipo) values ('"+futbolistas[i].getNombre()+"',"+futbolistas[i].getEdad()+","+futbolistas[i].getAltura()+",'"+futbolistas[i].getNombreEquipo()+"')";
				sentencia.executeUpdate(sql);
			}
			
			ResultSet resultados= sentencia.executeQuery("select * from futbolista where nombreEquipo='Real Madrid'");
			String nombre,nombreEquipo;
			double altura;
			int edad;
			/*while(resultados.next()) {
				nombre=resultados.getString("nombre");
				edad=resultados.getInt("edad");
				altura = resultados.getDouble("altura");
				nombreEquipo= resultados.getString("nombreEquipo");
				System.out.println(nombre+"\t"+edad+"\t"+altura+"\t"+nombreEquipo+"\t");
			}*/
			String sqlPrepared="select * from futbolista where edad<? and altura>?";
			PreparedStatement p=conexion.prepareStatement(sqlPrepared);
			p.setInt(1, 30);
			p.setDouble(2, 1.75);
			resultados=p.executeQuery();
			while(resultados.next()) {
				nombre=resultados.getString("nombre");
				edad=resultados.getInt("edad");
				altura = resultados.getDouble("altura");
				nombreEquipo= resultados.getString("nombreEquipo");
				System.out.println(nombre+"\t"+edad+"\t"+altura+"\t"+nombreEquipo+"\t");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
