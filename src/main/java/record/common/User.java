package record.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString(of = {"name", "age"})
@AllArgsConstructor
public class User {
	private final String name;
	private final int age;
}