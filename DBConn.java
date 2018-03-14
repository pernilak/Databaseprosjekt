package treningsdagbok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//mulig denne klassen må endres på (typ abstrakt, privat...) slik som i eksemplene.

public class DBConn {
	
	Connection conn = null;
	
	public void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/treningsdagbok?"
					+ "user=root&password=rump3ldunk123&useSSL=false");
		}
		catch (SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	/*
	
	//Slik setter man inn og skriver spørringer.
	
	Statement stmt = null;
	ResultSet rs = null;
	
	public void insett() {
		try {
			String query = "INSERT INTO treningsøkt(dato, tidspunkt, varighet, form, prestasjon) "
					+ "VALUES ('2017-01-22', '170000', 50, 4, 5)"; 
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	
	public void sporring() {
		try {
			stmt = conn.createStatement();
			
			String query = "SELECT * FROM treningsøkt";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			
			while (rs.next()) {
				String kolonne1 = rs.getString(1);
				String kolonne2 = rs.getString(2);
				System.out.println(kolonne1 + " - " + kolonne2); //printer ut kolonne 1 og 2
			}
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	*/
	public static void main(String[] args) {
		DBConn connect = new DBConn();
		connect.connect();
		//connect.insett();
		//connect.sporring();
		
	}
	
	

}
