package com.self.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {
	
	public static void main(String [] args) {
		//If I use List only, I wont be able to use LinkedList methods
		//Null values prohibited
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(34);
		linkedList.add(23);
		linkedList.add(3);
		linkedList.add(67);
		linkedList.add(null);
		
		List<Integer> linkedList2 = new LinkedList<>(Arrays.asList(32, 356, 76));
		linkedList.addAll(linkedList2);
		
		// Access elements
		int firstElement = linkedList.getFirst();
		int lastElement = linkedList.getLast();

		
		System.out.println("linkedList: " + linkedList);
		System.out.println("firstElt: " + firstElement);
		System.out.println("lastElt: " + lastElement);
		
		linkedList.set(1, 25);
		
		System.out.println("linkedList: " + linkedList);

		// Iterator and ListIterator same as ArrayList
		//Queue operations
		
		linkedList.addFirst(1);
		linkedList.addLast(2);
		
		System.out.println("addFirstElt: " + linkedList.getFirst());
		System.out.println("addLastElt: " + linkedList.getLast());
		
		int removedFirst = linkedList.removeFirst();
		int removedLast = linkedList.removeLast();
		

		
		System.out.println("removeFirstElt: " + removedFirst);
		System.out.println("removeLastElt: " + removedLast);
		
		
		
		
		System.out.println("offerFirst: " + linkedList.offerFirst(100));
		System.out.println("offerLast: " + linkedList.offerLast(200));
		
		removedFirst = linkedList.pollFirst();
		removedLast = linkedList.pollLast();
		

		System.out.println("removeFirstElt: " + removedFirst);
		System.out.println("removeLastElt: " + removedLast);

		

		}

}
