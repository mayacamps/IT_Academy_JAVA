package n2ex01;

public class GenericMethodsModified<T> {
    public static <T> void printAll ( T t1, T t2, int num){
        System.out.println("\nObject 1: " + t1 +
                "\nObject 2: " + t2 +
                "\nObject 3: " + num);
    }
}
