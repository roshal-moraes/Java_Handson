package main.com.self.inheritance;

public class TypeSafety {
	public static void main(String[] args) {
		// Static type checking prevents assigning a larger type to a smaller type
		//int smallerType = 3.14; // Compiler error: Cannot assign double to int without cast
		int smallerType = (int)3.14; 
		
		 //Type Casting
	    Editor editorTest = new Editor();
	    Staff s = editorTest; // Implicit cast
	    // Compiler error as Staff doesn't have the method 'approveReview'
	    // Need explicit cast: 
	    //(Editor)s.approveReview();
	    
	    
	    //Check before casting.
	    //instanceOf checks on object type not reference type.
	    if (s instanceof Editor) {
	        // Apply cast only if the test succeeds
	        ((Editor) s).approveReview();
	    } else {
	        System.out.println("Invalid object passed");
	    }
	    User staff = new Staff();
	    //Object will be instance of all parents as well, but not child
	    System.out.println("staff instanceof User: " + (staff instanceof User));
	    System.out.println("staff instanceof Editor: " + (staff instanceof Editor));

	}

}
