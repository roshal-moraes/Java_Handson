package com.self.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*Bounded type parameters allow us to put restrictions on the types that can be used as arguments when instantiating a generic class. 
 * This helps enforce more specific requirements on the generic types. 
 * Cannot be instantiated with primitive and array
 * Can have multiple bounds, then value must be subtype of all the bounds mentioned. Only one of the bound can be a class. 
 * Eg: class MultipleBounds<T extends Serializable & List<?>> {  ...  }
 * */
//Using wildcard(?) is not recommended as it is unbounded and makes the parameter read only.
//Adding a lowerbound(super) makes it writable
public class BoundedGenericsDemo<T extends List<?>> {
	void demonstrateMethod(T list) {
		// You can't add elements to list if I make it List<? extends Object>  due to the wildcard '?'(and doesnt have a lower bound). The list becomes read only in a way
		//list.add("Hello");
		for(Object i:list) {
			System.out.println(i);
		}
		
	}

	public static void main(String[] args) {
		BoundedGenericsDemo<ArrayList<String>> demo = new BoundedGenericsDemo<>();
		ArrayList<String> stringArrayList = new ArrayList<>();
		stringArrayList.add("Hello");
        stringArrayList.add("World");
        demo.demonstrateMethod(stringArrayList);
        
        //Raw Types: Generic method without specifying value
        //Example 1: Type Safety Issue
        List rawList = new ArrayList(); // Raw type
        rawList.add(42); // Type safety issue - may lead to runtime exception
        //Example 2: Use of Raw Types with Class Literal
        Class rawClass = BoundedGenericsDemo.class; // Valid usage of raw type
        
        //Class<MyClass> genericClass = MyClass.class; // Invalid usage - compilation error
        //Example 3: Use of Raw Types with instanceof Operator
        if (demo instanceof BoundedGenericsDemo) {System.out.println(rawClass); } // Valid usage of raw type
        //if (demo instanceof BoundedGenericsDemo<ArrayList<String>>) { /* ... */ } // Invalid usage - compilation error


        
	}

}
