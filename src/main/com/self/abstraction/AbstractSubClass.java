package main.com.self.abstraction;

public abstract class AbstractSubClass extends AbstractSuperClass {
	// Parameterized constructor
    protected AbstractSubClass(int increment1, int increment2) {
        super(increment1, increment2);
    }

	
	@Override
    public int foo() {
        System.out.println("foo");
        return 10;
    }


}
