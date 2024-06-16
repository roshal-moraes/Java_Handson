package com.self.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		// Creating a Queue
		Queue<String> queue = new LinkedList<>();

		// Adding elements

		/*
		 * o offer(E e): Adds an element to the tail of the queue, returns true if
		 * successful, and throws an exception if the queue is full.
		 */
		queue.add("Alice");
		queue.add("Bob");
		queue.add("John");
		queue.add("Doe");

		// Removing and Retrieving from Head
		String removedElement = queue.remove(); // removes and returns the head element
		String retrievedElement = queue.peek(); // retrieves the head element without
		System.out.println(queue);
		System.out.println("peek: " + retrievedElement);

		/*
		 * //Other Methods to remove: o remove(): Removes and returns the head element,
		 * throws an exception if the queue is empty. o poll(): Removes and returns the
		 * head element, returns null if the queue is empty. o element(): Retrieves the
		 * head element without removing, throws an exception if the queue is empty. o
		 * peek(): Retrieves the head element without removing, returns null if the
		 * queue is empty.
		 */

		// Double Ended Queues
		Deque<Character> charDeque = new LinkedList<>();
		System.out.println("Deque: " + charDeque);
		System.out.println("Deque.offerLast: " + charDeque.offerLast('A'));
		// Add elts
		charDeque.addFirst('B');
		charDeque.addFirst('C');
		charDeque.offerLast('Y');
		charDeque.addLast('Z');
		System.out.println("Deque after adding elts: " + charDeque);
		char removedLast = charDeque.pollLast();
		System.out.println("Deque after pollLast: " + charDeque);
		char removedFirst = charDeque.removeFirst();
		System.out.println("Deque after removeFirst: " + charDeque);

		// Stack operations using Deque

		Deque<Integer> intDeque = new LinkedList<>();
		intDeque.push(42);
		intDeque.push(45);
		intDeque.push(76);
		intDeque.push(12);
		intDeque.push(23);
		System.out.println("stack: " + intDeque);
		int popped = intDeque.pop();
		System.out.println("stack after pop: " + intDeque);
		System.out.println("stack after pop: " + intDeque.peek());
		
		//

	}
}
