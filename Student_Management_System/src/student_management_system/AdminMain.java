package student_management_system;

import java.util.Scanner;

public class AdminMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdminJDBC jdbc = new AdminJDBC();
		boolean flag = true;

		while (flag) {
			System.out.println("Enter 1 ot Login \nEnter 2 to Sign in \nEnter 3 to exit");
			System.out.println("Enter your choice");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				Admin admin = new Admin();
				scanner.nextLine();
				System.out.println("Enter email id");
				admin.setEmail(scanner.nextLine());
				System.out.println("Enter password");
				admin.setPassword(scanner.nextLine());
				jdbc.login(admin);
				break;
			case 2:
				Admin adminn = new Admin();
				scanner.nextLine();
				System.out.println("Enter email id");
				adminn.setEmail(scanner.nextLine());
				System.out.println("Enter password");
				adminn.setPassword(scanner.nextLine());
				jdbc.signin(adminn);
				System.out.println("Sign in successful! Pleause Login...");
				System.out.println("Enter email id");
				adminn.setEmail(scanner.nextLine());
				System.out.println("Enter password");
				adminn.setPassword(scanner.nextLine());
				jdbc.login(adminn);
				break;
			case 3:
				System.out.println("Thank you!");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
