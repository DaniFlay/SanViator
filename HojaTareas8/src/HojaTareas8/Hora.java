package HojaTareas8;

public class Hora {
	protected byte hora;
	protected byte minuto;
	public Hora(byte hora, byte minuto) {
		try {
			if(hora>=0&&hora<=23) {
			this.hora = hora;
			}
			else {
				throw new HoraNoValida();
				//this.hora=0;
			}
			if(minuto>=0&&minuto<=59) {
			this.minuto = minuto;
			}
			else {
				throw new MinutoNoValido();
				//this.minuto=0;
			}
		}catch(HoraNoValida ex) {
			System.out.println(ex.toString());
		}
		catch(MinutoNoValido u) {
			System.out.println(u.toString());
		}
	}
	public void inc() {
		this.minuto++;
	}
	public boolean setMinutos(byte min) {
		boolean check=true;
		if(min>59||min<0) {
			check=false;
		}
		else {
			this.minuto=min;
		}
		return check;
	}
	public boolean setHora(byte hora) {
		boolean check=true;
		if(hora<0||hora>23) {
			check=false;
		}
		else {
			this.hora=hora;
		}
		return check;
	}
	@Override
	public String toString() {
		return  this.hora + ":" + this.minuto;
	}
	
	
}
