package com.self.threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/*
 *  In Java, ReadWriteLock is an interface that allows multiple threads to read a resource concurrently
 *   but requires exclusive access for writing. This can improve performance when you have a high number 
 *   of readers but a low number of writers.
 * */

public class ReadWriteLockDemo {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    private int value;

    // Method to read the value
    public int readValue() {
        readLock.lock();
        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }

    // Method to write the value
    public void writeValue(int newValue) {
        writeLock.lock();
        try {
            value = newValue;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        // Create a writer thread
        Thread writerThread = new Thread(() -> {
            demo.writeValue(42);
        });

        // Create a reader thread
        Thread readerThread = new Thread(() -> {
            System.out.println("Value: " + demo.readValue());
        });

        writerThread.start();
        readerThread.start();
    }
}

