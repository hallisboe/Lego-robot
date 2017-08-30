class Student {
	
	private String name;
	private int numberOfTasks;

	Student(String name) {
		this.name = name;
		this.numberOfTasks = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getNumberOfTasks() {
		return this.numberOfTasks;
	}

	public void increaseNumberOfTasks(int i) {
		this.numberOfTasks += i;
	}

	public String toString() {
		return this.name + ": " + this.numberOfTasks;
	}

	public static void main(String[] args) {
		Student student = new Student("Bobby Brown");
		System.out.println(student.getName());

		System.out.println(student.getNumberOfTasks());
		student.increaseNumberOfTasks(2);
		System.out.println(student.getNumberOfTasks());

		System.out.println(student.toString());

	}
}