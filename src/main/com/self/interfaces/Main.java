package main.com.self.interfaces;

public class Main {
	public static void main(String[] args) {
		//Representative Interface: Gives core functionality of its subclass. Ex: List
		//Mixin Interface: Gives additional capabiliy: Ex: Shareable, etc
		//Marker interfaces are unique as they don't contain any methods; they consist of an empty body. Despite their lack of methods, they hold value. These interfaces are primarily used to "mark" a class, indicating that it possesses a specific property. 
        
		
		// Creating an object of Book class
        Book myBook = new Book();

        // Accessing methods and variables
        myBook.getItemData();          // From Shareable
        myBook.compareTo(null);        // From ComparableItem
        myBook.processItem();          // From Item
        myBook.additionalFeature();    // From AdvancedShareable
        myBook.concreteMethod();
        
        
        // Accessing constant variable from interface
        System.out.println("Max limit: " + Item.MAX_LIMIT);
        System.out.println("Shareable value: " + Item.value);
        //Non static non final variables allowed but it may cause diamond problem. Below statement, hence, causes an error.
        //System.out.println("myBook v: " + myBook.v);
        
        //Interfaces can also be used as type. Same rules as class apply
        Shareable item = new Book();
        
        item.getItemData();          // From Shareable
        //item.compareTo(null);        // From ComparableItem, not allowed due to compile time binding
        
    }


}
