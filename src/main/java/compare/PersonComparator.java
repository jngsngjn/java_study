package compare;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        if (p1 == null && p2 == null) return 0;
        if (p1 == null) return 1;
        if (p2 == null) return -1;

        int compared = Integer.compare(p1.getAge(), p2.getAge());
        if (compared == 0) {
            return p1.getName().compareTo(p2.getName());
        }
        return compared;
    }
}