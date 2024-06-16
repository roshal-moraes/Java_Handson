package com.self.generics;

import java.util.ArrayList;

public class ArrayAndGenerics {
	//Demonstrating array limitations
	public static void main(String[] args) {
        // No compile-time error but throws ArrayStoreException at runtime
        Object[] objectArray = new String[5];
        objectArray[0] = 42; // Runtime exception

        // Compile-time error for generic types, ensuring type safety
        //List<String>[] stringLists = new ArrayList<String>[5]; // Compilation error
        //This is allowed
        ArrayList<Integer>[] al = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            al[i] = new ArrayList<Integer>();
        }
        
        


    }


}
