package reflection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.SQLException;

//@AllArgsConstructor
//@EqualsAndHashCode(of = {"name", "score"})
//public class Student {
//
//    private String name;
//    private int score;
//}

@AllArgsConstructor
public class Student {
    private final String name;
    private final int score;

    private String getDetails() {
        return "Name: " + name + ", Score: " + score;
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("This is a test exception");
    }
}