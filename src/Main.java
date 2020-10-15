import java.sql.*;
public class Main{
	public static void main(String [] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IITJamdoli","root","*Ayush0210*");
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