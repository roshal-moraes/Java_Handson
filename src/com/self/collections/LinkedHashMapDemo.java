
package com.self.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		/*LinkedHashmap used to preserve order of insertion
		 * LinkedHashMap can be used as an LRU Cache.
		LRU Caching is a strategy where the least recently used items are discarded to make room for new ones.
		*/
		Map<String, Integer> regularMap = new LinkedHashMap<>(16, 0.75f, false);
		
		/*
		 * 16: This is the initial capacity of the LinkedHashMap. It’s the number of
		 * buckets in the hash table, which is the underlying data structure of the
		 * LinkedHashMap. An initial capacity of 16 means the hash table starts with 16
		 * buckets. 0.75f: This is the load factor of the LinkedHashMap. The load factor
		 * is a measure that, when exceeded, causes the hash table to be resized (i.e.,
		 * the number of buckets is increased). A load factor of 0.75f means the
		 * resizing will happen once the map is 75% full. This is a balance between time
		 * and space cost. false: This parameter specifies the ordering mode. If false,
		 * the LinkedHashMap will be in insertion-order, which means the elements will
		 * be iterated in the order they were inserted. If it were true, it would be in
		 * access-order, meaning the elements would be iterated in the order they were
		 * last accessed (read or write).
		 */
        regularMap.put("A", 1);
        regularMap.put("B", 2);
        regularMap.put("C", 3);

        System.out.println("Regular Map: " + regularMap);

        // LinkedHashMap with LRU Cache
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);

        System.out.println("LRU Cache: " + lruCache);

        lruCache.get("A");
        System.out.println("After Accessing A: " + lruCache);

        lruCache.put("D", 4);
        System.out.println("After Adding D: " + lruCache);

		
	}
	
	


}
