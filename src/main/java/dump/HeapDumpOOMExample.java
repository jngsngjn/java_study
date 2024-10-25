package dump;

import java.util.ArrayList;
import java.util.List;

public class HeapDumpOOMExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            try {
                list.add(new String("OOM Test"));
            } catch (OutOfMemoryError error) {
                System.out.println("catch");
                return;
            }
        }
    }
}