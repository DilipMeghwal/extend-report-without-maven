package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//		String connectionUrl = "jdbc:sqlserver://DESKTOP-RS8FF09.database.windows.net:1433;" + "database=TestingDB;"
//				+ "user=DESKTOP-RS8FF09\\DilipMeghwal;" + "password=9887;" + "encrypt=true;"
//				+ "trustServerCertificate=false;" + "loginTimeout=30;";
		
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestingDB;user=DESKTOP-RS8FF09\\admin;password=admin;trustServerCertificate=false;";

		
		Connection con = DriverManager.getConnection(connectionUrl);

		//with window authentication
		//Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TestingDB;integratedSecurity=true;");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Employee;");
		System.out.println(rs.toString());

		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			System.out.println( id  + " :::: " + name);
		}
		con.close();

	}

}
