package HelperClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class SignUp {
	
	//Instance Variables to store consumer details
	int ConsumerID;
	String name;
	String DOB;
	char gender;
	String address;
	int pincode;
	int totalAccounts;
	
	
	//constructors
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
		SignUp object = new SignUp();
		object.createGUI();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Your Details:\n");
		System.out.print("NAME (20 char limit):\t");
		String name = in.nextLine();
		System.out.print("DOB (DD-MM-YYYY):\t");
		String DOB = in.nextLine();
		System.out.print("GENDER (M/F/O):\t");
		char gender = in.nextLine().charAt(0);
		System.out.print("ADDRESS (100 char limit):\t");
		String address = in.nextLine();
		System.out.print("PINCODE (7 digit):\t");
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
	void createGUI() {
		//GUI (Swing)
		JFrame signupFrame = new JFrame("Hello");
		signupFrame.setSize(500,600);
		signupFrame.setLayout(null);
		signupFrame.setVisible(true);
		signupFrame.getContentPane().setBackground(new Color(30,200,200));
		
		JLabel header = new JLabel("Bank Of IIT-Jamdoli");
		header.setBounds(120,40,200,20);
		signupFrame.add(header);
		
		//Name Field
		JLabel nameLabel = new JLabel("Name (Max 20 Characters)");
		nameLabel.setBounds(20,100,200,20);
		signupFrame.add(nameLabel);
	
		JTextField nameField = new JTextField();
		nameField.setBounds(230,100,150,20);
		signupFrame.add(nameField);
		
		//DOB Field
		JLabel DOBLabel = new JLabel("DOB (dd-mm-yyyy)");
		DOBLabel.setBounds(20,130,200,20);
		signupFrame.add(DOBLabel);
		
		JTextField DOBField = new JTextField();
		DOBField.setBounds(230,130,150,20);
		signupFrame.add(DOBField);
		
		
		//Gender Field
		JLabel GenderLabel = new JLabel("Gender (M/F/O)");
		GenderLabel.setBounds(20,160,200,20);
		signupFrame.add(GenderLabel);
		
		JTextField GenderField = new JTextField();
		GenderField.setBounds(230,160,150,20);
		signupFrame.add(GenderField);
		
		//Address Field
		JLabel AddressLabel = new JLabel("Address (Max 100 characters)");
		AddressLabel.setBounds(20,190,200,20);
		signupFrame.add(AddressLabel);
		
		JTextField AddressField = new JTextField();
		AddressField.setBounds(230,190,150,20);
		signupFrame.add(AddressField);
		
		//Pincode Field
		JLabel pincodeLabel = new JLabel("Add Pincode");
		pincodeLabel.setBounds(20,190,200,20);
		signupFrame.add(pincodeLabel);
		
		JTextField pincodeField = new JTextField();
		pincodeField.setBounds(230,190,150,20);
		signupFrame.add(pincodeField);
		
		//Button Field
		JButton createConsumer = new JButton("Sign Up");
		createConsumer.setBounds(20,240,400,40);
		signupFrame.add(createConsumer);
		
		//DisplayField
		JLabel display = new JLabel("Display");
		display.setBounds(20,290,400,40);
		signupFrame.add(display);
		
		createConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("LOL");
			}
		});
	}
	int generateConsumerID() {
		return (int)(Math.random()*1000000);
	}
}
