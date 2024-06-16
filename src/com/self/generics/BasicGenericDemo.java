package com.self.generics;

//Note Generic class can never extend exception and act like an exception
class BasicGenericDemo<T> {
    private T item;
    
    //static fields cant use this generics
    //private static T item2;
    
    BasicGenericDemo(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
    
    public static void main(String []args) {
    	//parameterized demo
    	BasicGenericDemo<String> stringStore = new BasicGenericDemo<>("Hello");
    	//Primitives not allowed
    	BasicGenericDemo<Integer> intStore = new BasicGenericDemo<>(345);
    	
    }
}
