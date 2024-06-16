package com.self.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	    private int count = 0;
	    private final Lock lock = new ReentrantLock();

	    public void increment() {
	        lock.lock();  // Block until the lock is acquired
	        try {
	            count++;
	        } finally {
	            lock.unlock();  // Ensure the lock is released even if an exception is thrown
	        }
	        
	        System.out.println("Unlocked content.");
	    }

	    public int getCount() {
	        return count;
	    }

	    public static void main(String[] args) {
	    	LockDemo counter = new LockDemo();

	        // Create two threads that increment the counter
	        Thread t1 = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.increment();
	            }
	        });

	        Thread t2 = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.increment();
	            }
	        });

	        // Start the threads
	        t1.start();
	        t2.start();

	        // Wait for the threads to finish
	        try {
	            t1.join();
	            t2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Print the final count value
	        System.out.println("Final count: " + counter.getCount());
	    }


}
