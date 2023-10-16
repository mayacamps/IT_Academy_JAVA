package n1ex02;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Mark", "Wahlberg", 34);
        
        GenericMethods.printAll(person1, "Test text", 111);
    }
}
