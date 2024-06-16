package main.com.self.inheritance;

public class SuperTest {
	
	public static void main(String[] args) {
		System.out.println("Creating User");
        User user = new User();
        System.out.println("Creating Staff()");
        Staff staff = new Staff();
        System.out.println("Creating Staff(500,4500)");
        Staff staff2 = new Staff(500,4500);
        System.out.println("Creating Editor()");
        User editor = new Editor();

        System.out.println(user.ID);
      
        staff.printID();
        
        
       

    }

}
