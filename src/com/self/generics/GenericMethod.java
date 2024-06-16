package com.self.generics;

import org.hamcrest.core.IsInstanceOf;

public class GenericMethod {
		static <T> void typeArgumentInference(T item) {
			    System.out.println(item.getClass().getSimpleName());
			}
		
			<T> T typeArgumentInferenceReturn(T item) {
				    if(item instanceof Number) {
				    	/*...*/
				    	
				    }
				    return item;
				}

			public static void main(String[] args) {
				GenericMethod gm = new GenericMethod();
				Integer result = gm.typeArgumentInferenceReturn(42);
				
				GenericMethod.typeArgumentInference("Hello");
			}

	

}
