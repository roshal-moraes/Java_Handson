package com.self.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

/*
 * lock() is used to acquire the lock before modifying the shared resource.
unlock() is always called in a finally block to ensure the lock is released even if an exception occurs.
tryLock() attempts to acquire the lock without waiting, returning immediately with a boolean result.
lockInterruptibly() allows the thread to be interrupted while waiting for the lock, throwing an InterruptedException.
 *
 * */
public class ExplicitLockDemo {

	private final Lock lock = new ReentrantLock();
	private int sharedResource = 0;

	public void increment() {
		lock.lock();
		try {
			sharedResource++;
		} finally {
			lock.unlock();
		}
	}

	public void decrement() {
		lock.lock();
		try {
			sharedResource--;
		} finally {
			lock.unlock();
		}
	}

	public boolean tryIncrement() {
		boolean acquired = lock.tryLock();
		if (acquired) {
			try {
				sharedResource++;
			} finally {
				lock.unlock();
			}
		}
		return acquired;
	}

	public void interruptibleIncrement() throws InterruptedException {
		lock.lockInterruptibly();
		try {
			sharedResource++;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ExplicitLockDemo demo = new ExplicitLockDemo();

		// Using lock() and unlock()
		demo.increment();
		System.out.println("Incremented: " + demo.sharedResource);

		// Using tryLock()
		if (demo.tryIncrement()) {
			System.out.println("Incremented with tryLock: " + demo.sharedResource);
		} else {
			System.out.println("Could not increment, lock not acquired");
		}

		// Using lockInterruptibly()
		Thread thread = new Thread(() -> {
			try {
				demo.interruptibleIncrement();
				System.out.println("Incremented with lockInterruptibly: " + demo.sharedResource);
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted");
			}
		});

		thread.start();

		// Interrupt the thread to demonstrate lockInterruptibly()
		try {
			TimeUnit.SECONDS.sleep(1);
			thread.interrupt();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
