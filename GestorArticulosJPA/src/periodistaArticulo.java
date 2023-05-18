
public class periodistaArticulo {
	private String nombre;
	private String titulo;
	private int nPalabras;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getnPalabras() {
		return nPalabras;
	}
	public void setnPalabras(int nPalabras) {
		this.nPalabras = nPalabras;
	}
	public periodistaArticulo(String nombre, String titulo, int nPalabras) {
		this.nombre = nombre;
		this.titulo = titulo;
		this.nPalabras = nPalabras;
	}
	@Override
	public String toString() {
		return "nombre: " + nombre + "\ttitulo: " + titulo + "\tnPalabras: " + nPalabras;
	}
	
	
}
