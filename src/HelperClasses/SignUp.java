package HelperClasses;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
public class SignUp {
	
	//Instance Variables to store consumer details
	int ConsumerID;
	String name;
	String DOB;
	char gender;
	String address;
	int pincode;
	int accountID;
	
	
	//constructors
	SignUp(){
		this.ConsumerID = generateID();
		this.name = "NULL";
		this.DOB = "NULL";
		this.gender = 'M';
		this.address = "NULL";
		this.pincode = 282007;
		this.accountID = generateID();
	}
	SignUp(String name, String DOB, char gender, String address, int pincode){
		this.ConsumerID = generateID();
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.accountID = generateID();
	}
	public static void createSQLStatement(){
		
		//Creating necessary instances

		SignUp obj = new SignUp();
		GUI gui = new GUI();
		
		//GUI (Swing)
		JFrame signupFrame = new JFrame("Sign Up: © Bank Of IIT Jamdoli");
		gui.redefineFrame(signupFrame, 600, 800);
		
		JPanel signupPanel = new JPanel();
		gui.redefinePanel(signupPanel, "#fcab60", 0, 1, 20);
		
		
		JLabel header = new JLabel("Bank Of IIT-Jamdoli");
		gui.redefineLabel(header);
		signupPanel.add(header);
		
		
		//Name Field
		JLabel nameLabel = new JLabel("Name (Max 20 Characters)");
		gui.redefineLabel(nameLabel);
		signupPanel.add(nameLabel);
	
		JTextField nameField = new JTextField(30);
		gui.redefineTextField(nameField);
		signupPanel.add(nameField);
		
		//DOB Field
		JLabel DOBLabel = new JLabel("DOB (dd-mm-yyyy)");
		gui.redefineLabel(DOBLabel);
		signupPanel.add(DOBLabel);
		
		JTextField DOBField = new JTextField(30);
		gui.redefineTextField(DOBField);
		signupPanel.add(DOBField);
		
		
		//Gender Field
		JLabel GenderLabel = new JLabel("Gender (M/F/O)");
		gui.redefineLabel(GenderLabel);
		signupPanel.add(GenderLabel);
		
		JTextField GenderField = new JTextField(30);
		gui.redefineTextField(GenderField);
		signupPanel.add(GenderField);
		
		//Address Field
		JLabel AddressLabel = new JLabel("Address (Max 100 characters)");
		gui.redefineLabel(AddressLabel);
		signupPanel.add(AddressLabel);
		
		JTextField AddressField = new JTextField(30);
		gui.redefineTextField(AddressField);
		signupPanel.add(AddressField);
		
		//Pin code Field
		JLabel pincodeLabel = new JLabel("Add Pincode");
		gui.redefineLabel(pincodeLabel);
		signupPanel.add(pincodeLabel);
		
		JTextField pincodeField = new JTextField(30);
		gui.redefineTextField(pincodeField);
		signupPanel.add(pincodeField);
		
		//Button Field
		JButton createConsumer = new JButton("Sign Up");
		gui.redefineButton(createConsumer, "#56fcab", 5);
		signupPanel.add(createConsumer);
		
		//DisplayField
		JLabel display = new JLabel("Query Result!");
		gui.redefineLabel(display);
		signupPanel.add(display);
		
		//Account Information Field
		JLabel accountInfo = new JLabel("Account Info");
		gui.redefineLabel(accountInfo);
		signupPanel.add(accountInfo);
		
		signupFrame.add(signupPanel);
		
//		String query = "";
		
		createConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQLStatement = "";
				ValidationChecks checks = new ValidationChecks();
				boolean correctQuery = true;
				//input and validate all fields
				obj.name = nameField.getText();
				obj.DOB = DOBField.getText();
				obj.gender = GenderField.getText().charAt(0);
				obj.address= AddressField.getText();
				obj.pincode = Integer.parseInt(pincodeField.getText());
				 if(!checks.name(obj.name) || !checks.date(obj.DOB) || !checks.gender(obj.gender) || !checks.address(obj.address) || !checks.pincode(obj.pincode))
				 	correctQuery = false;
				
				
				 if(correctQuery == false) {
				 	display.setText("Unsucessfull Query! Try again!");
					SQLStatement = "DELETE FROM Consumer WHERE ConsumerID < 0";
				 }
				 else {
					int bankAccountNumber = generateBankAccountNumber();
				    Date dt = new Date();
				    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String creationDate = format.format(dt);
				 	display.setText("Query Successfully generated. Your ConsumerID is : " + obj.ConsumerID);
				 	accountInfo.setText("Your Bank Account Number is : " + bankAccountNumber);
					
					SQLStatement =	"INSERT INTO Consumer("
										+	"ConsumerID,name,DOB,gender,address,pincode,accountid) "
										+	"VALUES(" + obj.ConsumerID +",\'"+ obj.name +"\',\'"+ obj.DOB + "\',\'"
										+	obj.gender +"\',\'"+ obj.address +"\',"+ obj.pincode + "," + obj.accountID + ");"
										+	
									"INSERT INTO ACCOUNTS(accountID,accountcreationdate,bankaccountnumber) "
										+	"VALUES(" + obj.accountID + ",\'" + creationDate + "\'," + bankAccountNumber + ");"
										+
									"INSERT INTO BALANCE(currbalance, bankaccountnumber) "
										+	"VALUES(" + 0 + "," + bankAccountNumber + ");";	 	
				 }

				 
				SQLConnection.executeQueryNoReturn(SQLStatement);
				
			}
		});
	


	}
	int generateID() {
		Random rand = new Random();
		int low = 100000;
		int high = 999999;
		
		return rand.nextInt(high - low) + low;
	}
	static int generateBankAccountNumber() {
		Random rand = new Random();
		int low  = 100000000;
		int high = 999999999;
		
		return rand.nextInt(high - low) + low;
	}
}
