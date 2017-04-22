package dictionaries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.omg.CORBA.PRIVATE_MEMBER;

/*
Kiril   | Ivanov    | Java
Milena  | Stefanova | PHP
Blagoy  | Ivanov    | Java
Petar   | Ivanov    | Linux
Stefka  | Vasileva  | C++
Milena  | Vasileva  | Java
 */

public class MainStudent {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new FileReader("/home/marchela/Students.txt"));
		HashMap<String, ArrayList<Student>> courses = new HashMap<>();
		
		try {

			while (input.hasNext()) {

				String line = input.nextLine();
				String[] studentEntry = line.split("\\s*\\|\\s*");
				String firstName = studentEntry[0];
				String lastName = studentEntry[1];
				String course = studentEntry[2];

				ArrayList<Student> students = courses.get(course);
				if (students == null) {

					students = new ArrayList<>();
					courses.put(course, students);
				}
				Student student = new Student(firstName, lastName);
				students.add(student);
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}finally {
			input.close();
		}

	Set<String> coursesNames = courses.keySet();
	for(String course:coursesNames)
	{

		System.out.println("Course " + course + ":");
		ArrayList<Student> students = courses.get(course);
		Student[] studentArr = students.toArray(new Student[students.size()]);
		Arrays.sort(studentArr);
		for (Student student : studentArr) {

			System.out.printf("\t%s\n", student);
		}
	}

}

}
