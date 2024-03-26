package chapter2.item6.romannumerals;

public class Main {
	public static void main(String[] args) {
		// 3447 with roman numerals
		String romanNumber = "MMMCDXLVII";

		// we will measure the execution time of the two approach
		// capture the start time (ns)
		long startTime = System.nanoTime();

		// execute the code
		RomanNumeralsIneffective.isRomanNumeral(romanNumber);

		// capture the end time
		long endTime = System.nanoTime();

		// calculate the elapsed time in nanoeconds
		long elapsedTimeNanos = endTime - startTime;

		// convert the elapsed time to miliseconds
		double elapsedTimeMillis = elapsedTimeNanos / 1_000_000.0;
		System.out.println("Execution time of RomanNumeralsIneffective.isRomanNumeral(romanNumber): " + elapsedTimeMillis + " ms");

		startTime = System.nanoTime();
		RomanNumeralsEffective.isRomanNumeral(romanNumber);
		endTime = System.nanoTime();
		elapsedTimeNanos = endTime - startTime;
		elapsedTimeMillis = elapsedTimeNanos / 1_000_000.0;
		System.out.println("Execution time of RomanNumeralsEffective.isRomanNumeral(romanNumber): " + elapsedTimeMillis + " ms");

	}
}
