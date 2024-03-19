package chapter2.item3.field;

import java.io.Serializable;

public class SerializableElvis implements Serializable {
	// this ID is used for serialization and deserialization processes. When we serialize an object it converts the object's current state
	// to a byte stream and for deserialization it reverses this mechanism. However if we modify the class definition (Class Name, Fields,
	// Methods, Constructors, Nested Classes, Implemented Interfaces, Extended Superclasses, Modifiers, and Annotations) then the byte stream
	// which is created according to the old version of the class will be deserialized for the old version of the class and this will create
	// a conflict, hence; the program will throw InvalidClassException. because there may be extra fields or removed methods but the deserialized
	// object won't adhere to these modification and it will create an inconsistent object.
	private static final long serialVersionUID = 0L;

	// We are creating a serializable Singleton class and we don't want to duplicate its state so that another instance of this singleton object
	// won't be created. That's why we need to use transient keyword if the singleton class has instance variables. Only non-transient variables
	// serialized in the byte stream and when the byte stream deserialized the transient fields will have a default value. However for now
	// we don't have instance variables
	public static final SerializableElvis INSTANCE = new SerializableElvis();

	private SerializableElvis() {
	}

	// We don't use transient keyword for methods because only the object's state is actually serialized and the other parts reinstated according
	// to the class definition.
	public void leaveTheBuilding() {
		System.out.println("Whoa Baby, I'm outta here!");
	}

	// Deserialization process creates a new instance from byte stream without calling constructor and we don't want to receive another instance
	// of the singleton class. So we have to make sure that deserialization process returns the same singleton instance that we use in our
	// application. Hence we need to override readResolve method. This method is called in the deserializatio process and if we return our
	// singleton instance deserialization mechanism will ignore the newly created object from the byte stream and return our singleton object.
	protected SerializableElvis readResolve() {
		return INSTANCE;
	}
}
