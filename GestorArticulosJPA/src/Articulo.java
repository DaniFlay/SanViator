import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Articulo implements Comparable<Articulo>, Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private int anyo;
	private int nPalabras;
	
	public Articulo(String titulo, int anyo, int nPalabras, Periodista periodista) {
		this.titulo = titulo;
		this.anyo = anyo;
		this.nPalabras = nPalabras;

	}
	public Articulo(String titulo, int anyo, int nPalabras) {
		this.titulo = titulo;
		this.anyo = anyo;
		this.nPalabras = nPalabras;
	}
	public Articulo() {
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getnPalabras() {
		return nPalabras;
	}
	public void setnPalabras(int nPalabras) {
		this.nPalabras = nPalabras;
	}
	@Override
	public String toString() {
		return "Articulo:"+ id + "\ttitulo=" + titulo + "\tanyo=" + anyo + "\tnPalabras=" + nPalabras ;
	}
	@Override
	public int compareTo(Articulo o) {
		return this.titulo.compareToIgnoreCase(o.getTitulo());
	}
	
	
}
