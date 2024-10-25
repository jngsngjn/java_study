package dump;

import java.util.ArrayList;
import java.util.List;

public class OOMHeapDumpExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(new String("OOM TEST"));
        }
    }
}