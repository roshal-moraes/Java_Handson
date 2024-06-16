package com.self.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//Set interface doesnt allow duplicates
public class HashSetDemo {
	public static void main(String[] args) {
		// Creating a set of strings
		//Order of insertion not preserved
		Set<String> stringSet = new HashSet<>();
		stringSet.add("A");
		stringSet.add("B");
		stringSet.add("A"); // Duplicate, won't be added

		System.out.println(stringSet); // Output: [A, B]

		// Creating a set of custom objects (Books)
		Set<Book> bookSet = new HashSet<>();
		Book book1 = new Book("Title1", "Author1", 2022);
		Book book2 = new Book("Title1", "Author1", 2022); // Duplicate, should not be added, no error thrown

		bookSet.add(book1);
		bookSet.add(book2);

		// Printing the set of books
		for (Book book : bookSet) {
			System.out.println(book);
		}
		
		
		//LinkedHashSet - Combining hashset adn linkedlist capabilities
		//The linked list helps in preserving the order of insertion of elements.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apples");
        linkedHashSet.add("Mangoes");
        linkedHashSet.add("Oranges");

        System.out.println("LinkedHashSet: " + linkedHashSet);

		
		
	}

}