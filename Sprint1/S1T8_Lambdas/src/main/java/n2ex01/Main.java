package n2ex01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Amber", "George", "Ash", "Lucas", "Ali");

        list.stream().filter(s -> s.toUpperCase().startsWith("A") && s.length() == 3).forEach(System.out::println);
    }
}
