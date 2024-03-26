package chapter2.item6.romannumerals;

public class RomanNumeralsIneffective {

	private RomanNumeralsIneffective() {
	}

	// this code is ineffective because s.matches() create a Pattern instance each time it is invoked and Pattern instance
	// converts the regeex pattern string to a Finite State Machine (FSM) and this is an expensive operation. After pattern
	// instance is used it is eligible for garbage collection. However we don't actually change the regex pattern and we
	// don't have to create another instance of the Pattern class until we change the regex pattern. Thus we can use the
	// same pattern instance instead of creating it for each isRomanNumeral method code
	public static Boolean isRomanNumeral(String s) {
		// ^ is an anchor character and it points out the start of the string. So pattern must be matched from the start
		// (?=.) '?=' is a look-ahead operator and doesn't consume a character. '.' is any character. It tells that if there isn't any
		// character in the provided string matches method returns false
		// M* represents thousands place and there can be any number of M subsequently. M=1000 in Roman Numeral System
		// '()' represents a unit and it must be adhered when a matching searched
		// (C[DM]|D?C{0,3}) represents hundreds place, [] means only one character can be adhered in the match operation and
		// '|' operator is logical OR operator and in a group which is represented by '()' only one part can be adhered
		// so in our context either "C[DM]" part or "D?C{0,3}" part must be adhered. Thus;
		// CD=400 -> C=100 and D=500 and when smaller character comes before the greater character it means subtraction, otherwise;
		// 		it is an addition according to Roman Numeral System. So 500-100=400 is represented by CD
		// CM=900
		// nothing -> 0
		// C=100
		// CC=200
		// CCC=300
		// D=500
		// DC=600
		// DCC=700
		// DCCC=800
		// So all possible hundreds values can be found in the "(C[DM]|D?C{0,3})" pattern
		// Similarly "(X[LC]|L?X{0,3})" represents tens place and "(I[VX]|V?I{0,3})" represents ones place
		// $ operator is also an anchor character and it points out the end of the string. So the string must end with roman numeral characters
		// to matches method returning true
		return s.matches("^(?=.)M*(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3})$");
	}
}
