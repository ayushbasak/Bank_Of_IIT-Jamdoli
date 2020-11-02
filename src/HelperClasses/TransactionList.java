package HelperClasses;
import javax.swing.*;
import java.sql.*;
public class TransactionList {
	public static void displayList() {
		GUI gui = new GUI();
		
		JFrame transactionListFrame = new JFrame("Transaction List");
		gui.redefineFrame(transactionListFrame, 500, 600);
		
		JPanel transactionListPanel = new JPanel();
		gui.redefinePanel(transactionListPanel, "#fc90ab", 0, 1, 20);
		String query = "SELECT * FROM TRANSACTION";
		ResultSet result = SQLConnection.executeQueryMultiReturn(query);
		int iter = 1;
		try {
			while (result.next()) {
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		gui.redefinePanel(transactionListPanel, "#fc90ab", 0, 1, 20);
		transactionListFrame.add(transactionListPanel);
	}
}
