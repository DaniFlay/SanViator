package HojaTareas8;

public class Test {

	public static void main(String[] args) {
		try {
		int[] t= {1,2,3};
		
		System.out.println(t[5]);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		}
		System.out.println("hoa");
		
	}

}
