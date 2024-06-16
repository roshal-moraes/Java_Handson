package com.self.threads;

/*
 * While both volatile variables and synchronization ensure memory visibility, synchronization goes further by guaranteeing atomicity and mutual exclusion. The choice between the two depends on the specific requirements of the scenario.
 * */
public class VolatileDemo {
	// The volatile keyword ensures that changes to this variable are visible to all
	// threads
	private volatile boolean stop = false;

	
    private boolean stop2 = false;

    public synchronized void requestStop() {
        stop2 = true;
    }

    public synchronized boolean isStopped() {
        return stop2;
    }
    
    public void executeThreads2() {
        // Main Thread
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            requestStop();
        }).start();

        // Second Thread
        new Thread(() -> {
            while (!isStopped()) {
            	System.out.println("Alive2.");
            }
            System.out.println("Second Thread terminated.");
        }).start();
    }


	
	public static void main(String[] args) {
		VolatileDemo vd = new VolatileDemo();
		vd.executeThreads();
		vd.executeThreads2();
	}

	public void executeThreads() {
		// Main Thread - sets the stop variable to true after 1 second
		new Thread(() -> {
			try {
				Thread.sleep(10000); // Sleep for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stop = true;
			System.out.println("Main Thread set stop to true.");
		}).start();

		// Second Thread - runs until the stop variable is set to true
		new Thread(() -> {
			while (!stop) {
				System.out.println("Alive.");
				// Perform tasks until stop is true
				// This loop will keep running until the stop variable is updated by the Main
				// Thread
			}
			System.out.println("Second Thread terminated.");
		}).start();
	}
}
