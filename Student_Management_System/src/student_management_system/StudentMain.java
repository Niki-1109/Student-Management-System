package student_management_system;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
	public void stud() {
		Scanner scanner = new Scanner(System.in);
		StudentJDBC jdbc = new StudentJDBC();
		boolean flag = true;

		while (flag) {
			System.out.println("Enter 1 to add student \nEnter 2 to get all student \nEnter 3 to get student \nEnter 4 to delete student \nEnter 5 to update student \nEnter 6 to exit \nEnter 7 to Logout");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:	
				Student student = new Student();
				System.out.println("Enter number of student you want to add");
				int n = scanner.nextInt();
				for(int i=1;i<=n;i++) {
					System.out.println("Enter student id");
					student.setId(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Enter student name");
					student.setName(scanner.nextLine());
					System.out.println("Enter student email");
					student.setEmail(scanner.nextLine());
					System.out.println("Enter student age");
					student.setAge(scanner.nextInt());
					System.out.println("Enter student fees");
					student.setFees(scanner.nextInt());
					jdbc.addStudent(student);
				}
				break;
			case 2:
				List<Student> students = jdbc.getAllStudent();
				System.out.println("----------------------------------------------------------------");
				System.out.printf("%4s%3s%8s%6s%13s%9s%5s%4s%8s%4s", "ID", "|", "NAME", "|", "EMAIL", "|", "AGE", "|", "FEES", "|");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				for(Student s : students) {
					System.out.printf(" %3s%3s", s.getId() , "|");
					System.out.printf(" %8s%5s", s.getName() , "|");
					System.out.printf(" %17s%4s",s.getEmail() , "|");
					System.out.printf(" %4s%4s", s.getAge() , "|");
					System.out.printf(" %7s%4s", s.getFees() , "|");
					System.out.println();
				}
				System.out.println("----------------------------------------------------------------");
				break;	
			case 3:
				System.out.println("Enter student id");
				Student s = jdbc.getStudentById(scanner.nextInt());
				System.out.println("----------------------------------------------------------------");
				System.out.printf("%4s%3s%8s%6s%13s%9s%5s%4s%8s%4s", "ID", "|", "NAME", "|", "EMAIL", "|", "AGE", "|", "FEES", "|");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.printf(" %3s%3s", s.getId() , "|");
				System.out.printf(" %8s%5s", s.getName() , "|");
				System.out.printf(" %17s%4s",s.getEmail() , "|");
				System.out.printf(" %4s%4s", s.getAge() , "|");
				System.out.printf(" %7s%4s", s.getFees() , "|");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				break;
			case 4:
				System.out.println("Enter student id");
				jdbc.deleteStudent(scanner.nextInt());
				break;
			case 5:
				System.out.println("Enter student id");
				jdbc.updateStudent(scanner.nextInt(), scanner);
				break;		
			case 6: 
				System.out.println("Thank you!");
				System.out.println();
				flag = false;
				break;
			case 7:
				System.out.println();
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
				System.out.println();
			}
		}
	}
}
