class DumbEmployee {
	public Person person;
	private int CURRENT_YEAR;
	private int employeeIdNumber;
	private int hiringYear;
	private double wage;
	private double taxPercentage;

	DumbEmployee(String firstName, String lastName, int birthYear, 
		int employeeIdNumber, int hiringYear, double wage, double taxPercentage) {
		this.person = new Person(firstName, lastName, birthYear);
		this.CURRENT_YEAR = this.getCurrentYear();
		this.employeeIdNumber = employeeIdNumber;
		this.hiringYear = hiringYear; 
		this.wage = wage;
		this.taxPercentage = taxPercentage;
	}

	public void setFirstName(String name) {
		this.person.setFirstName(name);
	}

	public void setLastName(String name) {
		this.person.setLastName(name);
	}

	private int getCurrentYear() {
		java.util.GregorianCalendar c = new java.util.GregorianCalendar();
		return c.get(java.util.Calendar.YEAR);
	}

	public int getEmployeeIdNumber() {
		return this.employeeIdNumber;
	}

	public void setEmployeeIdNumber(int employeeIdNumber) {
		this.employeeIdNumber = employeeIdNumber;
	}

	public int getHiringYear() {
		return this.hiringYear;
	}

	public double getWage() {
		return this.wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getTaxPercentage() {
		return this.taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double taxDeducted() {
		return this.wage * this.taxPercentage;
	}

	public double yearlyWage() {
		return this.wage * 12;
	} 

	public double yearlyTaxDeducted() {
		return this.taxDeducted() * 10.5;
	}

	public String nameToString() {
		return person.getLastName() + ", " + person.getFirstName();
	}

	public int age() {
		return CURRENT_YEAR - person.getBirthYear();
	}

	public int timeEmployed() {
		return CURRENT_YEAR - hiringYear;
	}

	public boolean isTimeEmployedMoreThan(int i) {
		return i < timeEmployed(); 
	}

	public String toString() {
		return (
			"First name: " + this.person.getFirstName() + "\n" +
			"Last name: " + this.person.getLastName() + "\n" +
			"Full name: " + this.nameToString() + "\n" +
			"Id: " + this.getEmployeeIdNumber() + "\n" + 
			"Wage: " + this.getWage() + "\n" +
			"Tax percentage: " + this.getTaxPercentage() + "\n" +
			"Tax deducted: " + this.taxDeducted() + "\n" +
			"Yearly wage: " + this.yearlyWage() + "\n" +
			"Yearly tax Ddeducted: " + this.yearlyTaxDeducted() + "\n" +
			"Age: " + this.age() + "\n" +
			"Time Employed: " + this.timeEmployed() + "\n" +
			"Veteran: " + this.isTimeEmployedMoreThan(5)
		);
	}

	public static void main(String[] args) {
		Employee test = new Employee("Halvor", "Bø", 1998, 1, 2013, 50000.0, 0.35);
		System.out.println(test.getHiringYear());
		System.out.println(test.getWage());		
		System.out.println(test.getTaxPercentage());
		System.out.println(test.taxDeducted());
		System.out.println(test.yearlyWage());
		System.out.println(test.yearlyTaxDeducted());
		System.out.println(test.nameToString());
		System.out.println(test.age());
		System.out.println(test.timeEmployed());
		System.out.println(test.isTimeEmployedMoreThan(3));
		System.out.println(test.toString());

	}

}