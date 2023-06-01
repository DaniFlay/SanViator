import java.sql.Date;

public class matricula {
	private String dni;
	private String ciclo;
	private String modulo;
	private int curso;
	private Date fecha;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public matricula(String dni, String ciclo, String modulo, int curso, Date fecha) {
		this.dni = dni;
		this.ciclo = ciclo;
		this.modulo = modulo;
		this.curso = curso;
		this.fecha = fecha;
	}
	public matricula() {
	}
	
}
