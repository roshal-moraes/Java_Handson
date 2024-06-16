package com.self.functional_programming;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/*o	Method References: targetReference::methodName
o	Constructor References: ClassName::new*/

public class ConstructorReferenceDemo {

	public static void main(String[] args) {
		Function<String, String> stringConstructor = String::new;
		System.out.println(stringConstructor.apply("Java")); // Prints "Java"

		
		BiFunction<Integer, Float, HashMap<Integer, Float>> hashMapConstructor = HashMap::new;
		System.out.println(hashMapConstructor.apply(16, 0.75f)); // Prints an empty HashMap with the specified capacity and load factor

		

	}

}
