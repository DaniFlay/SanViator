package HojaTareas8;

public class Triangulo extends Poligono {

	
	public Triangulo(double base, double altura) {
		super(base, altura);
	}
	@Override
	public double area() {
		return (base*altura)/2;
	}

}
