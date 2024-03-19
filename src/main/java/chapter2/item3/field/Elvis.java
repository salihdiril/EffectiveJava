package chapter2.item3.field;

// Singleton with public final field

// For Singleton pattern this approach has a few drawbacks. First we can't actually control how to create singleton object
// we just call the private constructor and create an instance. We can't actually change the instance creation logic if we need
// to. E.g. if we want to create instance per thread we can't do that with this approach. Another disadvantage of this approach is
// it is possible to use reflection and bypass usual access control and call the private constructor through Reflection API and
// create another instance of the Singleton class. The last thing we should be careful is serialization process. When we serialize
// an object through Serializable interface of the Java the state of the object is converted to a byte stream and either stored in a file
// or sent to the network. When we want to deserialize the serialized object the Java creates a new instance from the byte stream
// without calling the constructor. Hence even the constructor is private a new instance can still be created throug serialization and
// deserialization process. To prevent a spurious Elvis instance we need to make its instance variables transient and override the
// readresolve method so that the deserialization process returns the same singleton instance.
public class Elvis {
	// final makes the INSTANCE field's reference unchangeable. So every time an object get this INSTANCE it will get the same reference
	private static int counter = 0; // we will increment this counter when the private constructor is called to see how many Elvis instance are there
	public static final Elvis INSTANCE = new Elvis();

	// private constructor prevents other classes to create an instance of this class. This constructor is only called once for initializing INSTANCE
	private Elvis() {
		counter++;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa Baby, I'm outta here!");
	}

	public static int getCounter() {
		return counter;
	}
}
