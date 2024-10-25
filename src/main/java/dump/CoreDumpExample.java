package dump;

import java.util.ArrayList;
import java.util.List;

public class CoreDumpExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(new String("Core Dump Test"));
        }
    }
}