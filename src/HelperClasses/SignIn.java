package HelperClasses;
import java.awt.event.*;
import javax.swing.*;
public class SignIn {
	
	
	public static void signInRequest() {

		GUI gui = new GUI();
		JFrame signinFrame = new JFrame("SIGN IN");
		gui.redefineFrame(signinFrame, 500, 800);
		
		JPanel signinPanel = new JPanel();
		gui.redefinePanel(signinPanel, "#af2d2d", 0, 1, 20);
		
		// Header		
		JLabel header = new JLabel("SIGN IN");
		gui.redefineLabel(header);
		
		//AccountId field
		JLabel accountIdLabel = new JLabel("ACCOUNT ID");
		gui.redefineLabel(accountIdLabel);
		signinPanel.add(accountIdLabel);
		
		JTextField accountIdField = new JTextField();
		gui.redefineTextField(accountIdField);
		signinPanel.add(accountIdField);
		
		
		//AccountId field
		JLabel accountNumberLabel = new JLabel("BANK ACCOUNT NUMBER");
		gui.redefineLabel(accountNumberLabel);
		signinPanel.add(accountNumberLabel);
		
		JTextField accountNumberField = new JTextField();
		gui.redefineTextField(accountNumberField);
		signinPanel.add(accountNumberField);
		
		//Sign In Button
		JButton signinButton = new JButton("SIGN IN");
		gui.redefineButton(signinButton, "#f05454", 10);
		signinPanel.add(signinButton);
		
		//Card  Details
		JLabel signinInfo = new JLabel("");
		gui.redefineLabel(signinInfo);
		signinPanel.add(signinInfo);
		
		signinFrame.add(signinPanel);
		
		
		signinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int accountId = Integer.parseInt(accountIdField.getText());
				int accountNumber = Integer.parseInt(accountNumberField.getText());
				
//				Querying if credentials are authentic
				String query =  "SELECT * FROM ACCOUNTS WHERE ACCOUNTID = " + accountId + " AND BANKACCOUNTNUMBER = " + accountNumber;
				String result = SQLConnection.executeQueryWithReturn(query, 1);
				if(result == "NO RETURN")
					signinInfo.setText("INVALID CREDENTIALS");
				else {
					signinInfo.setText("OPENING TRANSACTION BAR FOR ACCOUNT : " + result);
					Transaction.performTransaction(accountNumber);
				}
			}
		});
	}
}
	

