import java.util.Random;

class myRandom {
	Random random = new Random();
	public int nextInt(int start, int end) {
		return random.nextInt(end - start + 1) + start;
	}

	public double nextDouble(double start, double end) {
		return (random.nextDouble() * (end - start)) + start;	
	}

	public static void main(String[] args) {
		myRandom r = new myRandom();
		System.out.println(r.nextInt(1, 10));
		System.out.println(r.nextDouble(1.0, 10.0));
	}
}