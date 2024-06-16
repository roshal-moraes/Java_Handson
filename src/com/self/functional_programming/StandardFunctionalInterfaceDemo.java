package com.self.functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class StandardFunctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>(List.of("trial and error are common", "We are trying to fix this ", "This and them are different", "Oh to be lost in a dreamland"));
		
		
		//some standard interfaces.
		Predicate<String> predicate = s-> s.contains("are");
		Function<String,Integer> function = s->s.length();
		UnaryOperator<String> unary = s-> s.replace("are", "is");
		BiFunction<String, String, Boolean> biCategoryFilter = (s, str1) -> s.contains(str1);
		
		Consumer<String> consumer = s-> System.out.println(s);
		
		String str = "Standard string is returned";
		Supplier<String> messageSupplier  = () -> str;
		
		System.out.println(list.stream().anyMatch(predicate));
		System.out.println(list.stream().allMatch(predicate));
		
		System.out.println("Using consumer and predicate ");
		list.stream().filter(predicate).forEach(consumer);		
		
		for(String l: list) {
			System.out.println("Function applied: " + function.apply(l));
			System.out.println("Unary Function applied: " + unary.apply(l));
			System.out.println("BiFunction applied: " + biCategoryFilter.apply(l, "and"));
		}
		System.out.println("messageSupplier: " + messageSupplier.get());
		
		//Custom FI
		CustomConstructor ci = (a,b,c) -> a*b*c;
		System.out.println(ci.constructObject(23, (float) 23.45, 234.4));

	}

}
