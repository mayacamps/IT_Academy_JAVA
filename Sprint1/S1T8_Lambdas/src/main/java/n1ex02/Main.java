package n1ex02;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("skateboard", "long", "bicycle", "scooter", "rollerblade", "electric bike");
        list.stream()
                .filter(l -> l.contains("o"))
                .forEach(l -> System.out.println(l));
    }
}
