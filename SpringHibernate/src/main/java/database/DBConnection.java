package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class DBConnection {

	private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/JavaTest";
	private static final String username = "postgres";
	private static final String password = "admin";

	public static List<Users> executeSelect(String query) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Users> users = new ArrayList<Users>();

		try {
			// Step 1 - Load driver
			Class.forName("org.postgresql.Driver"); // Class.forName() is not needed
			// since JDBC 4.0

			// Step 2 - Open connection
			conn = DriverManager.getConnection(jdbcUrl, username, password);

			// Step 3 - Execute statement
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				users.add(new Users(rs.getInt(1), rs.getString(2),
						LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-d"))));
			}

			// stmt.execute("INSERT INTO USERS (username, creationdate) Values ('" + user +
			// "','" + formatter.format(dateNow) +"')");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {

				// Step 5 Close connection
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
