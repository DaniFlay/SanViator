package HojaTareas8;

public abstract class Poligono {
	double base;
	double altura;
	public Poligono(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	public abstract double area();
}
