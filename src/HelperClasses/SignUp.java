package HelperClasses;
import java.util.Scanner;
public class SignUp {
	int ConsumerID;
	String name;
	String DOB;
	char gender;
	String address;
	int pincode;
	int totalAccounts;
	
	SignUp(){
		this.ConsumerID = generateConsumerID();
		this.name = "NULL";
		this.DOB = "NULL";
		this.gender = 'M';
		this.address = "NULL";
		this.pincode = 282007;
		this.totalAccounts = 0;
	}
	SignUp(String name, String DOB, char gender, String address, int pincode, int totalAccounts){
		this.ConsumerID = generateConsumerID();
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.totalAccounts = totalAccounts;
	}
	
	public static String createSQLStatement(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Your Details");
		String name = in.nextLine();
		String DOB = in.nextLine();
		char gender = in.nextLine().charAt(0);
		String address = in.nextLine();
		int pincode = in.nextInt();
		
		SignUp obj = new SignUp(name,DOB,gender,address,pincode,0);
		System.out.println("Your ConsumerID is:\t" + obj.ConsumerID);
		
		String SQLStatement =	"INSERT INTO Consumer("
							+	"ConsumerID,name,DOB,gender,address,pincode,totalAccounts) "
							+	"VALUES(" + obj.ConsumerID +",\'"+ obj.name +"\',\'"+ obj.DOB + "\',\'"
							+	obj.gender +"\',\'"+ obj.address +"\',"+ obj.pincode +","+ obj.totalAccounts+");";
		in.close();
		return SQLStatement;
	}
	
	int generateConsumerID() {
		return (int)(Math.random()*1000000);
	}
}
