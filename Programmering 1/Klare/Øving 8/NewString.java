class NewString {

	String string;

	NewString(String string) {
		this.string = string;
	}

	public String shorten() {
		String letters = "";
		for(String word : this.string.split(" ")) {
			letters += word.charAt(0); // Første bokstav
		}
		return letters;
	}

	public String remove(String c) {
		return this.string.replace(c, "");
	}

	public static void main(String[] args) {
		NewString string = new NewString("Hello Verden! Hello");
		System.out.println(string.shorten());
		System.out.println(string.remove("e"));	
	}

}