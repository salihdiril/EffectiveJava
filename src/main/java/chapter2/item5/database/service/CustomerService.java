package chapter2.item5.database.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chapter2.item5.database.model.Customer;
import chapter2.item5.database.utils.DatabaseManager;

public class CustomerService {
	public void createCustomerTable() {
		String createTableSql = "CREATE TABLE IF NOT EXISTS customers (" + "id SERIAL PRIMARY KEY, " + "email VARCHAR(100), " + "first_name VARCHAR(50), "
				+ "last_name VARCHAR(50), " + "company VARCHAR(255), " + "created_at TIMESTAMP, " + "country VARCHAR(50))";
		try {
			DatabaseManager.executeUpdate(createTableSql);
			System.out.println("Table created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCustomer(Customer customer) {
		String insertSql = "INSERT INTO customers (email, first_name, last_name, company, created_at, country) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(DatabaseManager.DB_URL, DatabaseManager.DB_USER, DatabaseManager.DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(insertSql)) {
			DatabaseManager.executeUpdate(customer, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
