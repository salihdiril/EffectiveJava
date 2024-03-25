package chapter2.item5.dependencyinjection;

import java.util.List;
import java.util.Objects;

import chapter2.item5.Lexicon;

// we need to create a class which is flexible enough to permit the clients to choose their own dictinary resource
// Hence we need to use dependency injection and inject the dictionary into the constructor
public class SpellChecker {
	private final Lexicon dictionary;

	public SpellChecker(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}

	public static boolean isValid(String word) {
		return false;
	}

	public static List<String> suggestions(String typo) {
		return List.of();
	}
}
