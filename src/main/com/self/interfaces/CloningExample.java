package main.com.self.interfaces;

public class CloningExample {
    public static void main(String[] args) {
        try {
            // Creating an original person
            Person originalPerson = new Person("John", 25, new String[]{"Reading", "Gardening"});

            // Creating a clone
            Person clonedPerson = (Person) originalPerson.clone();

            // Modifying the cloned person's hobbies
            clonedPerson.getHobbies()[0] = "Traveling";

            // Printing original and cloned persons
            System.out.println("Original Person: " + originalPerson);
            System.out.println("Cloned Person: " + clonedPerson);

        }
        //CloneNotSupportedException is thrown in Java when the clone() method of an object is called, but the object’s class does not implement the Cloneable interface
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
