package com.self.functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Ananas");

		// Declarative style: Filtering fruits starting with 'A'
		List<String> filteredFruits = fruits.stream().filter(fruit -> fruit.startsWith("A"))
				.collect(Collectors.toList());
		System.out.println(filteredFruits);

		List<String> words = Arrays.asList("Java", "Stream", "API", "API");

		List<String> uppercasedWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(uppercasedWords);
		
		Set<String> uppercasedWordSet = words.stream().map(String::toUpperCase).collect(Collectors.toSet());
		System.out.println(uppercasedWordSet);
		
		
		uppercasedWordSet = words.stream().map(String::toUpperCase).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(uppercasedWordSet);

		List<String> countries = Arrays.asList("India", "USA", "Canada", "Australia");
		Map<Character, List<String>> groupedCountries = countries.stream()
				.collect(Collectors.groupingBy(country -> country.charAt(0)));
		System.out.println(groupedCountries);

		// A list of lists of integers
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));

		// Using flatMap to convert it into a stream of integers
		List<Integer> flatList = listOfLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());

		// Output the flattened list
		System.out.println(flatList);

		// A list of integers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Summing the elements using reduce operation
		int sum = numbers.stream().reduce(0, Integer::sum);

		System.out.println("Sum of Numbers: " + sum);

		// Slicing the stream to get elements from index 3 to 7 (exclusive)
		List<Integer> slicedNumbers = numbers.stream().skip(3) // skips the first 3 elements
				.limit(4)// limits the stream to the next 4 elements
				.distinct()
				.collect(Collectors.toList());

		// Output the sliced list
		System.out.println(slicedNumbers);
		List<String> items = Arrays.asList("apple", "banana", "cherry", "date");

		// anyMatch example
		boolean isThereAnyApple = items.stream().anyMatch(item -> "apple".equals(item));
		System.out.println("Is there an apple? " + isThereAnyApple);

		// allMatch example
		boolean areAllFruits = items.stream().allMatch(item -> item.matches("[a-zA-Z]+"));
		System.out.println("Are all items fruits? " + areAllFruits);

		// noneMatch example
		boolean isThereNoOrange = items.stream().noneMatch(item -> "orange".equals(item));
		System.out.println("Is there no orange? " + isThereNoOrange);

		// findFirst example
		Optional<String> firstItem = items.stream().findFirst();
		firstItem.ifPresent(item -> System.out.println("First item: " + item));

		// findAny example
		Optional<String> anyItem = items.stream().findAny();
		anyItem.ifPresent(item -> System.out.println("Any item: " + item));
		
		//Reduce operations
		String filteredFruits2 = fruits.stream().filter(fruit -> fruit.startsWith("A"))
				.reduce("",(s1,s2) -> s1+ " " + s2);
		System.out.println(filteredFruits2);
		
		filteredFruits2 = fruits.stream().filter(fruit -> fruit.startsWith("A"))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.println(filteredFruits2);
		
		
		//List<Integer> numbers = Arrays.asList(5, 1, 3);
		List<Integer> resultList = numbers.stream()
		    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		/*
		 * • ArrayList::new: Supplier function to create the container • ArrayList::add:
		 * Accumulator function applied repetitively • ArrayList::addAll: Combiner
		 * function for parallel streams
		 */
		System.out.println(resultList);
		
		String result = numbers.stream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println(result);
		
		
		 

	        
	        

	}

}
