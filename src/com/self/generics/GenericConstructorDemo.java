package com.self.generics;

public class GenericConstructorDemo<T> {
    private T content;

    // Generic constructor
    public GenericConstructorDemo(T content) {
        this.content = content;
    }

    // Getter method
    public T getContent() {
        return content;
    }

    public static void main(String[] args) {
        // Creating a Box of Integer
    	GenericConstructorDemo<Integer> intBox = new GenericConstructorDemo<>(42);
        System.out.println("Box content: " + intBox.getContent());

        // Creating a Box of String
        GenericConstructorDemo<String> strBox = new GenericConstructorDemo<>("Hello, Generics!");
        System.out.println("Box content: " + strBox.getContent());
    }
}
