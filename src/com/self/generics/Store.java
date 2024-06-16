package com.self.generics;

import java.util.Arrays;
import java.util.List;

/*
 * Java generics use type erasure at runtime, meaning the type information is removed. 
 * This is a compile-time concept, and the actual types are replaced with Object during runtime.
 * */
//Here you can also directly provide type to interface
//class Store implements Container<String>, must implement all methods of interface
class Store<B> implements Container<B> {
	private B item;

	Store(B item) {
		this.item = item;
	}

	public B get() {
		return item;
	}

	public void set(B value) {
		item = value;
	}
	


	public static void main(String[] args) {
		Store<String> stringStore = new Store<>("Hello");
		System.out.println(stringStore.get());

		Store<Integer> integerStore = new Store<>(42);
		System.out.println(integerStore.get());

		Store<List<Integer>> listStore = new Store<>(Arrays.asList(1, 2, 3));
		System.out.println(listStore.get());
	}

}
