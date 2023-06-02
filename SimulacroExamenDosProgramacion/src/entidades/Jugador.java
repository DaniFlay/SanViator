package entidades;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugador implements Serializable{
	@Id
	private String dni;
	private String nombre;
	private int edad;
	private String posicion;
	@ManyToOne
	private Equipo equipo;
	public boolean equals(Jugador j) {
		return this.dni.equalsIgnoreCase(j.getDni());
	}
	public Jugador(String dni, String nombre, int edad, String posicion) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.posicion = posicion;
	}
	public Jugador() {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	@Override
	public String toString() {
		return "Jugador [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", posicion=" + posicion ;
	}
	
	
}
