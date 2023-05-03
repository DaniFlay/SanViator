
public class Futbolista {
	private String nombre;
	private int edad;
	private double altura;
	private String nombreEquipo;
	
	public Futbolista(String nombre, int edad, double altura, String nombreEquipo) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.nombreEquipo = nombreEquipo;
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
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
}
