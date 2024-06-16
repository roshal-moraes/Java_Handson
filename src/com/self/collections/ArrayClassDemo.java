package com.self.collections;

import java.util.Arrays;

public class ArrayClassDemo {
	public static void main(String[] args) {
        // Using asList to convert array to a fixed-size list
        String[] stringArray = {"Tom", "Jerry", "Popeye"};
        System.out.println("Original Array: " + Arrays.toString(stringArray));

        // Using asList to create a fixed-size list
        var fixedSizeList = Arrays.asList(stringArray);
        System.out.println("Fixed-Size List: " + fixedSizeList);

        // Modifying the original array reflects in the list
        fixedSizeList.set(0, "Roger");
        System.out.println("Modified Array: " + Arrays.toString(stringArray));
        System.out.println("Modified List: " + fixedSizeList);

        // Sorting arrays using the sort method
        int[] intArray = {4, 2, 9, 1, 8};
        Arrays.sort(intArray);
        System.out.println("Sorted Array: " + Arrays.toString(intArray));

        // Binary search on a sorted array
        int searchKey = 5;
        int resultIndex = Arrays.binarySearch(intArray, searchKey);
        System.out.println("Binary Search Result for " + searchKey + ": " + resultIndex);

        // Copying arrays using copyOf
        int[] copiedArray = Arrays.copyOf(intArray, 7);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // Filling an array with a specific value
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 30);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));

        // Checking array equality using equals
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println("Arrays Equality: " + Arrays.equals(array1, array2));

        // Deep equality for multi-dimensional arrays
        int[][] deepArray1 = {{1, 2}, {3, 4}};
        int[][] deepArray2 = {{1, 2}, {3, 4}};
        System.out.println("Deep Arrays Equality: " + Arrays.deepEquals(deepArray1, deepArray2));
        
        //Parallel Operations
        intArray = new int[] {4,5,2,3,1,9};
        Arrays.parallelSort(intArray);
        System.out.println("Parallel Sorted Array: " + Arrays.toString(intArray));
        
		/*
		 * parallelPrefix performs a parallel prefix operation on array elements. o
		 * Each element in the result is the accumulated value of preceding elements.
		 */

        int[] values = {4, 2, 9, 1, 8};
        Arrays.parallelPrefix(values, (x, y) -> x + y);
        System.out.println("Parallel Prefix Result: " + Arrays.toString(values));
        
		/*
		 * parallelSetAll sets each element in the array to a computed value. o
		 * Accepts a lambda function or implementation of the UnaryOperator interface.
		 */
        values = new int[5];
        Arrays.parallelSetAll(values, (x) -> x *x);
        System.out.println("Parallel set All Result: " + Arrays.toString(values));
        
        //Manual implementation
        Arrays.parallelSetAll(values, index -> {
        	if (index == 0) return 1;
        	
        	return (index + 1) * (index + 1);
        	});

        System.out.println("Parallel set All Result: " + Arrays.toString(values));
        


    }


}
