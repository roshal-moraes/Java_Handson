package main.com.self.classlifetime;

class Superclass {
    static {
        System.out.println("Superclass static initializer block");
    }

    Superclass() {
        System.out.println("Superclass constructor");
    }
}
