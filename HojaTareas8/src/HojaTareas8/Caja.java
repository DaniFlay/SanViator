package HojaTareas8;

public class Caja {
	protected int ancho;
	protected int alto;
	protected int fondo;
	protected String etiqueta;
	public Caja(int ancho, int alto, int fondo, String etiqueta) {
		try {
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		if(etiqueta.length()<30) {
			this.etiqueta = etiqueta;
		}
			throw new EtiquetaNoValida();
		}catch(EtiquetaNoValida ex) {
			System.out.println(ex.toString());
		}
	}
	public double getVolumen() {
		return (double)this.ancho*(double)this.alto*(double)this.fondo;
	}
	public boolean setEtiqueta(String etiqueta) {
		boolean check =false;
		try {
			if(etiqueta.length()<30) {
				this.etiqueta = etiqueta;
				check=true;
			}
				throw new EtiquetaNoValida();
			}catch(EtiquetaNoValida ex) {
				System.out.println(ex.toString());
			}
		return check;
		}
	@Override
	public String toString() {
		return "Datos de la caja:"+"\nancho=" + ancho + "\nalto=" + alto + "\nfondo=" + fondo + "\netiqueta=" + etiqueta;
	}
	
	}

