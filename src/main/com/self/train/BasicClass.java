package main.com.self.train;

import java.util.Arrays;

public class BasicClass {
	static int staticVariable;
	int instanceVariable;
	
	//Static block: Executed once per class
	static {
		System.out.println("Within static block");
		staticVariable = 10;
	}
	
	//Instance block: executed once per object(on creation)
		
	{
		
		instanceVariable = staticVariable + 1;
		System.out.println("Within instance block");
	}
	
	public static void staticMethodDemo(int value){
		staticVariable = value;
		System.out.println("BasicClass.staticVariable: " + staticVariable);		
		
		//Cannot refer to instance variables or methods in static methods. Only static ones can be accessed
		//instanceVariable = value + 1;
		//instanceMethodDemo(value+1);
	}
	
	public void instanceMethodDemo(int value){
		//Can refer to static variables and instance variables in instance methods.
		staticVariable = value;
		//can also use this.instanceVariable
		instanceVariable = value + 1;
		System.out.println("BasicClass.staticVariable: " + staticVariable);	
		System.out.println("BasicClass.instanceVariable: " + instanceVariable);	
		//Can also call static methods
		staticMethodDemo(value + 1);
		
	}
	
	public void passByLogic(int value, BasicClass basicClass, int[] values, String... varargs) {
		System.out.println("Within passByLogic: " );
		//pass by value
		value = value + 1;
		System.out.println("Value: " + value);
		
		values[0] = value;
		System.out.println("values: " + Arrays.toString(values));
		
		//Static variable allocation
		//Allowed, not recommended
		basicClass.staticVariable = value;
		System.out.println("basicClass.staticVariable: " + basicClass.staticVariable);
		
		//Right way
		//BasicClass.staticVariable = value + 1;
		System.out.println("BasicClass.staticVariable: " + BasicClass.staticVariable);		
				
		//Pass by reference
		basicClass.instanceVariable = 10000;
		System.out.println("basicClass.instanceVariable: " + basicClass.instanceVariable);
		
		//Variable arguments
		for(String i:varargs) {
			System.out.println("Vararg: " +i);
		}
		
	}
	
	public static void main(String[] args) {
		BasicClass basicClassMain = new BasicClass();
		
		BasicClass basicClassMain2 = new BasicClass();
		System.out.println("call to instanceMethodDemo: " );
		basicClassMain2.instanceMethodDemo(10);
		System.out.println("call to staticMethodDemo: " );
		//Allowed not recommended
		basicClassMain2.staticMethodDemo(100);
		int valueMain = 10;
		int[] values = {3,4,5,2};
		String a,b,c;
		a = b =c = "5 vararg";
		
		System.out.println("Before call to passByLogic: " );
		
		System.out.println("Value: " + valueMain);

		System.out.println("values: " + Arrays.toString(values));

		System.out.println("basicClass.staticVariable: " + basicClassMain.staticVariable);
		System.out.println("BasicClass.staticVariable: " + BasicClass.staticVariable);	
		
		System.out.println("basicClass.instanceVariable: " + basicClassMain.instanceVariable);
		
		//cannot call this method without instance in main method.
		basicClassMain2.passByLogic(valueMain, basicClassMain, values, a,b,c);
		
		System.out.println("After call to passByLogic: " );
		
		System.out.println("Value: " + valueMain);

		System.out.println("values: " + Arrays.toString(values));

		System.out.println("basicClass.staticVariable: " + basicClassMain.staticVariable);
		System.out.println("BasicClass.staticVariable: " + BasicClass.staticVariable);	
		
		System.out.println("basicClass.instanceVariable: " + basicClassMain.instanceVariable);
		
		
		
		
	}

}
