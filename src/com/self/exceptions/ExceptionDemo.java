package com.self.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println("Within main.");
		callingException();
		
	}
	
	public static void callingException() {
		//If I am calling a method that throws exception, I MUST either use try/catch to handle ALL those exceptions or throw it from this method as well(unless its main method)
		
		//trial(6, "data to be sent");
		
		try {
			trial(6, "data to be sent");
		}
		// Order of exception declared matters
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: Connecting to a different server.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException.");
		}
		
		/*
		 * If an exception is thrown, the catch block can handle it, but there might be
		 * code that needs to run regardless of the outcome (like closing a file). If
		 * there’s a return statement or an uncaught exception in the try or catch
		 * block, the finally block will still execute before the method returns to its
		 * caller.
		 */
		finally {
			System.out.println("Finally");
		}

		System.out.println("Try did not stop this statement. If not handled, this would not be possible");
	}

	// If your method is throwing an checked exception, you must declare in throwing
	/*
	 * Checked exceptions are used to represent problems that can be recovered
	 * during the execution of a program. They usually occur due to external factors
	 * (e.g., file not readable, no network connection). These exceptions are not
	 * typically the programmer’s fault. Examples of checked exceptions include
	 * IOException, SQLException, and custom exceptions that extend Exception. When
	 * a method can throw a checked exception, it must either handle the exception
	 * using a try-catch block or declare it in its method signature using the
	 * throws keyword.
	 */
	public static void trial(int destination, String data) throws FileNotFoundException, IOException// ,
																									// ArrayIndexOutOfBoundsException

	{

		int[] a = new int[5];
		// This may throw an unchecked exception. No need to declare in throws, but can
		System.out.println(a[destination]);

		if (destination == 1) {
			throw new IOException("Connection failed.");
		} else {
			System.out.println("Data written successfully.");
		}
		
		
		//Try with resources
		//Resource clean up done automatically at the end of try.
		try (FileInputStream fis = new FileInputStream("trial.txt");
				//Can have multiple resources
			    FileOutputStream output = new FileOutputStream("output.txt")
				) {
		    // Code for reading from the file
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		    // Handle file not found exception
			
			//We can have suppressed exceptions when handling these resources. Can be shown as:
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed Exception: " + suppressed);
            }

			
		} // No need for explicit finally block

	}
}
