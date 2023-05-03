
public class Libro {
	private String ISBN;
	private String titulo;
	private String autor;
	private double precio;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "ISBN: " + ISBN + "\nTitulo:" + titulo + "\nAutor:" + autor + "\nPrecio:" + precio;
	}
	public Libro(String iSBN, String titulo, String autor, double precio) {
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	
}
