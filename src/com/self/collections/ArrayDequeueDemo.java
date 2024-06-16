package com.self.collections;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

//Acts as both stack and queue
//No nulls allowed
public class ArrayDequeueDemo {
	
	public static void main(String[] args) {
		// Creating an ArrayDeque, can be bounded or unbounded
		Deque<String> arrayDeque = new ArrayDeque<>();
		//Deque<String> fixedCapacityDeque = new ArrayDeque<>(10);
		Deque<Character> initializedDeque = new ArrayDeque<>(List.of('A', 'B', 'C'));


		// Adding elements as a Queue
		arrayDeque.offer("Book1");
		arrayDeque.add("Book2");
		arrayDeque.addLast("Book3");
		arrayDeque.offerLast("Book4");
		arrayDeque.offer("Book5");

		System.out.println("arrayDeque: " + arrayDeque);
		// Removing and Retrieving from Head (Queue)
		
		System.out.println("arrayDeque.poll(): " + arrayDeque.poll());
		System.out.println("arrayDeque.peek(): " + arrayDeque.peek());

		
		// Adding elements as a Stack
		arrayDeque.push("Book3");
		arrayDeque.push("Book4");

		System.out.println("arrayDeque as stack: " + arrayDeque);
		// Removing and Retrieving from Head (Stack)
		System.out.println("arrayDeque.pop(): " + arrayDeque.pop());
		System.out.println("arrayDeque.peek(): " + arrayDeque.peek());
	}

}
