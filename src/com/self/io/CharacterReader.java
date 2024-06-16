package com.self.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CharacterReader {
	/*
	 * //Reader and Writer class for character oriented streams. FileReader
	 * fileReader = new FileReader("example.txt"); FileWriter fileWriter = new
	 * FileWriter("output.txt"); For more control over character encoding, we turn
	 * to InputStreamReader and OutputStreamWriter. These classes act as bridges,
	 * translating between byte streams and character streams. The flexibility lies
	 * in the ability to set a specific character encoding of your choice. Here,
	 * BufferedReader is introduced to add buffering capabilities, enhancing
	 * performance.
	 */

	public static void main(String[] args) {
		// InputStream and OutputStream base classes for byte oriented operations
		// inputstream file must be present, outputstream will create file automatically
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\input.txt"), StandardCharsets.UTF_8));
				// true indicates append
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("C:\\Users\\Roshal\\Desktop\\Java Training\\Java in Depth\\Excercise_Eclipse\\Java_Tutorial\\resources\\output.txt", true), StandardCharsets.UTF_8));) {
			StringBuilder stringBuilder = new StringBuilder();

			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				stringBuilder.append(line).append(System.lineSeparator());
			}

			String fileContent = stringBuilder.toString();
			writer.write(fileContent);

			System.out.println("File copied successfully!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

			// Handle file not found exception
		} catch (IOException e) {
			// Handle other IOExceptions
		}

	}

}
