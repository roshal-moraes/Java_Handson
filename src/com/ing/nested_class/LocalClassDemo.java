package com.ing.nested_class;

import java.io.StringWriter;



//Class within method
//Can have multiple constructors and inherit from multiple types.
//Similar to anonymous classes, local variables accessed from the enclosing method 
//should be final or effectively final.
public class LocalClassDemo {
	
    public static void main(String[] args) {
        // Sample data for a book
        int bookId = 101;
        String title = "Java Fundamentals";
        int rating = 4;
        int fbLikesCount = 1200;
        int tweetCount = 500;

        // Invoking the method to translate a Java object into XML
        String xmlData = getBookAsXML(bookId, title, rating, fbLikesCount, tweetCount);

        // Printing the translated XML data
        System.out.println("Translated XML:\n" + xmlData);
    }

    // Method to translate a Java object into XML
    private static String getBookAsXML(int bookId, String title, int rating, int fbLikesCount, int tweetCount) {
        // Local class representing a book for XML translation
        class Book {
            private int id;
            private String bookTitle;
            private int bookRating;
            private int likesCount;
            private int tweetCount;

            // Constructor
            public Book(int id, String bookTitle, int bookRating, int likesCount, int tweetCount) {
                this.id = id;
                this.bookTitle = bookTitle;
                this.bookRating = bookRating;
                this.likesCount = likesCount;
                this.tweetCount = tweetCount;
            }

			@Override
			public String toString() {
				return "Book [id=" + id + ", bookTitle=" + bookTitle + ", bookRating=" + bookRating + ", likesCount="
						+ likesCount + ", tweetCount=" + tweetCount + "]";
			}
        }

        // Instantiating the local class and converting the book object to XML
        Book book = new Book(bookId, title, rating, fbLikesCount, tweetCount);
        return convertToXML(book);
    }

    // Method to convert a Java object to XML using XStream
    private static String convertToXML(Object object) {
    	return object.toString();
    }


}
