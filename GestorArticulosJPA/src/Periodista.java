import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Periodista implements Serializable {
	@Id
	private String dni;
	private String nombre;
	private String telefono;
	@OneToMany (cascade=CascadeType.ALL)
	private List<Articulo> articulos;
	
	public Periodista(String dni, String nombre, String telefono, List<Articulo> articulos) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.articulos = articulos;
	}
	public Periodista() {
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	
	
	
}
