import java.util.Comparator;

public class comparacionNombre implements Comparator<periodistaArticulo> {

	@Override
	public int compare(periodistaArticulo o1, periodistaArticulo o2) {
		
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
