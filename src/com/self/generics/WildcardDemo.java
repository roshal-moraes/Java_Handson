package com.self.generics;

import java.util.Arrays;
import java.util.List;

public class WildcardDemo {
	/*
	 * Where wildcards are not allowed: Wildcards in Class Literals Java does not
	 * allow wildcards in class literals (like List<?>.class), as class literals
	 * need a non-generic class or a raw type.
	 * 
	 * Wildcards in Instanceof You cannot use wildcards with instanceof as it
	 * requires a reifiable type, which means the type must be fully available at
	 * runtime.
	 * 
	 * Wildcards in Array Creation You cannot create arrays of a generic wildcard
	 * type (like new List<?>[10]), as it is not type-safe.
	 * 
	 * Wildcards in Exceptions You cannot catch an exception of a generic wildcard
	 * type (like catch (Exception<?>)), as it is not allowed by the Java language.
	 * 
	 * Wildcards in Class Declarations You cannot declare a class with a wildcard
	 * type (like class MyClass<?>), as wildcards are not allowed in type
	 * declarations.
	 */

	// Unbounded wildcard
	public static void printList(List<?> list) {
		for (Object elem : list) {
			System.out.println(elem);
		}
	}

	// Upperbounded wildcard: Used to read values
	public static double sum(List<? extends Number> list) {
		double sum = 0.0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}

	// Used in situations to add elements of a certain type or its super types.
	public static void superDemo(List<? super Integer> list) {
		System.out.println(list);
		list.add(45);
		list.addAll(List.of(23, 45, 76));

	}

	public static <T extends Number & Comparable<? super T>> void multiBound(List<T> list) {
	    for (T elem : list) {
	        System.out.println(elem);
	    }
	}

	// As return type
	public static List<? extends Number> getNumbers() {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		return ints; // This is valid
	}

	public static void main(String[] args) {
		// Create lists to work with
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
		List<Number> numberList = Arrays.asList(1, 2.5, 3, 4.5);

		// Call printList
		System.out.println("printList Output:");
		printList(intList);

		// Call sum and print its result
		double sumResult = sum(numberList);
		System.out.println("\nsum Output:");
		System.out.println("Sum: " + sumResult);

		// Call superDemo
		System.out.println("\nsuperDemo Output:");
		superDemo(intList);

		 intList = Arrays.asList(1, 2, 3, 4, 5);
		 multiBound(intList);

		// Call getNumbers and print its result
		List<? extends Number> numbers = getNumbers();
		System.out.println("\ngetNumbers Output:");
		printList(numbers);

	}

}
