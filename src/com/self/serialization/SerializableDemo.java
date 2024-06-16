package com.self.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*Serialization is essential when there's a need to save Java objects to disk, allowing their state to be preserved
*/public class SerializableDemo {
	/*
	 * Java allows a class to be defined within another class. These are called
	 * Nested Classes. Classes can be static which most developers are aware of,
	 * henceforth some classes can be made static in Java. Java supports Static
	 * Instance Variables, Static Methods, Static Block, and Static Classes
	 */
    static class DemoObject implements Serializable {
        private String name;
        private transient int id; // transient variable not serializedDuring deserialization, transient variables receive default values based on their types.
        

        //Any objects referenced by Serializable class and referencing serializable class, must be serializable, else error is thrown
        public void setState(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) {


        
            serializationDemo();
       
            deserializationDemo();
        
    }

    private static void serializationDemo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\serialized_object.ser"))) {
            DemoObject demoObject = new DemoObject();
            demoObject.setState("Java", 42);

            System.out.println("Before Serialization - Name: " + demoObject.getName() + ", ID: " + demoObject.getId());

            oos.writeObject(demoObject);
            System.out.println("Serialization completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void deserializationDemo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\serialized_object.ser"))) {
            DemoObject demoObject = (DemoObject) ois.readObject();

            // Since 'id' is a transient field, it will not be deserialized and will have the default value.
            System.out.println("After Deserialization - Name: " + demoObject.getName() + ", ID: " + demoObject.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}