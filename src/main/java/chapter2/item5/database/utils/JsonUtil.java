package chapter2.item5.database.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import chapter2.item5.database.model.Customer;
import chapter2.item5.database.service.CustomerService;

// This is a utility class to read from JSON file and parse each JSON element to a Customer object
public class JsonUtil {
	// the file is inside the src/main/resources folder, hence we don't need to provide a path since we don't read
	// it from the filesystem. We are using a Maven project structure, thus; the file is bundled with the project and
	// the project is in our classpath. So JVM can find the file through project's root path with necessary methods
	public static final String CUSTOMERS_JSON_FILE = "C:\\Users\\salih.diril\\Documents\\Tutorials\\Java\\EffectiveJava\\src\\main\\resources\\customers.json";

	// prevents instantiation of this utility class
	private JsonUtil() {
	}

	// reads from customers.json file and return its content as a String
	private static String readJsonFile() {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(CUSTOMERS_JSON_FILE)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	private static List<Customer> parseJsonToCustomers(String jsonData) {
		List<Customer> customers = new ArrayList<>();

		// jsonData is a string which represents my customers.json file and it looks like
		// "[{\"id\":1,\"email\":\"isidro_von@hotmail.com\",\"first\":\"Torrey\",\"last\":\"Veum\",\"company\":\"Hilll, Mayert and Wolf\",\"created_at\":\"2014-12-25T04:06:27.981Z\",\"country\":\"Switzerland\"},
		// {\"id\":2,\"email\":\"frederique19@gmail.com\",\"first\":\"Micah\",\"last\":\"Sanford\",\"company\":\"Stokes-Reichel\",\"created_at\":\"2014-07-03T16:08:17.044Z\",\"country\":\"Democratic People's Republic of Korea\"}, ...]"
		// '[]' represents an array oj JSONObjects which is a JsonArray and each '{}' represents a JSONObject
		// Hence below statements creates a JSONArray which contains JSONObject instances from jsonData string
		JSONArray jsonArray = new JSONArray(jsonData);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Customer customer = new Customer.Builder() //
					.email(jsonObject.getString("email")) //
					.firstName(jsonObject.getString("first")) //
					.lastName(jsonObject.getString("last")) //
					.company(jsonObject.getString("company")) //
					.createdAt(jsonObject.getString("created_at")) //
					.country(jsonObject.getString("country")) //
					.build();
			customers.add(customer);
		}
		return customers;
	}

	public static void insertCustomersFromJson(CustomerService customerService) {
		String jsonData = readJsonFile();
		List<Customer> customers = parseJsonToCustomers(jsonData);
		for (Customer customer : customers) {
			customerService.addCustomer(customer);
		}
	}
}
