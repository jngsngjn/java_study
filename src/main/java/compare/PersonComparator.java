package compare;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        // null 검사: null을 뒤로 정렬
        if (p1 == null && p2 == null) return 0;
        if (p1 == null) return 1;
        if (p2 == null) return -1;

        int compared = Integer.compare(p1.getAge(), p2.getAge());
        if (compared == 0) {
            // 나이가 같으면 이름으로 비교
            return p1.getName().compareTo(p2.getName());
        }
        return compared;
    }
}