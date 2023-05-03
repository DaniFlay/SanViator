import java.sql.Date;

public class Alumno {
	private int ID;
	private String nombre;
	private Date fNacimiento;
	private double notaMedia;
	private String curso;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Alumno(int iD, String nombre, Date fNacimiento, double notaMedia, String curso) {
		ID = iD;
		this.nombre = nombre;
		this.fNacimiento = fNacimiento;
		this.notaMedia = notaMedia;
		this.curso = curso;
	}
	public Alumno() {
	}
	@Override
	public String toString() {
		return ID + " " + nombre + " " + fNacimiento + " " + notaMedia
				+ " " + curso ;
	}
	
	
}
