package com.self.collections;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class OtherMapsDemo {
	public static void main(String[] args) {
		// Creating TreeMap instance
		TreeMap<String, Integer> userAges = new TreeMap<>();

		// Adding users and ages to TreeMap
		userAges.put("John", 30);
		userAges.put("Roger", 25);
		userAges.put("Anita", 28);

		// Printing the sorted TreeMap
		System.out.println("Sorted TreeMap: " + userAges);

		// Updating age for John using setValue method
		for (Map.Entry<String, Integer> entry : userAges.entrySet()) {
			if (entry.getKey().equals("John")) {
				entry.setValue(36);
				break;
			}
		}

		// Printing the updated TreeMap
		System.out.println("Updated TreeMap: " + userAges);
		
		// Sorting strings in descending order
        //Difference between Comparable and Comparator: comparator is used when comparison logic is defined outside object, adn comparable when it is defined as part of class.
        SortedMap<Integer, String> stringsDesc = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        stringsDesc.put(2, "Apple");
        stringsDesc.put(4, "Mango");
        stringsDesc.put(5, "Cherry");
        System.out.println("SortedMap with comparator provided : " + stringsDesc);
        
        //other operations same as SortedSet and Navigable set. Comparison based on keys.
        
        
	}
}
