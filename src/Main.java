
//All Necessary modules
import HelperClasses.SignUp;
import HelperClasses.TransactionList;
import javax.swing.*;
import java.awt.event.*;
import HelperClasses.GUI;
import HelperClasses.SignIn;

//Main Class
public class Main{
	public static void main(String [] args) {

//		GUI 
		
		GUI gui = new GUI();
		JFrame mainFrame = new JFrame("Bank Of IIT Jamdoli");
		gui.redefineFrame(mainFrame, 500, 600);
		
		JPanel mainPanel = new JPanel();
		gui.redefinePanel(mainPanel, "#333456", 0, 1, 30);
		
		mainFrame.add(mainPanel);
		
		//Header
		JLabel header = new JLabel("BANK OF IIT-JAMDOLI : MENU");
		gui.redefineLabel(header);
		mainPanel.add(header);
		
		// Sign Up
		JButton signup = new JButton("SIGN UP");
		gui.redefineButton(signup, "#595b83", 10);
		mainPanel.add(signup);
		
		//SignIn
		JButton signin = new JButton("SIGN IN");
		gui.redefineButton(signin, "#595b83", 10);
		mainPanel.add(signin);
		
		//Transactions
		JButton transactionList = new JButton("TRANSACTIONS");
		gui.redefineButton(transactionList, "#595b83", 10);
		mainPanel.add(transactionList);
		
		
		//Button Information Request
		JLabel request  = new JLabel("");
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