package com.self.functional_programming;
//Accessingenclosing variables

/*•	Local variables defined in the enclosing method.
•	Instance variables (if the Lambda is within an instance method).
•	Static variables (if the Lambda is within a static method).*/

public class LambdaVariableAccess {
    static int global =10; // Static variable
    private int globalInstance = 100; // Static variable
	public static void go() {
        int count = 0;
        // Compilation error if count is modified within the method
        // count++;

        // Using a Lambda expression to capture and access local variable 'count'
        FunctionalInterface fi = () -> System.out.println("Count: " + count);
        fi.go();
        
        FunctionalInterface fi2 = () -> System.out.println("Static variable Count: " + global);
        fi2.go();
        
       
    }
	
	public  void goInstance() {
        int count = 2;
        // Compilation error if count is modified within the method
        // count++;
        
        // Compilation error: count is already defined, cannot reuse same variable name.
        // Consumer<Integer> consumer = count -> System.out.println(count);

        
        // Using a Lambda expression to capture and access local variable 'count'
        FunctionalInterface fi = () -> System.out.println("InstanceCount: " + globalInstance);
        //Can also use this within lambda expressions
        fi = () -> System.out.println("InstanceCount: " + this.globalInstance);
        fi.go();
        
        FunctionalInterface fi2 = () -> System.out.println("Local Count: " + count);
        fi2.go();
        // ...rest of the code
    }
	
	public static void main(String[] args) {
		LambdaVariableAccess led =  new  LambdaVariableAccess();
		led.goInstance();
		LambdaVariableAccess.go();
	}


}
