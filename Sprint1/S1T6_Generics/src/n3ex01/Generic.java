package n3ex01;

public class Generic {
    public static <T extends Phone> void genericPhone(T t){
        t.ring();
    }

    public static <T extends Smartphone> void genericSmartphone(T t){
        t.ring();
        t.takePhotos();
    }
}
