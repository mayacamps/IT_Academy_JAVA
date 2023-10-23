package n2ex04;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> testList = Arrays.asList(3, "323", "Lucia", 43, "Ester", "Emma", 154, "Alicia");
        orderAlphabetically(testList);
        orderFirstStartsWithE(testList);
        changeAWith4(testList);
        showNumerics(testList);
    }
    public static void orderAlphabetically(List<Object> list){
        System.out.println("Original list ordered alphabetically: ");
        list.stream()
                .sorted(Comparator.comparing(l -> l.toString().charAt(0)))
                .forEach(System.out::println);
    }

    public static void orderFirstStartsWithE(List<Object> list){
        System.out.println("Original list ordered showing first Strings starting with e: ");
        list.stream()
                .filter(l -> l.toString().toLowerCase().startsWith("e"))
                .forEach(System.out::println);
        list.stream()
                .filter(l -> !l.toString().toLowerCase().startsWith("e"))
                .forEach(System.out::println);
    }

    public static void changeAWith4(List<Object> list){
        System.out.println("Original list with modified elements (change 'a' with '4'): ");
        list.forEach(l -> System.out.println(l.toString().replace("a", "4")));
    }

    public static void showNumerics(List<Object> list){
        System.out.println("List showing only numeric elements from original list: ");
        list.stream()
                .filter(l -> StringUtils.isNumeric(l.toString()))
                .forEach(System.out::println);
    }
}
