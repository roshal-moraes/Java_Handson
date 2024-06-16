package com.self.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionInterfaceDemo {

	    private final Lock lock = new ReentrantLock();
	    private final Condition notFull = lock.newCondition();
	    private final Condition notEmpty = lock.newCondition();

	    private final Object[] items = new Object[10];
	    private int putptr, takeptr, count;

	    public void put(Object x) throws InterruptedException {
	        lock.lock();
	        try {
	            while (count == items.length)
	                notFull.await();
	            items[putptr] = x;
	            if (++putptr == items.length) putptr = 0;
	            ++count;
	            notEmpty.signal();
	        } finally {
	            lock.unlock();
	        }
	    }

	    public Object take() throws InterruptedException {
	        lock.lock();
	        try {
	            while (count == 0)
	                notEmpty.await();
	            Object x = items[takeptr];
	            if (++takeptr == items.length) takeptr = 0;
	            --count;
	            notFull.signal();
	            return x;
	        } finally {
	            lock.unlock();
	        }
	    }

	    public static void main(String[] args) {
	    	ConditionInterfaceDemo buffer = new ConditionInterfaceDemo();

	        // Create producer thread
	        Thread producer = new Thread(() -> {
	            try {
	                int value = 0;
	                while (true) {
	                    buffer.put(value++);
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        });

	        // Create consumer thread
	        Thread consumer = new Thread(() -> {
	            try {
	                while (true) {
	                    System.out.println(buffer.take());
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        });

	        // Start both threads
	        producer.start();
	        consumer.start();
	    }
	}

