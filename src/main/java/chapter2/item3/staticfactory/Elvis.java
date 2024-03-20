package chapter2.item3.staticfactory;

//Singleton Pattern with static factory method

// Creating Singleton pattern with static factory method gives us a flexibility whether we are creating a singleton object or
// new object per thread without changing the API which is getInstance method. We have control over the creation logic of the singleton
// object with static factory method. Another advantage is we can use method reference with static factory method to create a Supplier<Elvis>
// instance and whenever get() method of the supplier instance is called it can return the singleton object.
public class Elvis {
	private static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa Baby, I'm outta here!");
	}
}
