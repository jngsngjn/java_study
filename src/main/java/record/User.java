package record;

import java.io.Serializable;

public record User(String name, int age) implements Serializable {
	public String greeting() {
		return "Hello, my name is " + name + " and I am " + age + " years old.";
	}

	// compact constructor
	public User {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative!");
		}
	}
}