package com.self.collections;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class OtherSetsDemo {
	
	public static void main(String []args) {
	//	SortedSet is a subinterface of Set that extends the basic set functionality with sorting capabilities.
    SortedSet<Integer> numbersAsc = new TreeSet<>();

    
    numbersAsc.add(5);
    numbersAsc.add(2);
    numbersAsc.add(8);
    numbersAsc.add(10);
    numbersAsc.add(4);
    numbersAsc.add(18);

    System.out.println("Ascending Order: " + numbersAsc); 
    System.out.println("numbersAsc.subSet(0, 5): " + numbersAsc.subSet(0, 5));
    
    System.out.println("numbersAsc.headSet(8): " + numbersAsc.headSet(8));
    System.out.println("numbersAsc.tailSet(8): " + numbersAsc.tailSet(8));
    System.out.println("First Elt: " + numbersAsc.first());
    System.out.println("Last Elt: " + numbersAsc.last());
    


    // Sorting strings in descending order
    //Difference between Comparable and Comparator: comparator is used when comparison logic is defined outside object, adn comparable when it is defined as part of class.
    SortedSet<String> stringsDesc = new TreeSet<>((s1, s2) -> s2.compareTo(s1));
    stringsDesc.add("Apple");
    stringsDesc.add("Banana");
    stringsDesc.add("Cherry");

    System.out.println("Descending Order: " + stringsDesc);
    
    
    //•	NavigableSet is a subinterface of SortedSet that provides extended navigation capabilities.
    //TreeSet implements both SortedSet and NavigableSet
    NavigableSet<Integer> navigableSet = new TreeSet<>();
    navigableSet.add(5);
    navigableSet.add(10);
    navigableSet.add(20);
    navigableSet.add(30);

    System.out.println("Navigable Set: " + navigableSet);
    System.out.println("Ceiling(15): " + navigableSet.ceiling(15)); 
    System.out.println("Floor(15): " + navigableSet.floor(15));    
    System.out.println("Higher(15): " + navigableSet.higher(15));   
    System.out.println("Lower(15): " + navigableSet.lower(15));     
    System.out.println("Descending Set: " + navigableSet.descendingSet()); 

    //Other functions include pollFirst. pollLast, etc
    
	}
	
	
	

}
