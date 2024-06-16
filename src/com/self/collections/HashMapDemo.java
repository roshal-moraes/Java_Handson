package com.self.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//Avoid using mutable keys as it leads to issues
public class HashMapDemo {
	
	public static void main(String[] args) {
		//Order of entry not preserved
        Map<String, Integer> map1 = new HashMap<>();

        // Adding key-value pairs
        map1.put("John", 25);
        map1.put("Roger", 30);
        map1.put("Iron", 28);

        // Printing the HashMap
        System.out.println("Map 1: " + map1);

        // Modifying a value
        map1.put("John", 26);
        System.out.println("Map 1 after modification: " + map1);

        // Checking if a key exists
        System.out.println("Contains key 'John': " + map1.containsKey("John"));

        // Getting the value for a specific key
        System.out.println("Value for 'John': " + map1.get("John"));

        
        Set<String> keySet = map1.keySet();
        for (String name : keySet) {
            System.out.println("Name: " + name + ", Age: " + map1.get(name));
        }

        // Iterating using entrySet()
        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }

        Set<String> names = map1.keySet();
        names.remove("Iron");
        System.out.println("Map 1 after removal: " + map1);

	}

}
