package main.com.self.classlifetime;

public class ClassInitializationDemo {
    static final int STATIC_FINAL_ONE = 11;

    static {
        System.out.println("ClassInitializationDemo static initializer block");
    }

    {
        System.out.println("ClassInitializationDemo instance initializer block");
    }

    ClassInitializationDemo() {
        System.out.println("ClassInitializationDemo constructor");
    }

    static int getIn() {
        System.out.println("getIn() method called");
        return 47;
    }

    static int getInFine() {
        System.out.println("getInFine() method called");
        return 99;
    }

    public static void main(String[] args) {
        System.out.println("Main method started");

        // Accessing compile-time constant
        System.out.println("Accessing static final one: " + STATIC_FINAL_ONE);

        // Lazy loading - Accessing non-compile-time constant
        System.out.println("Accessing static final two: " + Subclass.STATIC_FINAL_TWO);

        // Instantiating Subclass
        Subclass subclassInstance = new Subclass();

        // Uncomment the line below to observe the effect
        System.out.println("Accessing static final two again: " + Subclass.STATIC_FINAL_TWO);

        // Invoke static method on SuperInterface
        SuperInterface.staticMethod();

        // Uncomment the line below to observe the effect
         System.out.println("Accessing static final three: " + SuperInterface.STATIC_FINAL_THREE);

        System.out.println("Main method ended");
    }
}
