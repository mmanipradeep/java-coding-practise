package com.practise.code.memory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * As you can see, the obj object is no longer alive after it is set to null,
 * but the phantomReference object is still enqueued in the queue. This means
 * that the garbage collector has determined that the obj object is eligible for
 * garbage collection, but it has not yet been cleared. The phantomReference
 * object will be removed from the queue when the obj object is finally cleared.
 * 
 * The phantomReference object can be used to determine when an object has been
 * removed from memory. This can be useful for scheduling memory-sensitive
 * tasks. For example, you could use a phantom reference to wait until a large
 * object has been removed from memory before loading another one.
 * 
 * Here is a brief explanation of the code:
 * 
 * The ReferenceQueue class is used to store phantom references that have been
 * enqueued by the garbage collector. The PhantomReference constructor takes two
 * arguments: the object that the reference refers to, and the ReferenceQueue
 * that the reference will be enqueued to. The isEnqueued() method returns true
 * if the reference has been enqueued to the ReferenceQueue. The gc() method
 * tells the garbage collector to run the garbage collection cycle.
 */
public class PhantomReferenceTest {

	private static final ReferenceQueue<Object> queue = new ReferenceQueue<>();

	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		PhantomReference<Object> phantomReference = new PhantomReference<>(obj, queue);

		System.out.println("obj is alive: " + obj.toString());
		System.out.println("phantomReference is enqueued: " + phantomReference.isEnqueued());

		obj = null;
		System.gc();

		// Wait until the phantom reference is enqueued.
		while (!phantomReference.enqueue()) {
			Thread.sleep(100);
		}

		System.out.println("obj is alive: " + obj);
		System.out.println("phantomReference is enqueued: " + phantomReference.isEnqueued());
	}
}
