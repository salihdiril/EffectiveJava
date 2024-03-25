package chapter2.item5.singleton;

import java.util.List;

import chapter2.item5.Lexicon;

// this class is an example for inappropriate use of singleton because there may be multiple dictionaries
// and it is also untestable and inflexible since we may want to test it with a testing-purpose dictionary
public class SpellChecker {
	private static final Lexicon dictionary = new Lexicon();
	public static final SpellChecker INSTANCE = new SpellChecker();

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
