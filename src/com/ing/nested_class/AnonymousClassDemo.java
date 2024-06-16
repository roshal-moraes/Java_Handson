package com.ing.nested_class;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//Anonymous = nameless. cannot have multiple inheritance(using interface, etc)
public class AnonymousClassDemo {
	int count2 = 0;
    public void processItems() {
        // Local variable count must be effectively final
         final int count = 0;

        // Using an anonymous class with a local variable. Local variable must be final to be accessed within anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Uncommenting the line below would result in a compilation error
                //count++;
                System.out.println("Count: " + count);
                System.out.println("Count class: " + count2);
                //Class variables can be accessed and modified, no final needed
                count2++;
            }
        }).start();
    }

	
	public static void main(String[] args) {

		Set<String> stringSet = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		String[] arr = new String[5];
		arr[0] = "This";
		arr[1] = "Is";
		arr[2] = "Not";
		arr[3] = "Done";
		arr[4] = "Sally";
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return Integer.compare(arg1.length(), arg0.length());
			}
			
		});
		
		System.out.println(Arrays.toString(arr));
		
		
		new FooBar(05) {{
			go();
		}};
		
		AnonymousClassDemo acd = new AnonymousClassDemo();
		acd.processItems();
	}
	
	
}
