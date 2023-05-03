package HojaTareas8;

public class HoraExacta extends Hora {
	byte segundo;
	public HoraExacta(byte hora, byte minuto, byte segundo) {
		super(hora, minuto);
		this.segundo = segundo;
	}
	public boolean setSegundo(byte segundo) {
		boolean check=true;
		if(segundo<0||segundo>59) {
			check=false;
		}
		else {
			this.segundo=segundo;
		}
		return check;
	}
	public void inc() {
		this.segundo++;
	}
	public boolean equals(HoraExacta hora) {
		boolean check=false;
		if(this.hora==hora.hora&&this.minuto==hora.minuto&&this.segundo==hora.segundo) {
			check=true;
		}
		return check;
	}
}
