package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareApp {
    public static void main(String[] args) {
        Person personA = new Person("A", 10);
        Person personB = new Person("B", 10);
        Person personC = new Person("C", 10);

        List<Person> list = new ArrayList<>();
        list.add(personA);
        list.add(personB);
        list.add(personC);

        Collections.sort(list);
    }
}