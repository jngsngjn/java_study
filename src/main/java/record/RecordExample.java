package record;

public class RecordExample {
	public static void main(String[] args) {
		User kim = new User("kim", 20);
		User lee = new User("lee", 25);

		System.out.println("lee = " + lee); // lee = User[name=lee, age=25]
		System.out.println("lee.name() = " + lee.name()); // lee.name() = lee
		System.out.println("lee.age() = " + lee.age()); // lee.age() = 25

		System.out.println(kim.equals(new User("kim", 20))); // true
		System.out.println("kim.equals(lee) = " + kim.equals(lee)); // kim.equals(lee) = false
	}
}