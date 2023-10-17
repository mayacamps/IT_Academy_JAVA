package n1ex02;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Mark", "Wahlberg", 34);
        String text = "Test text";
        int num = 111;

        GenericMethods.printAll(person1, text, num);
        GenericMethods.printAll(text, num, person1);
        GenericMethods.printAll(num, person1, text);
    }
}
