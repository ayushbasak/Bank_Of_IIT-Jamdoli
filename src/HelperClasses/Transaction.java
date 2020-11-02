package HelperClasses;
import javax.swing.*;
//import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Transaction {
	int bankAccountNumber;
	String transactionType;
	int destination;
	int amount;
	String accountId;

	Transaction(int bankaccountnumber){
		this.bankAccountNumber = bankaccountnumber;
		String query = "SELECT * FROM ACCOUNTS WHERE BANKACCOUNTNUMBER = " + this.bankAccountNumber;
		String result = SQLConnection.executeQueryWithReturn(query, 1);
		
		if(result == "NO RESULT")
			System.exit(0);
		else
			this.accountId = result;
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
		
		//Trnsaction Status Display
		JLabel transactionStatusDisplay = new JLabel("Trnsaction Status");
		gui.redefineLabel(transactionStatusDisplay);
		transactionPanel.add(transactionStatusDisplay);
		
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				obj.destination = Integer.parseInt(destinationField.getText());
				obj.transactionType = transactionTypeField.getText().toUpperCase();
				obj.amount = Integer.parseInt(amountField.getText());
			    Date dt = new Date();
			    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
				String creationDate = format.format(dt);
				if(obj.transactionType.charAt(0) == 'D' || obj.transactionType.charAt(0) == '1') {
					String currbalance  = SQLConnection.executeQueryWithReturn("SELECT * FROM BALANCE WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber, 1);
					int balance = Integer.parseInt(currbalance);
					
					if(balance <= obj.amount) {
						transactionStatusDisplay.setText("Insufficient Balance!");
					}
					else {
						balance -= obj.amount;
						String query = "UPDATE BALANCE SET CURRBALANCE = " + balance + " WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber + ";"
								+	"INSERT INTO TRANSACTION(bankaccountnumber, transactiontype, destination, date, amount) "
								+ 	"VALUES(" + obj.bankAccountNumber + ",\'DEBIT\',0,\'" + creationDate + "\',"+obj.amount+ ");";
						SQLConnection.executeQueryNoReturn(query);
						transactionStatusDisplay.setText("Successfully Debited " + obj.amount + "from your account!");
					}
				}
				else if(obj.transactionType.charAt(0) == 'C' || obj.transactionType.charAt(0) == '2') {
					String currbalance  = SQLConnection.executeQueryWithReturn("SELECT * FROM BALANCE WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber, 1);
					int balance = Integer.parseInt(currbalance);
					balance += obj.amount;
					String query = "UPDATE BALANCE SET CURRBALANCE = " + balance + " WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber + ";"
							+	"INSERT INTO TRANSACTION(bankaccountnumber, transactiontype, destination, date, amount) "
							+ 	"VALUES(" + obj.bankAccountNumber + ",\'CREDIT\',0,\'" + creationDate + "\',"+ obj.amount + ");";
					SQLConnection.executeQueryNoReturn(query);
					transactionStatusDisplay.setText("Successfully Credited " + obj.amount + "to your account!");
				}
				else if(obj.transactionType.charAt(0) == 'T' || obj.transactionType.charAt(0) == '3') {
					String destinationExists = SQLConnection.executeQueryWithReturn("SELECT * FROM BALANCE WHERE BANKACCOUNTNUMBER = " + obj.destination,2);
					if(destinationExists == "NO RETURN") {
						transactionStatusDisplay.setText("INVALID DESTINATION!");
					}
					else {
						int yourBalance = Integer.parseInt(SQLConnection.executeQueryWithReturn("SELECT * FROM BALANCE WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber, 1));
						int hisBalance = Integer.parseInt(SQLConnection.executeQueryWithReturn("SELECT * FROM BALANCE WHERE BANKACCOUNTNUMBER = " + obj.destination, 1));
						
						yourBalance -= obj.amount;
						hisBalance += obj.amount;
						
						String query = "UPDATE BALANCE SET CURRBALANCE = " + yourBalance + " WHERE BANKACCOUNTNUMBER = " + obj.bankAccountNumber + ";"
								+	"INSERT INTO TRANSACTION(bankaccountnumber, transactiontype, destination, date, amount) "
								+ 	"VALUES(" + obj.bankAccountNumber + ",\'TRANSFER\',"+obj.destination+",\'" + creationDate + "\',"+ obj.amount+ ");";
						SQLConnection.executeQueryNoReturn(query);
						query = "UPDATE BALANCE SET CURRBALANCE = " + hisBalance + " WHERE BANKACCOUNTNUMBER = " + obj.destination;
						SQLConnection.executeQueryNoReturn(query);
						transactionStatusDisplay.setText("Successfully Transfered " + obj.amount + "to Account Number" + obj.destination);
					}
				}
				
			}
		});
		
		
		transactionFrame.add(transactionPanel);
		
//		if(object.trnascationType == "TRANSFER") {
//			
//		}
	}
}
