package com.practise.oopsconcept.Interface;

public interface Electronic {

	/**
	 * 1. We cant instantiate intercaes directly
	 * 
	 * 2. Interfce can be empty .
	 * 
	 * 3. final keyword cannot be in calls level
	 * 
	 * 4. Abstract modifier will be added automatically by compaiiler . It can only
	 * be public or default access modigfier
	 * 
	 * 5. only public, private, abstract, default, static and strictfp are permitted
	 * for methods
	 * 
	 * 
	 * up until Java 9, interface methods could not be private; however, Java 9
	 * introduced the possibility to define private methods in interfaces
	 * 
	 * 
	 * interface variables are public, static, and final by definition; we're not
	 * allowed to change their visibility
	 * 
	 */

//	
//	Rules For using Private Methods in Interfaces
//
//	Private interface method cannot be abstract and no private and abstract modifiers together.
//	Private method can be used only inside interface and other static and non-static interface methods.
//	Private non-static methods cannot be used inside private static methods.
//	We should use private modifier to define these methods and no lesser accessibility than private modifier.
//	
//	So, from above it can be concluded that java 9 private interface methods can be static or instance. In both cases, 
//	the private method is not inherited by sub-interfaces or implementations. They are mainly there to improve code re-usability within interface only – thus improving encapsulation.
//	
//	
	// Constant Variable
	String LED = "LED"; /// Only public static and final is allowed

	// abstract method
	int getElectricityUsage();

	// Static method
	static boolean isEnergyEfficient(String electtronicType) {
		if (electtronicType.equals(LED)) {
			return true;
		}
		return false;
	}

	// Default method
	default void printDescription() {
		System.out.println("Electronic Description");
	}

}
