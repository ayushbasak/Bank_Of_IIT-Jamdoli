import java.sql.*;
public class Main{
	public static void main(String [] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","ayush0210");
			Statement st = con.createStatement();
			ResultSet Rs = st.executeQuery("SELECT * FROM person");
			
			while(Rs.next()) {
				System.out.println(Rs.getString("name"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}