package com.practise.oopsconcept.abstraction;

public abstract class AbstractSample4 {

	/**
	 * • An abstract class can have both abstract and non abstract (or concrete)
	 * method
	 * 
	 * • The abstract method should not have method body. Even empty flower braces {
	 * } are not allowed.
	 * 
	 * 
	 * • Any sub-class extending from an abstract class should either implement all
	 * the abstract methods of the super-class or the sub-class itself should be
	 * marked as abstract.
	 * 
	 * • If an abstract class contains multiple methods, it is not necessary that
	 * all the methods of the abstract class are implemented in the immediate
	 * sub-class. Few of them can be implemented in sub-sub-classes or any where
	 * else in the sub-class hierarchy. But for a class to be concrete, all the
	 * abstract methods in its super-class must be implemented.
	 * 
	 * • It is not necessary to add the abstract methods only in the super most
	 * class, we can add more abstract methods in the sub-classes.
	 * 
	 */

	void method1() {
		System.out.println("I am a concrete method");
	}

	abstract double method2(int x, int y);

	void method3(double z) {
		System.out.println("I am also a concrete method");
	}

	abstract boolean method4(char z);

}
