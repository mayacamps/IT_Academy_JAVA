package n1ex02;

public class GenericMethods<T> {
    public static <T> void printAll ( T t1, T t2, T t3){
        System.out.println("\nObject 1: " + t1 +
                "\nObject 2: " + t2 +
                "\nObject 3: " + t3);
    }
}
