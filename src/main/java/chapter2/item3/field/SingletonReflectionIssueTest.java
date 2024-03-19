package chapter2.item3.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Now we will test if we can create another singleton object throug Reflection API
public class SingletonReflectionIssueTest {
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		System.out.println("Before using reflection: ");
		System.out.println("There are " + Elvis.getCounter() + " Elvis instance in the application");

		try {
			Constructor<Elvis> constructor = Elvis.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			Elvis newInstance = constructor.newInstance();
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		// We can see that the private constructor is called 2 times which tells us there are 2 instance of the Elvis class
		// even though we designed Elvis class to be a Singleton class
		System.out.println("\n\nAfter using reflection: ");
		System.out.println("There are " + Elvis.getCounter() + " Elvis instance in the application");
	}
}
