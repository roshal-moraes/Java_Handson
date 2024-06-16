package com.self.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInputDemo {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
		    String userInput;

		    System.out.println("Enter 'start' to proceed:");
		    while (true) {
		        userInput = reader.readLine();
		        if ("start".equals(userInput)) {
		            break;
		        } else {
		            System.out.println("Invalid input. Please re-enter 'start'.");
		        }
		    }
		    System.out.println("You are in the next step!");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		try (Scanner scanner = new Scanner(System.in)) {
		    String userInput;

		    System.out.println("Enter 'start' to proceed:");
		    while (true) {
		        userInput = scanner.nextLine();
		        if ("start".equals(userInput)) {
		            break;
		        } else {
		            System.out.println("Invalid input. Please re-enter 'start'.");
		        }
		    }
		    System.out.println("You are in the next step!");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		try (Scanner scanner = new Scanner("Hello how are you")) {
		    while (scanner.hasNext()) {
		        System.out.println(scanner.next());
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}



	}

}
