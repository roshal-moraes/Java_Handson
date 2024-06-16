package com.self.collections;
//Collection class is a utility for Colection interface

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionClassDemo {

	public static void main(String[] args) {
		List<String> originalList = new ArrayList<>(List.of("Tillu", "Tikha"));
		List<String> additionalElements = List.of("Malkhan", "Tiwari");
		// Add allmethod
		Collections.addAll(originalList, additionalElements.toArray(new String[0]));
		Collections.sort(originalList);

		int index = Collections.binarySearch(originalList, "John");

		/*
		 * Additional Methods reverse: Reverses the elements of a list. swap: Swaps the
		 * elements at specified indices. frequency: Counts the occurrences of a
		 * specified element in a list. shuffle: Shuffles the elements of a list. max
		 * and min: Returns the maximum and minimum elements, respectively. 6.singleton
		 * Methods singleton: Returns an immutable set containing only the specified
		 * element. singletonList: Returns an immutable list containing only the
		 * specified element. singletonMap: Returns an immutable map containing only the
		 * specified key-value pair.
		 * 
		 * Collections.emptyList(): Returns the same immutable empty list instance. •
		 * Similar methods: Collections.emptySet(), Collections.emptyMap().
		 * 
		 */
		// unmodifiableCollection Method Returns an unmodifiable view of the specified
		// collection.

		List<String> readOnlyCollection = (List<String>) Collections.unmodifiableCollection(originalList);
		System.out.println(readOnlyCollection);

		/*
		 * 8.checkedCollection Method • Returns a dynamically typesafe view of the
		 * specified collection. • Useful for ensuring type safety in collections. •
		 */
		List<String> typedSafeCollection = (List<String>) Collections.checkedCollection(originalList, String.class);
		System.out.println(typedSafeCollection);

	}

}
