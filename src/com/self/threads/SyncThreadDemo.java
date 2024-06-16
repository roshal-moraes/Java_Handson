package com.self.threads;

public class SyncThreadDemo {

	    public static void main(String[] args) {
	        BankAccount account = new BankAccount(1000); // Initial balance of 1000

	        // Create two threads that try to withdraw money from the same BankAccount
	        Thread t1 = new Thread(new AccountRunnable(account, 500), "Thread 1");
	        Thread t2 = new Thread(new AccountRunnable(account, 700), "Thread 2");

	        // Start the threads
	        t1.start();
	        t2.start();
	    }
	

}
