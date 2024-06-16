package com.self.collections;

import java.util.Comparator;
import java.util.TreeSet;

/*•	Comparable is for natural ordering defined by the objects themselves.
•	Comparator is for external sorting logic defined separately from the objects.

•	Comparable is an interface from the java.lang package.
•	Contains a single method: compareTo(Object obj).
•	Implemented by classes whose objects can be ordered naturally.
•	Provides a way for objects to define their own sorting logic.


•	Comparator is an interface from the java.util package.
•	Contains a method: compare(T o1, T o2).
•	Used for external sorting logic when natural ordering is not suitable.
•	Enables flexible sorting criteria defined separately from the object being sorted.

•	Comparable is for natural ordering defined by the objects themselves.
•	Comparator is for external sorting logic defined separately from the objects.
If both Comparator and Comparable are defined, Comparator takes precedence*/

public class ComparableAndComparatorDemo {
	
	public static void main(String [] args) {
		//Check bookclass for comparable impl
		TreeSet<Book> bookSet = new TreeSet<>();
		bookSet.add(new Book("Harry Potter", "J.K. Rowling", 2005));
		bookSet.add(new Book("Java Basics", "John Doe", 2020));
		bookSet.add(new Book("We Dont belong together", "Penned Emotions", 2023));
		System.out.println("Sorted Books: " + bookSet);
		
		// Using Comparator for sorting strings by length
		TreeSet<String> lengthSortedSet = new TreeSet<String>(new StringLengthComparator());
		lengthSortedSet.add("Banana");
		lengthSortedSet.add("Apple");
		lengthSortedSet.add("Cherry");
		System.out.println("Sorted by Length: " + lengthSortedSet);

		//Another way: lambda expressions
		
		  TreeSet<String> lengthSortedSetn = new TreeSet<>((s1,s2) -> {
		  System.out.println("Comparing \"" + s1 + "\" with \"" + s2 + "\""); 
		  return Integer.compare(s1.length(),s2.length());
		  });
		 
		
		//Shorter lambda expression
		TreeSet<String> lengthSortedSet2 = new TreeSet<String>((s1,s2) ->Integer.compare(s1.length(),s2.length()));
		lengthSortedSet2.add("Magenta");
		lengthSortedSet2.add("SkyBlue");
		lengthSortedSet2.add("Lavender");
		System.out.println("Sorted by Length: " + lengthSortedSet2);
		
		//Longer definition:
		TreeSet<String> lengthSortedSet3 = new TreeSet<>(new Comparator<String>() {
		    @Override
		    public int compare(String str1, String str2) {
		        return Integer.compare(str1.length(), str2.length());
		    }
		});
		lengthSortedSet3.add("Ram");
		lengthSortedSet3.add("Sita");
		lengthSortedSet3.add("Lakshman");
		lengthSortedSet3.add("Bharat");
		lengthSortedSet3.add("Urmila");
		
	}
	


}
