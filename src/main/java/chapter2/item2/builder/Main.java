package chapter2.item2.builder;

public class Main {
	public static void main(String[] args) {
		NutritionFacts water = new NutritionFacts.Builder(180, 5).build();
		NutritionFacts coffee = new NutritionFacts.Builder(200, 4).calories(126).build();
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
		System.out.println("water: " + water);
		System.out.println("coffee: " + coffee);
		System.out.println("cocaCola: " + cocaCola);
	}
}
