package HojaTareas8;

public class Punto3d extends Punto {
	int z;
	public Punto3d(int x, int y, int z) {
		super(x, y);
		this.z=z;
	}
	public double distancia(Punto3d otroPunto) {
		return Math.sqrt(Math.pow(otroPunto.x-this.x, 2)+(Math.pow(otroPunto.y-this.y, 2))+(Math.pow(otroPunto.z-this.z, 2)));
	}
	public boolean equals(Punto3d otroPunto) {
		boolean check=false;
		if(this.x==otroPunto.x&&this.y==otroPunto.y&&this.z==otroPunto.z) {
			check=true;
		}
		return check;
	}
}
