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
		
		String data[][] = new String[100][6];
		
		int iter = 0;
		try {
			while (result.next()) {
				data[iter][0] = iter+1+"";
				data[iter][1] = result.getString(1);
				data[iter][2] = result.getString(2);
				data[iter][3] = result.getString(3);
				data[iter][4] = result.getString(4);
				data[iter][5] = result.getString(5);
				iter+=1;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String columns[] = {"Sr. No.","Bank Account Number","Transaction Type","Destination (if any)","Date of Transaction","Amount"};
		JTable dataSet = new JTable(data,columns);
		JScrollPane scroll = new JScrollPane(dataSet);
		gui.redefinePanel(transactionListPanel, "#fc90ab", 0, 1, 20);
		transactionListPanel.add(scroll);
		transactionListFrame.add(transactionListPanel);
	}
}
