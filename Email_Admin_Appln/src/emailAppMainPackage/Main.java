package emailAppMainPackage;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//scanner object sc, used to take input from user
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter First Name: ");
		String firstName = sc.next();
		System.out.print("Enter Last Name: ");
		String lastName = sc.next();
		
		//create new object for the employee
		GenerateEmail emp1 = new GenerateEmail(firstName, lastName);

	}

}
