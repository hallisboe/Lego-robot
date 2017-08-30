import static javax.swing.JOptionPane.*;

class Prime {

	// Skjekker om et tall er primtall

	public static boolean isPrime(int n) { // Optimalisere?

		for(int i = 2; i < n; i++) {

			if(n % i == 0) {

				return false;

			}

		}

		return true;

	}

	public static void main(String[] args) {

		int input = 0;

		while(true) {

			try {

				input = Integer.parseInt(showInputDialog(null, "Tall å sjekke: "));

			}

			catch(Exception e) {
				showMessageDialog(null, e);
			}

			if(isPrime(input)) {showMessageDialog(null, input + " er et primtall");} 
			else {

				showMessageDialog(null, input + " er ikke et primtall");

			}
		}

	}

}