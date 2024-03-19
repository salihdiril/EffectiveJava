package chapter2.item2.telescopingconstructor;

public class Main {
	public static void main(String[] args) {
		NutritionFacts water = new NutritionFacts(180, 5);
		NutritionFacts coffee = new NutritionFacts(200, 4, 126);
		System.out.println("water: " + water);
		System.out.println("coffee: " + coffee);
	}
}
