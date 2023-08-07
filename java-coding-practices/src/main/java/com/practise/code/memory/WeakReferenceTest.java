package com.practise.code.memory;

import java.lang.ref.WeakReference;

/**
 * This code will first create a new object and then create a weak reference to
 * the object. The weak reference will be checked to see if it is still pointing
 * to the object. Then, the weak reference will be invalidated. Finally, the
 * weak reference will be checked again to see if it is still pointing to the
 * object.
 * 
 * In this example, the weak reference will be no longer pointing to the object
 * after it is invalidated. This is because a weak reference is only guaranteed
 * to be pointing to an object as long as the object is still reachable by the
 * garbage collector. Once the object is no longer reachable, the weak reference
 * will be cleared and will no longer point to the object.
 * 
 * Here is an explanation of the code:
 * 
 * The WeakReference class is used to create a weak reference to an object. The
 * get() method on the WeakReference class returns the object that the weak
 * reference is pointing to. The clear() method on the WeakReference class
 * invalidates the weak reference.
 */

public class WeakReferenceTest {

	public static void main(String[] args) {
		// Create a new object
		Object object = new Object();

		// Create a weak reference to the object
		WeakReference<Object> weakReference = new WeakReference<>(object);

		// Check if the weak reference is still pointing to the object
		System.out.println("Is the weak reference pointing to the object? " + weakReference.get() != null);

		// Garbage collect the object
		System.gc();

		// Check if the weak reference is still pointing to the object
		System.out.println("Is the weak reference pointing to the object? " + weakReference.get() != null);
	}
}