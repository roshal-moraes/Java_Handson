package main.com.self.abstraction;

//A non abstract class extending an abstract class must implement all non implemented abstract methods.
public class ConcreteSubClass extends AbstractSubClass{

    public ConcreteSubClass(int increment1, int increment2) {
        super(increment1, increment2);
    }

	@Override
    public void bar() {
System.out.println("bar");
}

public static void main(String[] args) {
    ConcreteSubClass concreteObject = new ConcreteSubClass(200, 400);
    //Cannot instantiate Abstract class
    //AbstractSubClass asb = new AbstractSubClass();
    //ReferenceTyping is allowed
    AbstractSubClass asb = new ConcreteSubClass(300, 500);
    
    //Can directly call Static methods also
    AbstractSuperClass.staticMethod();
    
    
    concreteObject.foo();
    concreteObject.bar();
}

}
