package com.self.collections;

class Book implements Comparable{
    private String title;
    private String author;
    private int year;

    
    public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	// Constructor and getters/setters omitted for brevity

    @Override
    public int hashCode() {
        return title.hashCode(); // Using title for simplicity, can customize based on requirements
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author) && year == book.year;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", year=" + year +
               '}';
    }
    

	@Override
	public int compareTo(Object arg0) {
		return this.title.compareTo(((Book)arg0).title);
	}
    


}
