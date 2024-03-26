package chapter2.item6.romannumerals;

import java.util.regex.Pattern;

public class RomanNumeralsEffective {
	// We are creating a static Pattern instance, and we will reuse this object instead of creating it everytime like the ineffective way
	private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3})$");

	private RomanNumeralsEffective() {
	}

	public static boolean isRomanNumeral(String s) {
		return ROMAN.matcher(s).matches();
	}
}
