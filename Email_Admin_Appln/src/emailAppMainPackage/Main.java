package emailAppMainPackage;

import java.util.*;

public class Main {

	//scanner object sc, used to take input from user
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter First Name: ");
		String firstName = sc.next();
		System.out.print("Enter Last Name: ");
		String lastName = sc.next();
		
		//create new object for the employee
		GenerateEmployeeCreds emp1 = new GenerateEmployeeCreds(firstName, lastName);
		
		//Generation completed, display?
		
		System.out.println("Employee Credential Created Successfuly.");
		ProgramMenu(emp1);
		

	}
	
	//Program Menu
	public static void ProgramMenu(GenerateEmployeeCreds Employee) {
		System.out.println("Main Menu: \n 1. View Employee Credentials \n 2. Edit Employee Credential \n 3. Exit Program ");
		
		int OptionReq = sc.nextInt();
		if(OptionReq == 1) {
			DisplayEmpCred(Employee);
		}
		else if(OptionReq == 2) {
			System.out.println("Existing Employee Field Values are : \n");
			System.out.println("Name: " + Employee.getName());
			System.out.println("Email: " + Employee.getEmpEmail());
			System.out.println("Password: " + Employee.getPassword());
			System.out.println("Department: " + Employee.getDepartment());
			System.out.println("Alternate Email: " + Employee.getAltEmail());
			System.out.println("Mail Box Capacity: " + Employee.getMailBoxCapacity() + " mb");
			EditCredentials(Employee);
		}
		else if(OptionReq == 3) {
			System.exit(0);
		}
		else {
			System.out.println("Invlaid Input, Exiting program.....Bye!");
			System.exit(0);
		}
	}
	
	//Display all necessary Details of the Newly Generated Employee Email
	private static void DisplayEmpCred(GenerateEmployeeCreds Employee) {
			System.out.println("Displaying Generated Employee Credentials......Loading....");
			System.out.println("Name: " + Employee.getName());
			System.out.println("Email: " + Employee.getEmpEmail());
			System.out.println("Password: " + Employee.getPassword());
			System.out.println("Department: " + Employee.getDepartment());
			System.out.println("Alternate Email: " + Employee.getAltEmail());
			System.out.println("Mail Box Capacity: " + Employee.getMailBoxCapacity() + " mb");	
			
			System.out.println("....Returning to Menu....");
			ProgramMenu(Employee);
			
	}
		
	private static void EditCredentials(GenerateEmployeeCreds Employee) {
			System.out.println("Editable fields are \n 1. Name \n 2. Mail Box Capacity \n 3. Alternate Email \n 4. Password \n 5. Department \n 6. Go to Main Menu");
			int EditReq = sc.nextInt();
			if(EditReq ==1) {
				System.out.print("Enter First Name: ");
				String firstName = sc.next();
				System.out.print("Enter Last Name: ");
				String lastName = sc.next();
				Employee.setUpdateName(firstName,lastName);
				ProgramMenu(Employee);
			}
			else if(EditReq == 2) {
				Employee.setMailBoxCapacity();
				ProgramMenu(Employee);
			}
			else if(EditReq == 3) {
				Employee.setAlternateEmail();
				ProgramMenu(Employee);
			}
			else if(EditReq == 4) {
				Employee.setPassword();
				ProgramMenu(Employee);
			}
			else if(EditReq == 5) {
				Employee.setDepartment();
				ProgramMenu(Employee);
			}
			else if(EditReq == 6) {
				ProgramMenu(Employee);
			}
			
	}
		

}
