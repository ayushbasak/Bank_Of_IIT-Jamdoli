package HelperClasses;
import java.sql.*;
public class SQLConnection {
	String query;
	Connection Con;
	Statement st;
	SQLConnection(String query){
		try {
			this.Con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
			this.st = this.Con.createStatement();
			this.query = query;
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}
	
	public static String executeQueryWithReturn(String query,int columnNumber) {
		SQLConnection sql = new SQLConnection(query);
		String output = "";
		try {
			ResultSet res = sql.st.executeQuery(query);
			
			if(res.next()) {
				output = res.getString(columnNumber);
			}
			else {
				res.close();
				output = "NO RETURN";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	public static void executeQueryNoReturn(String query) {
		SQLConnection sql = new SQLConnection(query);
		try {
			sql.st.executeUpdate(query);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
