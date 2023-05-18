import java.util.Comparator;

public class comparacionNumero implements Comparator<periodistaArticulo> {

	@Override
	public int compare(periodistaArticulo o1, periodistaArticulo o2) {
		return o1.getnPalabras()-o2.getnPalabras();
	}

}
