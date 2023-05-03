package HojaTareas8;

import java.util.Arrays;

public abstract class Instrumento {
	public enum Nota{DO, RE, MI, FA, SOL, LA, SI};
	Nota[] melodia= new Nota[0];
	public Instrumento() {}
	public void add(Nota nota) {
		melodia=Arrays.copyOf(melodia, melodia.length+1);
		melodia[melodia.length-1]=nota;
	}
	public abstract void interpretar();
}
