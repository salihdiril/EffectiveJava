package chapter2.item2.hierarchicalbuilder;

import static chapter2.item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.HAM;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.MUSHROOM;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.ONION;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.PEPPER;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.SAUSAGE;

public class Main {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(MUSHROOM).addTopping(PEPPER).build();
		Calzone calzone = new Calzone.Builder().addTopping(HAM).addTopping(ONION).build();
		System.out.println(pizza);
		System.out.println(calzone);
	}
}
