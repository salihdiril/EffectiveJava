package chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder Pattern for class hierarchies
public abstract class Pizza {
	public enum Topping {
		HAM,
		MUSHROOM,
		ONION,
		PEPPER,
		SAUSAGE
	}

	final Set<Topping> toppings; // Topping can only take one value from the enum and we can add multiple toppings in the pizza so we create a set

	// This Builder class is parameterized class and T is just a placeholder. T will be replaced at runtime and it must extend from Pizza.Builder class
	// This mechanism is called "recursive type bound" and we are using this for addTopping method to return the subclass's builder and not the
	// Pizza.Builder. If it returns Pizza.Builder then we can't call subclass's specific methods.
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self(); // self method will be called by the subclass builder instance and it will be implemented by the subclass to return itself
		}

		abstract Pizza build();

		// subclasses must override this method to return "this". This way we could use method chaining aka Fluent API
		protected abstract T self();
	}

	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone(); // this operation is for immutability
	}
}
