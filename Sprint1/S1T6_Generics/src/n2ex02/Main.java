package n2ex02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Mark", "Wahlberg", 34);
        String text = "Test text";
        int num = 111;
        
        ArrayList<Object> test = new ArrayList<>();
        test.add(person1);
        test.add(text);
        test.add(num);

        GenericMethodsRemodified.printAll(test);
    }
}
