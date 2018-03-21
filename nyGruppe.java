package treningsdagbok;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class nyGruppe extends DBConn {
	
	Statement stmt = null;
	ResultSet rs = null;
	
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}
	
	public void �velseIgruppe(int id){
		
	try {
		stmt = conn.createStatement();
		
		String query = "SELECT gruppeid,navn FROM �velse Inner Join �velseigruppe ON (�velse.�velsesid = �velseigruppe.�velsesid) WHERE gruppeid="+id+";";
		if (stmt.execute(query)) {
			rs = stmt.getResultSet();
		}
		
		while (rs.next()) {
			String string = rs.getString(1);
			String string2 = rs.getString(2);
			System.out.println(string+ " "+string2);
		}
	}
	catch(SQLException ex) {
		System.out.println("SQLException " + ex.getMessage());
	}
	
}      
	            
	
	public void insett�velseGruppe(int gruppeID, String muskelgruppe) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into �velsesGruppe values ("+gruppeID+",\'"+muskelgruppe+"\')");
			System.out.println("gruppe ble lagret");
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void insett�velserIGruppen(int �velsesID, int gruppeID) {
		try {
			stmt = conn.createStatement();
			String query = "insert into �velseigruppe values(" + gruppeID + ", "+ �velsesID +");";
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void get�velser() {
		try {
			stmt = conn.createStatement();
			String query = "select * from �velse;";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			
			String rad = rightPadding("�velsesID", 15) + rightPadding("Navn p� �velse", 15);
			while (rs.next()) {
				String kolonne = null;
				rad += "\n";
				for (int i = 1; i < 3; i++) {
					kolonne = rs.getString(i);
					rad += rightPadding(kolonne, 15);
				}	
			}
			System.out.println(rad);
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
		
	}
} 