package main.com.self.interfaces;

interface Shareable {
    public static final int value = 50;
    
    
    int v = 34;
    
	void getItemData();
    
    //methods can be either static or default
	//If subinterface or subclass also has method with same name, subinterface/subclass will get precedence
	//Default methods cannot be declared as final or synchronized.
	//Default methods mimic instance methods, will nto be called directly with interface name.
	//To call directly with interface name, use static method
    public default void concreteMethod() {
    	 System.out.println("Default Method Executed for Shareable"); 
    	 test();
    }
    
    //Interfaces can have a non default,non static private method

    private void test() {
    	System.out.println("Private Method Executed for Shareable");
    }
    
}
