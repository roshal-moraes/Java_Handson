package com.self.functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamWithMapDemo {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("J.R.R. Tolkien", 1954, 5));
		bookList.add(new Book("J.R.R. Tolkien2", 1955, 4));
		bookList.add(new Book("J.R.R. Tolkien", 1955, 5));

		
		//Uding groupingBy
		Map<String, Double> authorToAverageRatingMap = bookList.stream()
				.collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingInt(Book::getRating)));

		System.out.println(authorToAverageRatingMap);

		/*
		 * //Without handling duplicate Map<Integer, Book> map = bookList.stream()
		 * .collect(Collectors.toMap(Book::getYear, Function.identity()));
		 */

		//Using toMap
		Map<Integer, Book> map = bookList.stream().collect(Collectors.toMap(Book::getYear, Function.identity(),
				(existing, replacement) -> existing.getRating() <= replacement.getRating() ? existing : replacement));

		System.out.println(map);

		// To specify type of map
		map = bookList.stream().collect(Collectors.toMap(Book::getYear, Function.identity(),
				(existing, replacement) -> existing.getRating() <= replacement.getRating() ? existing : replacement,
				TreeMap::new));

		System.out.println(map);
		// Downstream collectors

		Map<Integer, Long> ratingsCountMap = bookList.stream()
				.collect(Collectors.groupingBy(Book::getRating, Collectors.counting()));

		System.out.println(ratingsCountMap);
		
		
		//minBy, maxBy
		Map<Integer, Optional<Book>> minPriceMap = bookList.stream().collect(
				Collectors.groupingBy(Book::getYear, Collectors.minBy(Comparator.comparingDouble(Book::getRating))));

		Map<Integer, Optional<Book>> maxPriceMap = bookList.stream().collect(
				Collectors.groupingBy(Book::getYear, Collectors.maxBy(Comparator.comparingDouble(Book::getRating))));

		System.out.println(minPriceMap);
		System.out.println(maxPriceMap);
		
		//Summarizing
		Map<Integer, DoubleSummaryStatistics> ratingsSummaryMap = bookList.stream()
			    .collect(Collectors.groupingBy(Book::getYear, Collectors.summarizingDouble(Book::getRating)));

		System.out.println(ratingsSummaryMap);
		
	
		//PartitionBy
		Map<Boolean, List<Book>> partitionedMap = bookList.stream()
			    .collect(Collectors.partitioningBy(book -> book.getRating() >= 4));
		 
		System.out.println(partitionedMap);
		
		Map<Integer, List<String>> ratingsTitleMap = bookList.stream()
			    .collect(Collectors.groupingBy(Book::getRating,
			                                   Collectors.mapping(Book::getAuthor, Collectors.toList())));
		
		System.out.println(ratingsTitleMap);
		
		//Multilevel grouping
		Map<Integer, Map<String, List<Book>>> multilevelMap = bookList.stream()
			    .collect(Collectors.groupingBy(Book::getRating,
			                                   Collectors.groupingBy(Book::getAuthor)));

		System.out.println(multilevelMap);
		


	}

}
