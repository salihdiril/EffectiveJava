package chapter2.item2.javabeans;

public class Main {
	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);

		System.out.println("cocaCola: " + cocaCola);
	}
}
