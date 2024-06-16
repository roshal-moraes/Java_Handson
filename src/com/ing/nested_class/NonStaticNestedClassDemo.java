package com.ing.nested_class;

public class NonStaticNestedClassDemo {
	private int outerField;
	private static int staticOuterField;

	static {
		staticOuterField = 100;
	}

	// Constructor for the Outer class
	public NonStaticNestedClassDemo(int outerField) {
		this.outerField = outerField;
	}

	// Getter method for outerField
	public int getOuterField() {
		return outerField;
	}

	// Non-static nested class (Inner class)
	// Cannot have static items. This is true only till Java 15. From Java 16
	// onwards, they allowed nonstatic member classes to have static members. They
	// allowed this change so that a nonstatic member class can have a Record class.
	// A record class is a new feature in Java 16, which behind the scenes is simply
	// an immutable class. A record class if nested within another class, then it
	// will implicitly be a static member class.
	public class Inner {
		private int innerField;

		// Not allowed
		// private static int staticInnerField = 10;
		// Constructor for the Inner class
		public Inner(int innerField) {
			this.innerField = innerField;
		}

		// Getter method for innerField
		public int getInnerField() {
			return innerField;
		}

		// Method accessing outerField from the Outer class
		public void accessOuterField() {
			System.out.println("Accessing outerField from Inner class: " + outerField);
			System.out.println("Accessing static outerField from Inner class: " + staticOuterField);

		}
	}

	// Main method for testing the classes
	public static void main(String[] args) {
		// Creating an instance of the Outer class
		NonStaticNestedClassDemo outerInstance = new NonStaticNestedClassDemo(42);

		// Creating an instance of the Inner class using the outerInstance
		NonStaticNestedClassDemo.Inner innerInstance = outerInstance.new Inner(24);

		// Accessing fields and methods of both Outer and Inner classes
		System.out.println("Outer Field: " + outerInstance.getOuterField());
		System.out.println("Inner Field: " + innerInstance.getInnerField());
		innerInstance.accessOuterField();
	}

}
