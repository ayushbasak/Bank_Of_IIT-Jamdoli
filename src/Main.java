
import HelperClasses.SignUp;
import HelperClasses.TransactionList;

//import HelperClasses.SignIn;
//import HelperClasses.SQLConnection;
import javax.swing.*;
import java.awt.event.*;
import HelperClasses.GUI;
import HelperClasses.SignIn;
public class Main{
	public static void main(String [] args) {
//		SignIn.signInRequest();
//		SignUp.createSQLStatement();
		
		GUI gui = new GUI();
		JFrame mainFrame = new JFrame("Bank Of IIT Jamdoli");
		gui.redefineFrame(mainFrame, 500, 600);
		
		JPanel mainPanel = new JPanel();
		gui.redefinePanel(mainPanel, "#fcab60", 0, 1, 30);
		
		mainFrame.add(mainPanel);
		
		//Header
		JLabel header = new JLabel("Bank Of IIT Jamdoli: Menu");
		gui.redefineLabel(header);
		mainPanel.add(header);
		
		// Sign Up
		JButton signup = new JButton("Sign Up");
		gui.redefineButton(signup, "#abcdef", 10);
		mainPanel.add(signup);
		
		//SignIn
		JButton signin = new JButton("Sign In");
		gui.redefineButton(signin, "#abcdef", 10);
		mainPanel.add(signin);
		
		//Transactions
		JButton transactionList = new JButton("Show All Transactions");
		gui.redefineButton(transactionList, "#abcdef", 10);
		mainPanel.add(transactionList);
		
		
		//Button Information Request
		JLabel request  = new JLabel("Action Request!");
		gui.redefineLabel(request);
		mainPanel.add(request);
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp.createSQLStatement();
			}
		});
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn.signInRequest();
			}
		});
		transactionList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionList.displayList();
			}
		});
		
	}
}