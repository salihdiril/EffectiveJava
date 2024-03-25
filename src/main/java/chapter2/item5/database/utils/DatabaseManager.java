package chapter2.item5.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import chapter2.item5.database.model.Customer;

public class DatabaseManager {
	// We don't want to hard-code credentials to connect the postgresql to perform database operations
	// So I add them as an environment variables and fetch them with System.getenv method
	public static final String DB_URL = System.getenv("DB_URL");
	public static final String DB_USER = System.getenv("DB_USER");
	public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

	// This is a utility class, so we don't want it to be instantiated
	private DatabaseManager() {
	}

	// we want to seperate the executing sql statement and error-handling logic concerns. Thus we are letting the calling
	// method handle the SQLException. That way the calling method can decide how to handle the exception and this will
	// increase the flexibility of the code.
	// This method is used to modify the database such as CREATE, INSERT, UPDATE and DELETE. It does not return any result set
	public static void executeUpdate(String sql) throws SQLException {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate();
		}
	}

	// To prevent SQL injection attacks we need to use parameterized sql statement with '?' as a placeholder and
	// set those placeholders with necessary arguments. That way we are seperating the arguments from the sql command
	// and only provide literal strings to the sql command. Hence malevolent people can't inject malicious commands
	// inside the sql command.
	public static void executeUpdate(Customer customer, PreparedStatement stmt) throws SQLException {
		// Set the parameter values to the SQL statement's placeholders
		stmt.setString(1, customer.getEmail());
		stmt.setString(2, customer.getFirstName());
		stmt.setString(3, customer.getLastName());
		stmt.setString(4, customer.getCompany());

		// We need to define the format of our JSON file's created_at value's timestamp
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		// Parse the created_at timestamp string into a LocalDateTime object
		LocalDateTime createdAtDateTime = LocalDateTime.parse(customer.getCreatedAt(), formatter);

		// Convert the LocalDateTime object to a java.sql.Timestamp
		Timestamp createdAtTimestamp = Timestamp.valueOf(createdAtDateTime);

		stmt.setTimestamp(5, createdAtTimestamp);
		stmt.setString(6, customer.getCountry());

		stmt.executeUpdate();
	}

	// This method is used to retrieve data such as SELECT. It returns a result set and we can iterate over to access the query results
	public static ResultSet executeQuery(String sql) throws SQLException {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
			return stmt.executeQuery();
		}
	}
}
