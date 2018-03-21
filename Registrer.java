package treningsdagbok;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class Registrer extends DBConn {
	
	Statement stmt = null;
	

	
	public void registrer_treningsokt(String dato, String tidspunkt, int varighet, int form, int prestasjon, String notat) {
		try {
			String query = "INSERT INTO trenings�kt(dato, tidspunkt, varighet, form, prestasjon, notat) "
					+ "VALUES ('"+dato+"', '"+tidspunkt+"', "+varighet+","+form+","+prestasjon+", '" + notat + "')"; 
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void registrer_aparat(int apparatid, String aparat_navn, String beskrivelse) {
		try {
			String query = "INSERT INTO apparat "
					+ "VALUES (" + apparatid + ", '" + aparat_navn+"', '"+beskrivelse+"')"; 
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void registrer_ovelse(int �velsesid, String ovelse_navn) {
		try {
			String query = "INSERT INTO �velse "
					+ "VALUES ("+ �velsesid + ", '" +ovelse_navn+"')"; 
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}

}
