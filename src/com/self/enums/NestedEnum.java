package com.self.enums;

public class NestedEnum {
	public enum BookGenre {
		BIOGRAPHY(12), HORROR(15);

		private final int minAgeToRead;

		private BookGenre(int minAgeToRead) {
			this.minAgeToRead = minAgeToRead;
		}

		public int getMinAgeToRead() {
			return minAgeToRead;
		}
	}

	// Main method
	public static void main(String[] args) {
		for (BookGenre genre : BookGenre.values()) {
			System.out.println("Name: " + genre);
			System.out.println("Min Age to Read: " + genre.getMinAgeToRead());
			System.out.println();
		}
	}

}
