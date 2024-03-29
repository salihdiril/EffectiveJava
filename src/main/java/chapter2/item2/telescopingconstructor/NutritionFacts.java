package chapter2.item2.telescopingconstructor;

// Telescoping constructor patter - does not scale well!
// we are declaring variables as finals since we want our class to be immutable for multi-threaded environment

// If there were 20 optional parameters then we would have to create 20 constructors and that would make our
// code hard to read and complex. That's why telescoping constructor pattern does not scale well
public class NutritionFacts {
	private final int servingSize;        // (mL) 			required
	private final int servings;        // (per container) 	required
	private final int calories;        // (per serving) 	optional
	private final int fat;                // (g/serving) 		optional
	private final int sodium;            // (mg/serving) 	optional
	private final int carbohydrate;    // (g/serving) 		optional

	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	@Override
	public String toString() {
		return "{" + "servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat=" + fat + ", sodium=" + sodium
				+ ", carbonhydrate=" + carbohydrate + '}';
	}
}
