package HelperClasses;
//import java.sql.*;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SignIn {
	
	int consumerID;
	
	SignIn(int consumerID){
		this.consumerID = consumerID;
	}
	SignIn(){
		this.consumerID = 0;
	}
	
	public static void signInRequest() {

		GUI gui = new GUI();
		JFrame signinFrame = new JFrame("Sign In");
		gui.redefineFrame(signinFrame, 500, 800);
		
		JPanel signinPanel = new JPanel();
		gui.redefinePanel(signinPanel, "#fc34cd", 0, 1, 20);
		
		// Header		
		JLabel header = new JLabel("Sign In");
		gui.redefineLabel(header);
		
		//AccountId field
		JLabel accountIdLabel = new JLabel("Account ID");
		gui.redefineLabel(accountIdLabel);
		signinPanel.add(accountIdLabel);
		
		JTextField accountIdField = new JTextField();
		gui.redefineTextField(accountIdField);
		signinPanel.add(accountIdField);
		
		
		//AccountId field
		JLabel accountNumberLabel = new JLabel("Bank Account Number");
		gui.redefineLabel(accountNumberLabel);
		signinPanel.add(accountNumberLabel);
		
		JTextField accountNumberField = new JTextField();
		gui.redefineTextField(accountNumberField);
		signinPanel.add(accountNumberField);
		
		//Sign In Button
		JButton signinButton = new JButton("Sign In");
		gui.redefineButton(signinButton, "#349cfa", 10);
		signinPanel.add(signinButton);
		
		//Card  Details
		JLabel signinInfo = new JLabel("Card Details");
		gui.redefineLabel(signinInfo);
		signinPanel.add(signinInfo);
		
		signinFrame.add(signinPanel);
		
		
		signinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int accountId = Integer.parseInt(accountIdField.getText());
				int accountNumber = Integer.parseInt(accountNumberField.getText());
				
				String query =  "SELECT * FROM ACCOUNTS WHERE ACCOUNTID = " + accountId + " AND BANKACCOUNTNUMBER = " + accountNumber;
				String result = SQLConnection.executeQueryWithReturn(query, 1);
				if(result == "NO RESULT")
					signinInfo.setText("No Such Account Exists!");
				else {
					signinInfo.setText("Account Exists for " + result + "! Opening Transaction");
					Transaction.performTransaction(accountNumber);
				}
			}
		});
	}
}
	

