package HelperClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
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
	public static void createSQLStatement(){
		
		//Important Variables

		SignUp obj = new SignUp();

		
		//GUI (Swing)
		JFrame signupFrame = new JFrame("Hello");
		signupFrame.setSize(600,800);
		signupFrame.setLayout(null);
		signupFrame.setVisible(true);
		signupFrame.getContentPane().setBackground(new Color(30,200,200));
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JLabel header = new JLabel("Bank Of IIT-Jamdoli");
//		header.setBounds(120,40,200,20);
//		signupFrame.add(header);
//		
		//Name Field
		JLabel nameLabel = new JLabel("Name (Max 20 Characters)");
		nameLabel.setBounds(20,100,200,20);
		signupFrame.add(nameLabel);
	
		JTextField nameField = new JTextField(30);
		nameField.setBounds(230,100,150,20);
		signupFrame.add(nameField);
		
		//DOB Field
		JLabel DOBLabel = new JLabel("DOB (dd-mm-yyyy)");
		DOBLabel.setBounds(20,130,200,20);
		signupFrame.add(DOBLabel);
		
		JTextField DOBField = new JTextField(30);
		DOBField.setBounds(230,130,150,20);
		signupFrame.add(DOBField);
		
		
		//Gender Field
		JLabel GenderLabel = new JLabel("Gender (M/F/O)");
		GenderLabel.setBounds(20,160,200,20);
		signupFrame.add(GenderLabel);
		
		JTextField GenderField = new JTextField(30);
		GenderField.setBounds(230,160,150,20);
		signupFrame.add(GenderField);
		
		//Address Field
		JLabel AddressLabel = new JLabel("Address (Max 100 characters)");
		AddressLabel.setBounds(20,190,200,20);
		signupFrame.add(AddressLabel);
		
		JTextField AddressField = new JTextField(30);
		AddressField.setBounds(230,190,150,20);
		signupFrame.add(AddressField);
		
		//Pincode Field
		JLabel pincodeLabel = new JLabel("Add Pincode");
		pincodeLabel.setBounds(20,220,200,20);
		signupFrame.add(pincodeLabel);
		
		JTextField pincodeField = new JTextField(30);
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
				 	display.setText("Query Successfully generated. Your ConsumerID is : " + obj.ConsumerID);
					System.out.println("Your ConsumerID is:\t" + obj.ConsumerID);
					
					SQLStatement =	"INSERT INTO Consumer("
										+	"ConsumerID,name,DOB,gender,address,pincode,totalAccounts) "
										+	"VALUES(" + obj.ConsumerID +",\'"+ obj.name +"\',\'"+ obj.DOB + "\',\'"
										+	obj.gender +"\',\'"+ obj.address +"\',"+ obj.pincode +","+ obj.totalAccounts+");";	 	
				 }

				try {
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
					Statement st = con.createStatement();
					String query = SQLStatement;
					st.executeUpdate(query);
					
					System.out.println("Succesfully Inserted Consumer Details ");
				}
				catch(Exception exception){
					exception.printStackTrace();
				}
				
			}
		});
	


	}
	int generateConsumerID() {
		return (int)(Math.random()*1000000);
	}
}
