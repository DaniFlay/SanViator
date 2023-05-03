package HojaTareas8;

public class CajaCarton extends Caja {
	public CajaCarton(int ancho, int alto, int fondo, String etiqueta) {
		super(ancho,alto,fondo,etiqueta);
		try{this.ancho=ancho*100;
		this.alto=alto*100;
		this.fondo=fondo*100;
		if(etiqueta.length()<30) {
			this.etiqueta=etiqueta;
		}
		else {
			throw new EtiquetaNoValida();
		}
		}catch(EtiquetaNoValida ex) {
			System.out.println(ex.toString());
		}
		}
	public double getVolumen() {
		return ((double)this.ancho*(double)this.alto*(double)this.fondo)*0.8;
	}
	public double getSuperficie() {
		return 2*((double)this.alto*(double)this.ancho)+2*((double)this.alto*(double)this.fondo)+2*((double)this.ancho*(double)this.fondo);
	}
}
