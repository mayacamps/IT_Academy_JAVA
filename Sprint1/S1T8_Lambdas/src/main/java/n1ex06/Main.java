package n1ex06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = Arrays.asList("Sunflower", "Daisy", 2312, "Lilly", 98273, 12, "Rose", 9);

        list.stream()
                .sorted(Comparator.comparing(l -> l.toString().length()))
                .forEach(System.out::println);
    }
}
