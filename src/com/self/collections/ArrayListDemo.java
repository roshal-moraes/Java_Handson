package com.self.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Arraylist, linkedlist preserve order of inseriton.
public class ArrayListDemo {
	public static void main(String [] args) {
	List<Integer> arrayList = new ArrayList<>();
	arrayList.add(34);
	arrayList.add(23);
	arrayList.add(3);
	arrayList.add(67);
	arrayList.add(null);
	
	//Another way is using 
	//ArrayList<String> list = new ArrayList<String>(Arrays.asList("Item1", "Item2", "Item3"));
	List<Integer> arrayList2 = new ArrayList<>(List.of(32, 356, 76));
	arrayList.addAll(arrayList2);
	
	System.out.println("arrayList: " + arrayList);
	List<Integer> subList = arrayList.subList(1, 4);
	System.out.println("subList: " + subList);
	
	arrayList.set(1, 25);
	System.out.println("arrayList: " + arrayList);
	System.out.println("subList: " + subList);
	
	subList.set(2, 45);
	System.out.println("arrayList: " + arrayList);
	System.out.println("subList: " + subList);
	
	//Changes made to sublist reflected in arraylist and vice versa.
	
	// Using iterator to traverse the list
	//Iterator allows modifying/deletingelts while traversing
	//Will give error if list has nulls.
	arrayList.remove(null);
    Iterator<Integer> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
    	int val = iterator.next();
    	if(val == 3)
    	{
    		System.out.println(arrayList.indexOf(3));
    		arrayList.set(arrayList.indexOf(3), 3+ 3);
    	}
    	
    	if(val == 356)
    	{
    		System.out.println(arrayList.indexOf(356));
    		iterator.remove();
    		
    	}
        System.out.println(val);
    }
    
	System.out.println("arrayList: " + arrayList);
	//After modifications using iterator, sublists throws error, sublist must be recreated.
	//System.out.println("subList: " + subList);
    
	
    //Another way to traverse: Using iterable interface
    for(int i: arrayList) {
    	System.out.println(i);
    }
    
    //usingForEach
    
    arrayList.forEach(i->System.out.println(i));
    //Use ctrl + space to go through other methods like remove, removeAll, contains, containsAll,indexOf, lastIndexOf, clear, etc 

    
    //ListIterator: Special interface specifically for lists. Allows bidirectional traversal, etc.
    System.out.println("ListIteratorDemo: ");
    ListIterator<Integer> listIterator = arrayList.listIterator();
    while (listIterator.hasNext()) {
        System.out.println("Index: " + listIterator.nextIndex() + ", Element: " + listIterator.next());
    }

    // Adding an element during iteration
    listIterator.add(420);
    System.out.println(arrayList);
    System.out.println("Element added during iteration");

    // Iterate backward after adding an element
    while (listIterator.hasPrevious()) {
        System.out.println("Index: " + listIterator.previousIndex() + ", Element: " + listIterator.previous());
    }

    // Removing and replacing elements during iteration
    System.out.println(arrayList);
    listIterator.next(); // Advances the cursor position
    listIterator.remove();
    System.out.println(arrayList);
    System.out.println("Element removed during iteration");

    listIterator.next(); // Advances the cursor position
    listIterator.set(440);
    System.out.println("Element replaced during iteration");
    
    System.out.println(arrayList);


	}

}
