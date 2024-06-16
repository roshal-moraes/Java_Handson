package com.ing.nested_class;

/*The method getBookAsXml has parameters id, title, rating, fbLikes, and tweetCount.
Inside this method, there’s a local class named Book that also declares fields with the same names: id, title, rating, fbLikes, and tweetCount.
When the constructor of the Book class uses the keyword this, it refers to the instance fields of the Book class, not the parameters of the getBookAsXml method.
This means that the local variables (fields of Book) are shadowing the method parameters with the same names.

We change rating value to demonstrate this*/
public class ShadowingLocalVariablesDemo {
	// Static method with local variables shadowed in a local class
	public static String getBookAsXml(String id, String title, int rating, int fbLikes, int tweetCount) {
		System.out.println("Rating received before class:" + rating);
		// Local class shadowing method parameters
		class Book {
			String id;
			String title;
			int rating;
			int fbLikes;
			int tweetCount;

			// Constructor with shadowed parameters
			public Book(String id, String title, int rating, int fbLikes, int tweetCount) {
				this.id = id;
				this.title = title;
				this.rating = rating;
				this.fbLikes = fbLikes;
				this.tweetCount = tweetCount;
			}

			// XML conversion logic using shadowed variables
			public String toXml() {
				// Accessing shadowed variables within the local class
				return "<Book><Id>" + id + "</Id><Title>" + title + "</Title><Rating>" + rating + "</Rating></Book>";
			}
		}

		// Instantiating the local class with method parameters
		System.out.println("Rating received:" + rating);
		Book book = new Book(id, title, 10, fbLikes, tweetCount);
		System.out.println("Rating received on Book:" + book.rating);
		// XML conversion using the local class
		return book.toXml();
	}
	
	// Declaration of an anonymous class with a shadowed local variable
    private Runnable someOperation() {
        // Local variable 'count' shadowed in an anonymous class
        int count = 0;

        // Anonymous class with shadowed local variable 'count'
        return new Runnable() {
            @Override
            public void run() {
                // Attempt to shadow the local variable 'count' (legal)
                int count = 42; // Legal, as it is within the anonymous class
                System.out.println(count);
            }
            
        };
    }


	public static void main(String[] args) {
		// Example usage of ShadowingLocalVariablesDemo.getBookAsXml
		//Sending rating as 10
		String bookXml = ShadowingLocalVariablesDemo.getBookAsXml("B001", "The Art of Computer Programming", 5, 1200,
				300);
		System.out.println(bookXml);
		Runnable r = new ShadowingLocalVariablesDemo().someOperation();
		r.run();
	}
	
	

}
