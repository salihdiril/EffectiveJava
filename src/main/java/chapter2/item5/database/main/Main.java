package chapter2.item5.database.main;

import chapter2.item5.database.service.CustomerService;
import chapter2.item5.database.utils.JsonUtil;

public class Main {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

		// create Customer table in the database
		customerService.createCustomerTable();

		// add each JSON element in the customers.json file to the customers table in the database
		JsonUtil.insertCustomersFromJson(customerService);
	}
}
