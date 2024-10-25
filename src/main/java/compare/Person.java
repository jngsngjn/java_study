package compare;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person person) {
        if (person == null) {
            throw new NullPointerException("Compared person is null");
        }
        return Integer.compare(this.age, person.age);
    }
}