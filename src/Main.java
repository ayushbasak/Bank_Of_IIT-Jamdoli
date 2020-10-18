import java.sql.*;

import HelperClasses.SignUp;
public class Main{
	public static void main(String [] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
			Statement st = con.createStatement();
			String query = SignUp.createSQLStatement();
			st.executeUpdate(query);
			System.out.println("Succesfully Inserted Consumer Details ");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}