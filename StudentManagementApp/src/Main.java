import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentManager;
public class Main {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//Greeting
		System.out.println("*********************************");
		System.out.println("Welcome to Student Management App");
		System.out.println("*********************************");
		
		// run as long as the user wants
		while(true) {
			run();
		}
		
	}
	
	
	
	public static void run() throws NumberFormatException, IOException {
		
		// new input
		System.out.println();
		System.out.println("***************INPUT******************");
		
		// getting the user input
		System.out.println("Press 1 to ADD Student: ");
		System.out.println("Press 2 to REMOVE Student: ");
		System.out.println("Press 3 to UPDATE Student: ");
		System.out.println("Press 4 to VIEW Students: ");
		System.out.println("Press 5 to QUIT Student Management App: ");
		
		
		System.out.print("Your Choice [1-5]: ");
		int choice = Integer.parseInt(br.readLine());
		
		
		switch(choice) {
		
		case 1:
			// Add the user
			
			Student s = Student.createStudent(0);
			//System.out.println(s);
			
			boolean added = StudentManager.addStudent(s);
			
			if(added) {
				System.out.println("Student added successfully");
			}else {
				System.out.println("Student not added");
			}
			
			
			
			
			break;
			
		case 2:
			// Remove the user
			
			int studentId = getStudent();
			
			boolean removed = StudentManager.removeStudent(studentId);
			
			if(removed) {
				System.out.println("Student deleted successfully");
			}else {
				System.out.println("Student not deleted");
			}
			
		    break;
			
		case 3:
			// Update the user
			
			 studentId = getStudent();
			
			boolean updated = StudentManager.updateStudent(studentId);
			
			if(updated) {
				System.out.println("Student updated successfully");
			}else {
				System.out.println("Student not updated");
			}
			
			break;
			
		case 4:
			// Display users
			
			StudentManager.showAll();
			break;
			
			
		case 5:
			// Exit the program
			
			exitProgram();
			
			break;
			
		default:
			// Wrong input
			
			System.out.println("Wrong input");
			System.out.println("Try Again");
		}
		
		
		
		
		
		
		
		
		
	}

	private static void exitProgram() {
		System.out.println("You are exitting");
		System.out.println("See you soon");
		
		//Greeting
		System.out.println("*********************************");
		System.out.println("Goodbye from Student Management App");
		System.out.println("*********************************");

		System.exit(0);
		
	}

	private static int getStudent() throws NumberFormatException, IOException {
		System.out.println("Enter the student to be deleted: ");
		int id =Integer.parseInt(br.readLine());
		return id;
	}

}
