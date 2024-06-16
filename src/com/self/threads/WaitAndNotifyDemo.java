package com.self.threads;

/*The produce() method will wait if hasItem is true, meaning an item is already produced and not yet consumed.
Once an item is produced, hasItem is set to true, and it calls lock.notify() to potentially wake up a thread waiting on lock.
The consume() method will wait if hasItem is false, meaning there is no item to consume.
After consuming an item, hasItem is set to false, and it calls lock.notify() to potentially wake up a thread waiting on lock.
Remember, both wait() and notify() must be called within a synchronized block or method, and the calling thread must own the monitor of the object it’s waiting or notifying on. This ensures proper coordination between the waiting and notifying threads.*/
class WaitAndNotifyDemo {
	private static Object lock = new Object();
	private static Integer lock2 ;
	private static boolean hasItem = false;

	// Producer method
	public static void produce() throws InterruptedException {
		synchronized (lock) {
			while (hasItem) {
				lock.wait();
			}
			// Produces an item
			hasItem = true;
			System.out.println("Produced an item");
			lock.notify();
		}
	}
	
	public static void produce2() throws InterruptedException {
		synchronized (lock2) {
			lock2++;
		}
	}

	// Consumer method
	public static void consume() throws InterruptedException {
		synchronized (lock) {
			while (!hasItem) {
				lock.wait();
			}
			// Consumes an item
			hasItem = false;
			System.out.println("Consumed an item");
			lock.notify();
		}
	}

	public static void main(String[] args) {

		Thread producerThread = new Thread(() -> {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread consumerThread = new Thread(() -> {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
			producerThread.start();
			consumerThread.start();

		
	}
}
