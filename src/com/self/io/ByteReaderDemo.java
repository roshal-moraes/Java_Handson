package com.self.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//input file: /Java_Tutorial/resources/input.txt
public class ByteReaderDemo {

	public static void main(String[] args) {
		// InputStream and OutputStream base classes for byte oriented operations
		//inputstream file must be present, outputstream will create file automatically
		try (InputStream in = new FileInputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\input.txt");
				//true indicates append
				OutputStream out = new FileOutputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\output2.txt", true)) {
			// Reading and Writing one byte at a time
			int byteRead;
			while ((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}

			System.out.println("File copied successfully!");
		}  catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
			// Handle file not found exception
		} catch (IOException e) {
			// Handle other IOExceptions
		}
		
		/*
		 * Buffered streams (BufferedInputStream and BufferedOutputStream) are
		 * introduced to enhance file processing efficiency by using memory buffers.
		 */
		
		try (BufferedInputStream  in = new BufferedInputStream (new FileInputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\input.txt"));
				BufferedOutputStream  out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\output3.txt"))) {
			// Reading and Writing one byte at a time
			int byteRead;
			
			// Buffer to hold data during read and write operations
            byte[] buffer = new byte[8192]; // 8 KB buffer size


			while ((byteRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteRead);
			}

			System.out.println("File copied successfully!");
		}  catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
			// Handle file not found exception
		} catch (IOException e) {
			// Handle other IOExceptions
		}
	}

}
