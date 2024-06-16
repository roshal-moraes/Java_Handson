package main.com.self.inheritance;

public class UserTest {
	public void printUserType(User user) {
        user.printUserType();
        user.saveWebLink();
    }

    public static void main(String[] args) {
        User user = new User();
        User staff = new Staff();
        User editor = new Editor();

        UserTest tester = new UserTest();

        tester.printUserType(user);    // Output: User: saveWebLink\nUser: postAReview
        tester.printUserType(staff);   // Output: Staff: postAReview
        tester.printUserType(editor);  
       
        //Method invocation determined during compile time. Hence, if method with same name is not present in reference type of object, here User, it will give error.
        /*
         * Static methods cannot be overridden; they can only be hidden.
		The invocation of a static method is bound at compile time based on the reference type, not the object type.
		Early binding ensures that the static method of the reference type is invoked.

         * */
        
        //System.out.println(staff.printID());
       

    }


}
