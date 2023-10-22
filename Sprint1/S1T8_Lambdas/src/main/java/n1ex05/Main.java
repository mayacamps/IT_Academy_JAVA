package n1ex05;

public class Main {
    public static void main(String[] args) {
        FunctionalInterface fi = () -> 3.1415;
        System.out.println(fi.getPiValue());
    }
}
