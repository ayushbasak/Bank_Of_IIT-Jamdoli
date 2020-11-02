package HelperClasses;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Transaction {
	int bankAccountNumber;
	String transactionType;
	int destination;
	int amount;
	String accountId;

	Transaction(int bankaccountnumber){
		this.bankAccountNumber = bankaccountnumber;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
			Statement st = con.createStatement();
			String query = "SELECT * FROM ACCOUNTS WHERE BANKACCOUNTNUMBER = " + this.bankAccountNumber; 
			ResultSet res = st.executeQuery(query);
			
			if(res.next()) {
				this.accountId = res.getString(1);
			}
			else
				this.accountId = "DOES NOT EXIST";
			res.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void performTransaction(int accountNumber) {
		Transaction obj = new Transaction(accountNumber);
		GUI gui = new GUI();
		//Transaction Frame
		JFrame transactionFrame = new JFrame("Transaction");
		gui.redefineFrame(transactionFrame, 500, 800);
		JPanel transactionPanel = new JPanel();
		gui.redefinePanel(transactionPanel, "#cb56af", 0, 1, 20);
		
		//Welcome
		JLabel welcomeLabel = new JLabel("Welcome Account: " + obj.accountId);
		gui.redefineLabel(welcomeLabel);
		transactionPanel.add(welcomeLabel);
		
		
		//Transaction Types
		JLabel transactionTypeLabel = new JLabel("<html>Enter Transaction Type - <br>1: DEBIT <br>2: CREDIT <br>3:TRANSFER </html>");
		gui.redefineLabel(transactionTypeLabel);
		transactionPanel.add(transactionTypeLabel);
		
		JTextField transactionTypeField = new JTextField();
		gui.redefineTextField(transactionTypeField);
		transactionPanel.add(transactionTypeField);
		
		//Destination
		JLabel destinationLabel = new JLabel("Enter destination bank account if transaction type is TRANSFER");
		gui.redefineLabel(destinationLabel);
		transactionPanel.add(destinationLabel);
		
		JTextField destinationField = new JTextField();
		gui.redefineTextField(destinationField);
		transactionPanel.add(destinationField);
		
		//Amount
		JLabel amountLabel = new JLabel("Enter Amount");
		gui.redefineLabel(amountLabel);
		transactionPanel.add(amountLabel);
		
		JTextField amountField = new JTextField();
		gui.redefineTextField(amountField);
		transactionPanel.add(amountField);
		
		
		//Transact Button
		JButton transactionButton = new JButton("Perform Transaction");
		gui.redefineButton(transactionButton, "#cf23ab", 10);
		transactionPanel.add(transactionButton);
		
		
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				obj.destination = Integer.parseInt(destinationField.getText());
				obj.transactionType = transactionTypeField.getText().toUpperCase();
				obj.amount = Integer.parseInt(amountField.getText());
				
				if(obj.transactionType.charAt(0) == 'D' || obj.transactionType.charAt(0) == '1') {
					
//					try {
//						Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
//						Statement st = con.createStatement();
//						String query = "INSERT INTO BALANCE()";
//					}
//					catch(Exception exception){
//						exception.printStackTrace();
//					}
					
				}
				else if(obj.transactionType.charAt(0) == 'C' || obj.transactionType.charAt(0) == '2') {
					
				}
				else if(obj.transactionType.charAt(0) == 'T' || obj.transactionType.charAt(0) == '3') {
					
				}
				
			}
		});
		
		
		transactionFrame.add(transactionPanel);
		
//		if(object.trnascationType == "TRANSFER") {
//			
//		}
	}
}
