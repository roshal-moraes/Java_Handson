package main.com.self.classlifetime;

class Subclass extends Superclass implements SuperInterface {
    static final int STATIC_FINAL_TWO = 22;

    static {
        System.out.println("Subclass static initializer block");
    }

    {
        System.out.println("Subclass instance initializer block");
    }

    Subclass() {
        System.out.println("Subclass constructor");
    }
}
