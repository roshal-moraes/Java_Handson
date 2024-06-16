package main.com.self.inheritance;

public class Staff extends User{
	
	protected int ID = 100;
	
	public Staff() {
		System.out.println("Within Staff()");
	}
	public Staff(int StaffID, int UserID) {
		//Constructor call must be the first statement.
		super(UserID);
		System.out.println("Within Staff(int StaffID, int UserID)");
		
		ID = UserID;
		
		
	}
	//Overriding method can be less accessible but not more restrictive
	/*
	 * If the superclass method is declared as public, the overriding method in the subclass cannot be declared as protected or default (package-private) but not private.
	* If the superclass method is declared as protected, the overriding method in the subclass cannot be declared as default (package-private) and not private or public.
		If the superclass method is declared as package-private, the overriding method in the subclass must also be package-private.
		The visibility of the overriding method cannot be more restrictive than that of the overridden method.
		For example, if the superclass method is public, you cannot make the overriding method private in the subclass. This is because making it private would restrict its visibility to the subclass only, which violates the contract of the superclass method being accessible to all subclasses.

		Visibility can be increased, protected method can become public.
	 * */
    @Override
    public void postAReview() {
    	
    	super.postAReview(); 
    	//Note: Super cannot be invoked from static methods.
        System.out.println("Staff: postAReview");
    }

    public void printID() {
        System.out.println("Staff ID: " + ID);          // Accessing the ID in the same class
        System.out.println("User ID: " + super.ID);    // Accessing the hidden ID in the superclass using super keyword
    }


}
