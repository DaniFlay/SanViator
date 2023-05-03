package HojaTareas8;

public class Piano extends Instrumento {
	@Override
	public void interpretar() {
		for(int i=0;i<this.melodia.length;i++) {
			System.out.print(this.melodia[i]+" ");
		}
	}

}
