package HojaTareas8;

public class Punto {
	int x;
	int y;
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double distancia(Punto otroPunto) {
		return Math.sqrt(Math.pow(otroPunto.x-this.x, 2)+(Math.pow(otroPunto.y-this.y, 2)));
	}
	public boolean equals(Punto otroPunto) {
		boolean check=false;
		if(this.x==otroPunto.x&&this.y==otroPunto.y) {
			check=true;
		}
		return check;
	}
	
}
