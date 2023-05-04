
public class Pelicula {
	private String titulo;
	private String tituloOriginal;
	private double punutacion;
	private int anyo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTituloOriginal() {
		return tituloOriginal;
	}
	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}
	public double getPunutacion() {
		return punutacion;
	}
	public void setPunutacion(double punutacion) {
		this.punutacion = punutacion;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public Pelicula(String titulo, String tituloOriginal, double punutacion, int anyo) {
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.punutacion = punutacion;
		this.anyo = anyo;
	}
	public Pelicula() {
	}
	
}
