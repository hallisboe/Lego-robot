class Game {

	public static void main(String[] args) {
		
		Player playerOne = new Player();
		Player playerTwo = new Player();

		int roundNumber = 1;

		while(true) {

			System.out.println("Round " + roundNumber + " - P1: " + 
				playerOne.getScore() + "	P2: " + playerTwo.getScore());

			playerOne.rollTheDice();

			if(playerOne.isDone()) {

				System.out.println("Spiller 1 vant!");
				break;

			} 

			playerTwo.rollTheDice();

			if(playerTwo.isDone()) {

				System.out.println("Spiller 2 vant");
				break;

			}
			
			roundNumber++;

		}

	}

}