package com.practise.code.memory;

import java.lang.ref.SoftReference;

/**
 * 
 * The output of the code will vary depending on how much memory your computer
 * has. If your computer has a lot of memory, the soft reference will remain
 * valid even after you create 1000 objects. However, if your computer has less
 * memory, the soft reference may become invalid after you create a few hundred
 * objects.
 */
public class SoftReferenceTest {

	public static void main(String[] args) {
		// Create a soft reference to an object.
		SoftReference<Object> softRef = new SoftReference<>(new Object());

		// Check if the soft reference is still valid.
		if (softRef.get() != null) {
			System.out.println("The soft reference is still valid.");
		} else {
			System.out.println("The soft reference is no longer valid.");
		}

		// Create more objects to fill up the memory.
		for (int i = 0; i < 1000; i++) {
			new Object();
		}

		// Check if the soft reference is still valid.
		if (softRef.get() != null) {
			System.out.println("The soft reference is still valid.");
		} else {
			System.out.println("The soft reference is no longer valid.");
		}
	}

}
