// Halvor approver dette programmet

public class fib {
	
	static long x = 1;
	static long y = 1;

	public static void main(String []args) {
		
		System.out.println("1");
		System.out.println("1");

		for(int i = 0; i < 90; i++) {

			System.out.println(next());
		
		}

	}

	static long next() {
		long z = x + y;
		x = y;
		y = z;
		return z;
	}

}