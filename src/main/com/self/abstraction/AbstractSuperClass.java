package main.com.self.abstraction;

public abstract class AbstractSuperClass {
    
	protected int increment1;
    protected int increment2;

    // Parameterized constructor
    protected AbstractSuperClass(int increment1, int increment2) {
        this.increment1 = increment1;
        this.increment2 = increment2;
    }

    // No-argument constructor (added to support compiler-generated default constructor)
    protected AbstractSuperClass() {
    }

	
	public abstract int foo();
    public abstract void bar();
    
    public void instanceMethod(){
    	System.out.println("Abstract classes can have instance methods. Can be called from their child class too");
    }
    
    public static void staticMethod(){
    	System.out.println("Abstract classes can have static methods.");
    }
}
