package dictionaries;

public class Student implements Comparable<Student>{

	private String firstName;
	private String lastName;
	
	
	public Student(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName(){
		
		return this.firstName + " " + this.lastName;
	}
	
	@Override
	public int compareTo(Student student) {
		
		int result = this.lastName.compareTo(student.lastName);
		if (result == 0) {
			
			result = this.firstName.compareTo(student.firstName);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	

	

}
