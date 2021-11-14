package fa.training.problem02.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection con = null;
	
	private static final String URL = "jdbc:mysql://localhost:3306/dbo";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Satori071256.";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(con == null || con.isClosed()) {
				openConnection();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static synchronized void openConnection() {
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void closeConnection() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
