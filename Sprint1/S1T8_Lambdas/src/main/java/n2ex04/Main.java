package n2ex04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> testList = Arrays.asList(3, "323", "Lucia", 43, "Ester", "Emma", 154);
        orderAlphabetically(testList);
    }
    public static void orderAlphabetically(List<Object> list){
        System.out.println("List ordered alphabetically: ");
        list.stream()
                .sorted(Comparator.comparing(l -> l.toString().charAt(0)))
                .forEach(System.out::println);
    }

    public static void orderFirstStartsWithE(List<Object> list){
        System.out.println("List ordered showing first Strings starting with e");
        list.stream()
                .sorted(Comparator.comparing(l -> l.toString().charAt(0) == 'e'));
    }
}
