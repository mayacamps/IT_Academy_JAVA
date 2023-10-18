package n3ex01;

public class Generic {
    public static <T> void genericPhone(Phone phone){
        phone.ring();
    }

    public static <T> void genericSmartphone(Smartphone smartphone){
        smartphone.ring();
        smartphone.takePhotos();
    }
}
