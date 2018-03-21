package treningsdagbok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



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
	
}
