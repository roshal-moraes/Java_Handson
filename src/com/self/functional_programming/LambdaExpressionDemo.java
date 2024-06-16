package com.self.functional_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExpressionDemo {
	 public static void main(String[] args) {
		 
		 Comparator<String> stringComparator = new Comparator<String>() {
			    @Override
			    public int compare(String s1, String s2) {
			        return s1.compareTo(s2);
			    }
			};

		 Comparator<Integer> comp = (s1,s2)-> {
			 
			 return Integer.compare(s2, s1);
		};
		

		
		// Simplified Lambda with inferred types and single statement
		Comparator<Integer> simplifiedLambda = (s1, s2) -> s1.compareTo(s2);
		//This list is immutable
		List<Integer> list1 = List.of(34,6,23,435,123,1,234,45,23);
		
		List<Integer> list = new ArrayList<>(list1);
		
		Collections.sort(list, comp);
		System.out.println(list);
		Collections.sort(list, simplifiedLambda);
		System.out.println(list);
		Collections.sort(list, (s1,s2)->  s2.compareTo(s1));
		System.out.println(list);

		//Within thread, we are passing implementation of run method of Runnable interface.
		Thread t1 = new Thread(() -> {System.out.println("Within Thread");});
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		// Lambda with a parameter and void return type
		Consumer<Book> printTitleLambda = book -> System.out.println(book.getTitle());

		// Lambda with a parameter and boolean return type
		Predicate<Book> highRatingLambda = book -> book.getRating() >= 4.5;
		
		Book book = new Book();
		book.fiDemo(()->System.out.println("Funcional Interface implementation "), (s1,s2) -> s1 + (-s2) );

		
	 }

}
