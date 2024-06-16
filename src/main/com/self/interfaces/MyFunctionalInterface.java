package main.com.self.interfaces;

@FunctionalInterface
interface MyFunctionalInterface {
    void test();

    // Default method added later
    //It still is a functional interface
    default void anotherMethod() {
        // Implementation
    }
}

