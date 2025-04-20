package emailAppMainPackage;

import java.util.*;

public class GenerateEmployeeCreds {

	private String firstName;
	private String lastName;
	private String NewEmail;
	private String Department;
	private String Password;
	private String AltEmail;
	private int MailBoxCapacity;
	private String CompanyName = "skytechSolutions";
	private int DefaultPassLength = 10;
	
	//Scanner object to take inputs
	Scanner sc = new Scanner(System.in);
	
	//Ask for first and last name of new employee, pass the name from the main method to
	// this class's constructor, default constructor is converted to parameterized Constructor
	//CLASS CONSTRUCTOR
	public GenerateEmployeeCreds(String firstName, String lastName) {

		//Variable instance of this class = variable value passed into the function
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Assign Department to employee
		Department = setDept();
		System.out.println("Department set Succesfully!");
		
		//Generate email for the employee
		NewEmail = EmailId(firstName,lastName);
			//NewEmail = firstName + "." + lastName + "@" + Department + "." + CompanyName +".com";
			//System.out.println("Email: " + NewEmail);
		System.out.println("Email ID Generated Succesful.....");
		
		//Generate password and display it for the the new employee
		Password = randomPassGenerator();
			//System.out.println("Password Generated and Assigned: " + password);
		System.out.println("Password Generated Successful.....");
		
		//Display Default mail box capacity
		MailBoxCapacity = DefaultMailCapacity();
		System.out.println("Default Mail Box Capcity Set: "+ DefaultMailCapacity() + " mb......");
		
		//Ask for alternate email, set if required
		AltEmail = AlternateEmail();
		System.out.println("Alternate Email set Successful.....");
		
	}
	
	//Assign Department to the new employee, *can be null
	private String setDept() {
		System.out.print("Department Options: \n 1. Sales \n 2. Engineer \n 3. Support \n 4. Accounting \n 5. None \n Enter Option Number: ");
		
		int Option = sc.nextInt();
		
		if(Option == 1) {
			return "Sales";
		}
		else if(Option == 2) {
			return "Engineer";
		}
		else if(Option == 3) {
			return "Support";
		}
		else if(Option == 4) {
			return "Accounting";
		}
		else{
			return "NONE";
		}
		
		
	}
	
	//Generate Email id
	private String EmailId(String firstName, String lastName) {
		return firstName + "." + lastName + "@" + Department + "." + CompanyName +".com";
		
	}

	
	//Constructor to generate an random password for the new employee's email id
	private String randomPassGenerator() {
		String PassCharLibrary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String PassSpecialLibrary = "@#$%&*!";
		String PassNumLibrary = "1234567890";
		
		//character variable char array of DefaultPassLenght, remember array start with 0 indexing meaning size if array size is 10, last index will be 9
		char[] GeneratedPassword = new char[DefaultPassLength];
		
		for(int i = 0; i< DefaultPassLength/2 ; i++) {
			int randomIndex = (int) (Math.random() * PassCharLibrary.length());
			GeneratedPassword[i] = PassCharLibrary.charAt(randomIndex);
			//Choose a random index, where Math.random would give a random decimal value between 0.0 and 0.1 Multiplied by the length of PassLibrary
			//(int), converts the multiplication result in to a integer by removing the decimal which is then stored in random index variable
			//get value at the randomeIndex from PassLibrary and place it to the Password
			
		}
		//add special character to password
		for(int i=DefaultPassLength/2 ; i<DefaultPassLength-2 ; i++) {
			int randomIndex = (int)(Math.random() * PassSpecialLibrary.length());
			GeneratedPassword[i] = PassSpecialLibrary.charAt(randomIndex);
		}
		//add numbers to password
		for(int i=DefaultPassLength-2 ; i<DefaultPassLength ; i++) {
			int randomIndex = (int)(Math.random() * PassNumLibrary.length());
			GeneratedPassword[i] = PassNumLibrary.charAt(randomIndex);
		}
		
		
		return new String(GeneratedPassword);
	}
	
	
	
	//Set MailBox Capacity
	private int DefaultMailCapacity() {
		
		int Capacity = 5000;
		
		return Capacity;
	}
	
	//Ask for Alternate Email id.
	private String AlternateEmail() {
		System.out.println("Do you want to set an Alternate Email? RECOMMENDED! \n 1. Yes \n 2. No");
		//take request input
		int req = sc.nextInt();
		
		if(req == 1) {
			System.out.println("Enter Full Alternate Email id: ");
			return sc.next();
		}
		else {
			return "NONE";
		}
		
	}
	
	//getters
	public String getName() {
		return this.firstName +" "+ this.lastName;
	}
	
	public String getEmpEmail() {
		return NewEmail;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public int getMailBoxCapacity() {
		return MailBoxCapacity;
	}
	
	public String getAltEmail() {
		return AltEmail;
	}
	
	//setters
	public void setUpdateName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.NewEmail = EmailId(this.firstName ,this.lastName);
		System.out.println("Name Updated Successfully!");
		
	}
	public void setMailBoxCapacity() {
		System.out.println("Enter New Mail Box Capacity: ");
		int NewCapacity = sc.nextInt();
		MailBoxCapacity = NewCapacity;
		System.out.println("Mail Box Capacity Successfully Updated!");
	}

	public void setAlternateEmail() {
		System.out.println("Enter New Alternate Email: ");
		String NewAltEmail= sc.next();
		AltEmail = NewAltEmail;
		System.out.println("Alternate Email Successfully Updated!");
	}

	public void setPassword() {
		System.out.println("Enter New Password (USE ALPHABETS+NUMBERS+SPECIAL CHARACETER): ");
		String NewPassword = sc.next();
		Password = NewPassword;
		System.out.println("Password Successfully Updated!");
	}

	public void setDepartment() {
		this.Department = setDept();
		this.NewEmail = EmailId(this.firstName,this.lastName);
		System.out.println("Department Successfully Updated!");
	}
	
	
	
	
}
