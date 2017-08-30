// Side 417

class TaskOverview {

	private Student[] students;
	private int numberOfStudents;

	TaskOverview() {
		this.students = new Student[0];
		this.numberOfStudents = 0;
	}

	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}

	public int getNumberOfTasksForStudent(int id) {
		return this.students[id].getNumberOfTasks();
	}

	public void registerNewStudent(String name) {
		Student[] newStudents = new Student[this.students.length + 1];

		for(int i = 0; i < students.length; i++) {
			newStudents[i] = students[i]; 
		}

		newStudents[newStudents.length - 1] = new Student(name);
		this.students = newStudents;
		this.numberOfStudents++;
	}

	public void increaseNumberOfTasksForStudent(int id, int i) {
		this.students[id].increaseNumberOfTasks(i);

	}

	public String toString() {
		String output = "";
		for(Student student : this.students) {
			output += student + "\n";
		}
		return output;
	}

	public static void main(String[] args) {
		TaskOverview overview = new TaskOverview();
		overview.registerNewStudent("Bobby Brown");
		overview.registerNewStudent("Macklemore");
		overview.registerNewStudent("Eminem");
		System.out.println(overview.getNumberOfStudents());
		System.out.println(overview.getNumberOfTasksForStudent(2));
		overview.increaseNumberOfTasksForStudent(2, 2);
		System.out.println(overview.getNumberOfTasksForStudent(2));	
		System.out.println(overview);
	}

}