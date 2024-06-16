package main.com.self.train;

public class FinalKeywordDemo {
	//Final Variables: A final variable can only be initialized once, either via an initializer or an assignment statement. It cannot be reassigned once set.
	
	final int MAX_HEIGHT = 200;
	// MAX_HEIGHT = 300; // This would cause a compile-time error
	
	/*Remember, when a reference variable is declared final, 
	 * it means that the variable cannot be reassigned to point to a different object, 
	 * but the object itself can still be modified if it is mutable.
	 */
	
	/*Final Methods: A final method cannot be overridden by subclasses, 
	which means you can ensure that the behavior defined in the method cannot be changed.
	If Class itself is final, A final class cannot be subclassed.*/
	
    public final void show() {
        System.out.println("This is a final method.");
    }
}

//This class cannot have child classes
final class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class ChildOfFinalKeywordDemo extends FinalKeywordDemo{
	//Cannot override show() method
	/*
	 * public void show() { System.out.println("This is a final method."); }
	 */
	
}