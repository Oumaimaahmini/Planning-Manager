package planningAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectSQLserver {
	
	Connection conn = null;
	
	public static Connection ConnectDB() {
		
		try {
			String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            String user = "planning";
            String pass = "password";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            return conn;
		}catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
	}
	

}
