package chapter2.item3.enumtype;

// Enum singleton - the preferred approach

// Using enum to create a singleton object is the most concise and easy-to-understand way. It is also inherently serializable by Java
// so we don't have to implement Serializable interface and override readResolve method to prevent getting another singleton object.
// And also we don't have to use transient keyword to maintain the sonsistency of the singleton object. Enum singleton is also inherently
// thread-safe because it only has one instance and it is created when the enum class is loaded to the JVM. Java also guarantees that
// another enum instance won't be created and this makes enum singleton's to be immune to complex reflection and serialization attacks
// which I mentioned in the field and staticfactory package classes with comments.
public enum Elvis {
	INSTANCE;

	public void leaveTheBuilding() {
		System.out.println("Whoa Baby, I'm outta here!");
	}
}
