import java.util.Comparator;

public class ComparacionPalabras implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {
		return o1.getnPalabras()-o2.getnPalabras();
	}

}
