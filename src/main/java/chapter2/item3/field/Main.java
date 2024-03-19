package chapter2.item3.field;

public class Main {
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		Elvis elvis2 = Elvis.INSTANCE;
		Elvis elvis3 = Elvis.INSTANCE;
		elvis.leaveTheBuilding();

		// we can see that even though we declare 3 different Elvis variable we still have only 1 Elvis instance
		System.out.println("There are " + Elvis.getCounter() + " Elvis instance in the application");
	}
}
