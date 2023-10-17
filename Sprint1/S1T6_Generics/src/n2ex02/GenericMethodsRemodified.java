package n2ex02;

import java.util.List;

public class GenericMethodsRemodified<T> {
    public static <T> void printAll (List<T> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println("Object " + (i+1) + ": " + list.get(i));
        }
    }
}
