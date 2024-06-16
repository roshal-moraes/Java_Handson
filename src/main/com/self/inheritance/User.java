package main.com.self.inheritance;

public class User {
	protected int ID = 1;
	
	//If your children have constructors, you must madatorily have an empty constructor defined.
	//making this method a private constructor when dealing with utility classes consisting solely of static methods and preventing instantiation is crucial.
	User(){
		System.out.println("Within User()");
	}
	User(int userID){
		System.out.println("Within User(int userID)");
	}
    public void printUserType() {
        System.out.println("User");
    }

    public void saveWebLink() {
        System.out.println("User: saveWebLink");
        postAReview();
    }

    protected void postAReview() {
        System.out.println("User: postAReview");
    }
}
