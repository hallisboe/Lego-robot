class Fraction {
	
	int numerator;
	int denominator;

	Fraction(int n, int d) {
		if(d == 0) {
			throw new IllegalArgumentException();
		}
		this.numerator = n;
		this.denominator = d;
	}

	public int getNomerator() {
		return this.numerator;
	}


	public int getDenominator() {
		return this.denominator;
	}

	private void expand(int i) {
		this.numerator *= i;
		this.denominator *= i;
	}

	private void flip() {
		int temp = this.numerator;
		this.numerator = this.denominator;
		this.denominator = temp;
	}

	private void shorten() {
		for(int i = 2; i < Math.min(this.numerator, this.denominator); i++) {
			if(this.numerator % i == 0 && this.denominator % i == 0) {
				this.numerator /= i;
				this.denominator /= i;
				break;
			}
		}
	}

	public void plus(Fraction f) {
		int i = 1;
		while(true) {
			if(f.denominator % i == 0 && this.denominator % i == 0) {
				f.expand(i);
				this.expand(i);
				this.numerator += f.numerator;
				break;
			}
			i++;
		}
		this.shorten();
	}

	public void minus(Fraction f) {
		int i = 1;
		while(true) {
			if(f.denominator % i == 0 && this.denominator % i == 0) {
				f.expand(i);
				this.expand(i);
				this.numerator -= f.numerator;
				break;
			}
			i++;
		}
		this.shorten();
	}

	public void multiply(Fraction f) {
		this.numerator *= f.numerator;
		this.denominator *= f.denominator;
		this.shorten();
	}

	public void divide(Fraction f) {
		f.flip();
		this.multiply(f);
		this.shorten();
	}

	public static void main(String[] args) {
	 	
		Fraction f = new Fraction(2, 5);
		Fraction g = new Fraction(7, 13);

		System.out.println(f.getNomerator() + " / " + f.getDenominator());
		f.plus(g);
		System.out.println(f.getNomerator() + " / " + f.getDenominator());
		f.minus(g);
		System.out.println(f.getNomerator() + " / " + f.getDenominator());
		f.multiply(g);
		System.out.println(f.getNomerator() + " / " + f.getDenominator());
		f.divide(g);
		System.out.println(f.getNomerator() + " / " + f.getDenominator());
	} 

}