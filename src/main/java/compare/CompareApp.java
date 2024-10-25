package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareApp {
    public static void main(String[] args) {
        Person personC = new Person("C", 10);
        Person personA = new Person("A", 10);
        Person personB = new Person("B", 20);

        List<Person> list = new ArrayList<>();
        list.add(personA);
        list.add(personB);
        list.add(personC);

        list.sort(new PersonComparator());
        System.out.println("list = " + list);
    }
}