package main.com.self.train;

import java.util.Scanner;

public class SwitchTypes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Month number: ");
		int month = sc.nextInt();
		
		String season = switch(month) {
		case 11,12,1 -> "Winter";
		case 2,3,4 -> "Spring";
		
		//To add more statements and also return a value, we use yield. It must be the last statement. 
		//yield can also be used to return value in traditional : syntax instead of -> syntax
		
		case 5,6,7-> {
			System.out.println("Is also monsoon in someplaces");
			yield "Summer";
		}
		case 8,9,10 -> "Autumn";
		default -> "Invalid input";
		};
		
		System.out.println("Season is: " + season);
		
		//Using null in switch statement
		String value = null;
		//Switch expression can be null
		String trial = switch(value) {
		case "SomeValue" -> "Winter";
		//Switch label cannot be null
		//case null -> "This is valid";
		default -> "Invalid input";
		};
		
		System.out.println("Null demo: " + value);
		
	}

}
