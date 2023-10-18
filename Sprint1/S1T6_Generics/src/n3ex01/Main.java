package n3ex01;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone("Samsung", "Galaxy");
        Generic.genericPhone(smartphone);
        Generic.genericSmartphone(smartphone);
    }

}
