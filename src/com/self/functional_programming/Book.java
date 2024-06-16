package com.self.functional_programming;

class Book implements Comparable{
    private String title;
    private String author;
    private int year;
    private int rating;

    
    public Book() {}
    
    public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}
    
    public Book(String author, int year, int rating) {
		super();
		this.author = author;
		this.year = year;
		this.rating = rating;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
    
	public void fiDemo(FunctionalInterface fi, FunctionalInterfaceWithParameters fi2) {
		fi.go();
		System.out.println(fi2.funnyAdd(3, 4));
	}

}
