package chapter2.item3.staticfactory;

import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Supplier<Elvis> elvisSupplier = Elvis::getInstance;
		Elvis elvis = elvisSupplier.get();
		elvis.leaveTheBuilding();
	}
}
