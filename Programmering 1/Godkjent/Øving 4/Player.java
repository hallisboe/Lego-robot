import java.util.Random;


class Player {

	int score;
	Random dice = new Random();

	Player() {

		score = 0;

	}

	public int getScore() {

		return score;

	}

	public void rollTheDice() {

		score += dice.nextInt(6) + 1; // Returnerer en int mellom 1 og 6
		// Hvis 1 så sett 0
		
	}

	public boolean isDone() {

		if(score < 100) {
			return false;
		}

		return true;

	}


}