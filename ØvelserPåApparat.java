package treningsdagbok;

import java.sql.*;

public class �velserP�Apparat extends DBConn{

	
	public void �velserApparat(String navn) {
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			
			String query = "SELECT �velse.navn FROM �velsemedapparat Inner Join apparat ON �velsemedapparat.apparatid = apparat.apparatid Inner Join �velse ON �velse.�velsesid = �velsemedapparat.�velsesid WHERE apparat.navn ="+"'"+navn+"'";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			
			while (rs.next()) {
				String string = rs.getString(1);
				System.out.println(string);
			}
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
		
	}
	
}