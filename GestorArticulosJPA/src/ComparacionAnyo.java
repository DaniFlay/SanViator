import java.util.Comparator;

public class ComparacionAnyo implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {
		return o1.getAnyo()-o2.getAnyo();
	}

}
