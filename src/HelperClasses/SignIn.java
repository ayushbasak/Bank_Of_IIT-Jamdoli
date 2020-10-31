package HelperClasses;
//import java.sql.*;
import java.awt.*;
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

		GUI gui  = new GUI();
		JFrame signinFrame = new JFrame("Sign In");
		gui.redefineFrame(signinFrame, 600, 800);
		
		JPanel signinPanel= new JPanel();
		gui.redefinePanel(signinPanel, "#45ec67", 6,1,  20);
		
		JLabel label = new JLabel("OKIE",JLabel.CENTER);
		gui.redefineLabel(label);
		JTextField text = new JTextField(10);
		gui.redefineTextField(text);

		JButton button1 = new JButton("eagh");
		gui.redefineButton(button1, "#efab50" , 20);
		
		JRadioButton rbutton1 = new JRadioButton("Hello");
		JRadioButton rbutton2 = new JRadioButton("Hello");
		
		gui.redefineRadioButton(rbutton1);
		gui.redefineRadioButton(rbutton2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbutton1); bg.add(rbutton2);
		
		signinPanel.add(text);
		signinPanel.add(label);
		signinPanel.add(button1);
		signinPanel.add(rbutton1);
		signinPanel.add(rbutton2);
		signinFrame.add(signinPanel);
		
//		SignIn obj = new SignIn(564314);
		
//		try {
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
//			Statement st = con.createStatement();
//			String query = "SELECT * FROM Consumer WHERE ConsumerID = " + obj.consumerID;
//			ResultSet res =  st.executeQuery(query);
//			
//			while(res.next()) {
//				System.out.println(res.getString(2));
//			}
//			
//			System.out.println("Succesfully Inserted Consumer Details ");
//		}
//		catch(Exception exception){
//			exception.printStackTrace();
//		}
	}
	
	
}
