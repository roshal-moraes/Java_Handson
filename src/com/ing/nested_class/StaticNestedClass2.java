package com.ing.nested_class;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticNestedClass2 {

	private static final Comparator ageComparator = new AgeComparator();
	private String name;
	private int age;

	public StaticNestedClass2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters for name and age
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	

	// Static member class that serves as a custom comparator
	public static class AgeComparator implements Comparator<StaticNestedClass2> {
		@Override
		public int compare(StaticNestedClass2 p1, StaticNestedClass2 p2) {
			return Integer.compare(p1.getAge(), p2.getAge());
		}
	}

	// Main method to demonstrate the usage of AgeComparator
	public static void main(String[] args) {

		List<StaticNestedClass2> list = new ArrayList<>();

		StaticNestedClass2 person1 = new StaticNestedClass2("Alice", 30);
		StaticNestedClass2 person2 = new StaticNestedClass2("Bob", 25);
		StaticNestedClass2 person3 = new StaticNestedClass2("Tom", 15);
		list.add(person1);
		list.add(person2);
		list.add(person3);
		
		Collections.sort(list, StaticNestedClass2.ageComparator);
		System.out.println(list);
	}

	@Override
	public String toString() {
		return "StaticNestedClass2 [name=" + name + ", age=" + age + "]";
	}
}
