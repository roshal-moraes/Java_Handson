package com.self.enums;

public class EnumDemo {
	public static void main(String [] args) {
		SimpleEnum genre = SimpleEnum.HORROR; // Enum constant
		SimpleEnum[] genres = SimpleEnum.values(); // Array of enum constants
		SimpleEnum sciFi = SimpleEnum.valueOf("SCIENCE_FICTION"); // Get enum constant by name
		
		System.out.println("genre: " + genre);
		System.out.println("ordinal of genre: " + genre.ordinal());
		System.out.println("genre Class: " + genre.getDeclaringClass());
		System.out.println("genre Class: " + genre.toString());
		System.out.println("Equals with HORROR: " + genre.equals(SimpleEnum.HORROR));
        System.out.println("Compare to BIOGRAPHY: " + genre.compareTo(SimpleEnum.BIOGRAPHY));

		for(SimpleEnum genre1 : genres ) {
			System.out.println("genres: " + genre1);
		}
		
		System.out.println("SimpleEnum.valueOf(\"SCIENCE_FICTION\"): " + SimpleEnum.valueOf("SCIENCE_FICTION"));
		

	}

}
