package n2ex02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNum = Arrays.asList(1, 55, 32, 4, 16, 87);
        System.out.println(separateIntOddOrEven(listNum));
    }

    public static String separateIntOddOrEven(List<Integer> numbers){
        return numbers.stream()
                .map(n -> n % 2 == 0 ? ("e" + n):("o" + n))
                .collect(Collectors.joining(", "));
    }
}
