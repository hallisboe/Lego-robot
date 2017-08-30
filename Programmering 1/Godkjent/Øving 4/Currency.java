public class Currency {

	private String name;
	private double rate;

	Currency(String currency_name, double currency_rate) {

		name = currency_name;
		rate = currency_rate;

	}

	public double to_nok(double amount) {

		return amount / rate;

	}

	public double from_nok(double amount) {
				
		return rate * amount;

	}

	public String get_name() {

		return name;

	}

	public double get_rate() {

		return rate;

	}

}

