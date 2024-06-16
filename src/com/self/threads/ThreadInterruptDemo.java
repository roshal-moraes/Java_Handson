package com.self.threads;

/*Thread interruption in Java is a mechanism that allows one thread to signal another thread to stop what it is doing and do something else. It’s a cooperative mechanism, meaning the thread being interrupted will only be affected if it is designed to handle the interruption.

Here’s how it works:

Interrupting a Thread: When you call the interrupt() method on a thread, Java sets an interrupt flag on that thread. It’s a way to request the thread to stop its current tasks1.
Handling an Interrupt: The target thread needs to check for the interrupt flag regularly. If it finds the flag to be true, it can choose to handle the interruption by changing its behavior, which often includes terminating itself2.
Interrupted Status: The interrupted status can be checked using Thread.interrupted() (which clears the status) or Thread.isInterrupted() (which does not clear the status)2.

*Handling Uninterruptible threads
*
*•	Threads blocked due to stream I/O are uninterruptible.
•	Workaround: Close the stream to trigger an exception.
•	Threads blocked due to intrinsic locks (synchronized methods or blocks) are uninterruptible.
•	Use explicit locks for interruptible behavior (covered in the next lecture).

*
*/
public class ThreadInterruptDemo extends Thread {

	public void run() {
		while (!Thread.interrupted()) {
			// The thread is doing some work here.
			System.out.println("Thread is running...");
		}
		System.out.println("Thread was interrupted and is stopping.");
	}

	public static void main(String[] args) {
		ThreadInterruptDemo t = new ThreadInterruptDemo();
		t.start();
		try {
			Thread.sleep(1000); // Main thread sleeps for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt(); // Main thread interrupts the MyThread instance
	}
}
