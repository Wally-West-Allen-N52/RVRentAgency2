package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection createConnectionSQLServer() throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection =
				DriverManager.getConnection(
				"jdbc:sqlserver://localhost; databaseName=RVRentAgencydb2; user=sa; password=W471984wN250299n");
		return connection;
	}
	public static void main(String[] args) throws Exception{
		Connection conn = createConnectionSQLServer();
		if (conn != null) {
			System.out.println("Successful connection " + conn);
			conn.close();
		}
	}
}
