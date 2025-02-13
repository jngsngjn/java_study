package record;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestMain {
	public static void main(String[] args) {
		User user = new User("Alice", 30);

		// 객체 직렬화 (파일에 저장)
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 객체 역직렬화 (파일에서 읽기)
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
			User deserializedUser = (User) ois.readObject();
			System.out.println(deserializedUser); // User[name=Alice, age=30]
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
