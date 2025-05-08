import java.util.HashMap;
import java.util.Map;

public class AppMain {
	public static Map<String, Object> map = new HashMap<>();

	public static void main(String[] args) {
		Object value = map.get("key");
		System.out.println("value = " + value);

		Integer integerValue = (Integer) value;
		System.out.println("integerValue = " + integerValue);

		int intValue = (int) value; // throw NPE
		System.out.println("intValue = " + intValue);
	}
}