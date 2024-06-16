package main.com.self.interfaces;

class Person implements Cloneable {
    private String name;
    private int age;
    private String[] hobbies;

    // Constructor and getters/setters

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Shallow copy
        Person clone = (Person) super.clone();
        // Deep copy for mutable object 'hobbies'
        clone.hobbies = this.hobbies.clone();
        return clone;
    }
    
    

	public Person(String name, int age, String[] hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String[] getHobbies() {
		return hobbies;
	}


	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
}
