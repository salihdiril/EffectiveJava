package chapter2.item5.utilityclass;

import java.util.List;

import chapter2.item5.Lexicon;

// This class is just an example. It is non-functional
public class SpellChecker {
	// This approach isn't useful because it assumes only one dictionary is enough
	// However there are a lot of languages which has different dictionaries.
	// Also there are dictionaries for specific fields that contains specific terms
	// Static utility classes also untestable since we can't have their instances and provide mocks as dependencies
	// Static methods are hard to mock and they are bounded to the class itself and use global variables
	// So we can't isolate the tested code properly which is the main purpose of the unit tests
	// like the Customer database application in the database package we can see that creating a connection to the
	// database, creating a test database, creating a table in the test database, providing data to the table and
	// writing sql statements to perform operations on the table are hard and time-consuming process. Hence we don't
	// want to do the same things in unit testing and mock these external dependencies. However it is hard to do that
	// with static methods, global variables and utility classes.
	private static final Lexicon dictionary = new Lexicon();

	// Noninstantiable
	private SpellChecker() {
	}

	public static boolean isValid(String word) {
		return false;
	}

	public static List<String> suggestions(String typo) {
		return List.of();
	}
}
