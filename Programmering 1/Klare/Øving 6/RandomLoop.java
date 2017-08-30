

class RandomLoop {

	public static void main(String[] args) {
		java.util.Random random = new java.util.Random();
		
		int[] numbers = new int[1000];

		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10);
		}

		int[] frequency = new int[10];

		for(int i = 0; i < numbers.length; i++) {
			frequency[numbers[i]] += 1;
		}

		for(int i = 0; i < frequency.length; i++) {
			String stars = "";
			for(int j = (int) Math.round(0.1 * frequency[i]); j > 0; j--) {
				stars += "*";				
			}
			System.out.println(i + " - " + stars + " (" + frequency[i] + ")");
		}


	}
}