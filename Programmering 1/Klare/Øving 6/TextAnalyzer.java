import java.util.Arrays;


class TextAnalyzer {

	public int[] numberOfChar = new int[30];
	private int length;

	TextAnalyzer(String data) {
		this.length = data.length();
		this.analyze(data.replace(" ", "").toLowerCase());	
	}
	
	private void analyze(String data) {

		for(char c : data.toCharArray()) {

			int code = c - 97;

			if(code >= 0 && code <= 25) {
				this.numberOfChar[code] += 1;
			} else {
				switch(code) {
					case 133:
						this.numberOfChar[26] += 1; // Æ Ø Å
						break;
					
					case 151:
						this.numberOfChar[27] += 1;
						break;

					case 132: 
						this.numberOfChar[28] += 1;
						break;

					default: 
						this.numberOfChar[29] += 1; // Andre

					
				}
			}

		}
	}

	public int numberOfUniqueChar() {
		int j = 0;

		for(int i: this.numberOfChar) {
			if(i != 0) {
				j += 1;
			}
		}

		return j;

	}

	public int getLength() {
		return this.length;
	} 

	public double percentageLetters() {
		return 1 - (double)this.numberOfChar[29] / (double) this.length;
	}

	public int numberOfApearances(char c) {
		int code = c - 97;
		if(code >= 0 && code <= 25) {

				return this.numberOfChar[code];

			} else {

				switch(code) {
					case 133:	// Æ
						return this.numberOfChar[26];
						
					case 151: // Ø 
						return this.numberOfChar[27];

					case 132: // Å
						return this.numberOfChar[28];

					default: 
						return -1;
				}

			}

	}

	public int[] mostApearances() {
		int[] max = new int[1];

		// Algorytme jeg laget, ikke døm, ble vanskelig å lese fordi jeg bruker primitive datatyper

		for(int i = 0; i < this.numberOfChar.length - 1; i++) { // -1 for å ikke inkludere tegn

			if(numberOfChar[max[0]] < numberOfChar[i]) { // hvis du finner noe større en tidligere max
				max = new int[1];
				max[0] = i;	// lag en ny toppliste 
			}

			else if(numberOfChar[max[0]] == numberOfChar[i]) { // hvis den er samme som maximum
				int[] newMax = new int[max.length + 1];

				for(int j = 0; j < max.length; j++) {
					newMax[j] = max[j];
				}

				newMax[newMax.length - 1] = i;
				max = newMax;// Ggjør listen med maksimum lengere
			}
		}

		return max;
	}

}