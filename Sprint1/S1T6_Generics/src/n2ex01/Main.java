package n2ex01;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Mark", "Wahlberg", 34);
        String text = "Test text";
        int num = 111;

        GenericMethodsModified.printAll(person1, text, num);
        GenericMethodsModified.printAll(text, person1, num);
//        GenericMethodsModified.printAll(text, num, person1);
    }
}
