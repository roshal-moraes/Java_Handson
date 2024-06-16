package main.com.self.interfaces;

public interface ComparableItem {
	int compareTo(Object obj);
	int v = 45;
	
	 public default void concreteMethod() {
    	 System.out.println("Default Method Executed for ComparableItem"); 
    }
	
	 public static void staticMethod() {
    	 System.out.println("Static Method Executed for ComparableItem"); 
    }
	
}
