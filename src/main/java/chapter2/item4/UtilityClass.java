package chapter2.item4;

// Utility classes are used to group related static methods and static fields so that they can be accessed
// anywhere in the application without having to instantiate an object from it. So we need to enforce noninstantiability
// to the utility class. Making it abstract wouldn't work because another class can extend from it and instantiate an object
// and also in OOP thinking it makes developers think that an abstract class is created for inheritance.
// Hence we need to create an explicit constructor to prevent instantiation by default constructor and make the
// constructor private so other classes can't call it to create an instance of it. As a side effect it also prevents
// other classes extending from the utility class since child class can't call the super class constructor.
public class UtilityClass {

	// We also don't want to create an instance of the UtilityClass inside of it so we throw an AssertionError
	private UtilityClass() {
		throw new AssertionError();
	}
}
