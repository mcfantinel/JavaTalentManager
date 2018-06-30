package database.dao;

import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Users;

public class UsersDao {

	public static List<Users> getUsers() {
		List<Users> users = new ArrayList<Users>();

		// String user = "Trend";
		// LocalDate dateNow = LocalDate.now();
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

		String query = "SELECT * FROM USERS";

		users = DBConnection.executeSelect(query);

		return users;

	}
}
