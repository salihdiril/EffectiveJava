package chapter2.item2.javabeans;
// JavaBeans pattern - allows inconsistency, mandates mutability

// Since JavaBeans pattern uses no-args constructor and set the class variables with setter methods
// we can't actually use final keyword. Because we set the variables' values after creating the object
// Hence if we use final here we would already set the values as default with no-args constructor.
// That's why JavaBeans pattern mandates mutability
public class NutritionFacts {
	private int servingSize = -1;        // required, no default value
	private int servings = -1;        // required, no default value
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	@Override
	public String toString() {
		return "{" + "servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat=" + fat + ", sodium=" + sodium
				+ ", carbonhydrate=" + carbohydrate + '}';
	}
}
