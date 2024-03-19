package chapter2.item2.hierarchicalbuilder;

// subclass with hierarchical builder
public class NyPizza extends Pizza {
	public enum Size {
		SMALL,
		MEDIUM,
		LARGE
	}

	private final Size size;

	// T in Pizza.Builder replaced with Builder here and this Builder is NyPizza.Builder
	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = size;
		}

		@Override
		NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder); // first we are passing NyPizza.Builder in place of T and set the Pizza.Builder variables which is toppings
		this.size = builder.size;
	}

	@Override
	public String toString() {
		return "New York Pizza with " + toppings;
	}
}
