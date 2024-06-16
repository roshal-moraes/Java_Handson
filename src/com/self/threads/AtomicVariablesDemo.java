package com.self.threads;

import java.util.concurrent.atomic.AtomicLong;

/*Atomic variables offer the same memory visibility guarantees as volatile variables but additionally
 *  support atomicity like synchronization. However, atomicity is limited to single variables;
 *   they cannot guard a block of code like synchronization.*/

/*Java provides various atomic variable classes, categorized into four groups:
•	Scalars: AtomicLong, AtomicInteger, AtomicBoolean, AtomicReference
•	Arrays: AtomicLongArray, AtomicIntegerArray, AtomicReferenceArray
•	Field Updaters: AtomicLongFieldUpdater, AtomicIntegerFieldUpdater, AtomicReferenceFieldUpdater
•	Compound Variables: AtomicMarkableReference, AtomicStampedReference
*/
public class AtomicVariablesDemo {
    // AtomicLong ensures that operations on ID are atomic
    private static AtomicLong ID = new AtomicLong(0);

    // This method increments the ID atomically and returns the new value
    public static long getNewId() {
        return ID.incrementAndGet();
    }

    public static void main(String[] args) {
        // Let's create multiple threads to demonstrate the atomicity of getNewId()
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("Generated ID: " + getNewId());
            }).start();
        }
    }
}