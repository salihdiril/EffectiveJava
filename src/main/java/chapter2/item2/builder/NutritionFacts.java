package chapter2.item2.builder;
// Builder Pattern

// telescopic constructor pattern has scaling issue and JavaBeans pattern has immutability issue
// however with builder pattern we can create immutable objects and also more concise class definition
// compared to telescopic constructor pattern
public class NutritionFacts {
	// Required Parameters
	private final int servingSize;
	private final int servings;

	// Optional Parameters
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	// We are creating a static inner class because we will only use this class for this NutritionFacts outer class and
	// don't want to inflate our codebase. Inner static classes are bound to the outer class and they can only access
	// static members of the outer class. They are not bound to the instances of the outer class, therefore; we can
	// directly create them with outer class' reference
	public static class Builder {
		// Required Parameters
		private final int servingSize;
		private final int servings;

		// Optional Parameters
		// we don't have to provide these optional arguments to the outer class constructor, and if we do we can do it
		// with setter methods.
		private int calories;
		private int fat;
		private int sodium;
		private int carbohydrate;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}

		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}

		public Builder sodium(int sodium) {
			this.sodium = sodium;
			return this;
		}

		public Builder carbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}

	@Override
	public String toString() {
		return "{" + "servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat=" + fat + ", sodium=" + sodium
				+ ", carbohydrate=" + carbohydrate + '}';
	}
}
