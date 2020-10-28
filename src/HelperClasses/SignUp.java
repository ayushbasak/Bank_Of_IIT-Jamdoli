package HelperClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
		
		//Important Variables
		String SQLStatement;
		final boolean[] correctQuery = new boolean[1];
		correctQuery[0] = false;
		SignUp obj = new SignUp();
		
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
		pincodeLabel.setBounds(20,220,200,20);
		signupFrame.add(pincodeLabel);
		
		JTextField pincodeField = new JTextField();
		pincodeField.setBounds(230,220,150,20);
		signupFrame.add(pincodeField);
		
		//Button Field
		JButton createConsumer = new JButton("Sign Up");
		createConsumer.setBounds(20,250,400,40);
		signupFrame.add(createConsumer);
		
		//DisplayField
		JLabel display = new JLabel("Display");
		display.setBounds(20,290,400,40);
		signupFrame.add(display);
		
//		String query = "";
		
		createConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidationChecks checks = new ValidationChecks();
				correctQuery[0] = true;
				//input and validate all fields
				obj.name = nameField.getText();
				obj.DOB = DOBField.getText();
				obj.gender = GenderField.getText().charAt(0);
				obj.address= AddressField.getText();
				obj.pincode = Integer.parseInt(pincodeField.getText());
				if(!checks.name(obj.name) || !checks.date(obj.DOB) || !checks.gender(obj.gender) || !checks.address(obj.address) || !checks.pincode(obj.pincode))
					correctQuery[0] = false;
				
				
				if(correctQuery[0] == false) 
					display.setText("Unsucessfyll Query! Try again!");
				else
					display.setText("Query Successfully generated");
			
				
			}
		});
		
		if(correctQuery[0] == true) {
			System.out.println("Your ConsumerID is:\t" + obj.ConsumerID);
			
			SQLStatement =	"INSERT INTO Consumer("
								+	"ConsumerID,name,DOB,gender,address,pincode,totalAccounts) "
								+	"VALUES(" + obj.ConsumerID +",\'"+ obj.name +"\',\'"+ obj.DOB + "\',\'"
								+	obj.gender +"\',\'"+ obj.address +"\',"+ obj.pincode +","+ obj.totalAccounts+");";
		}
		else {
			SQLStatement = "NONE";
		}
		return SQLStatement;
	}
	void createGUI() {
	}
	int generateConsumerID() {
		return (int)(Math.random()*1000000);
	}
}
