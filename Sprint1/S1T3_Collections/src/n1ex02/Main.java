package n1ex02;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Ordered List: ");
        for (int i : list){
            System.out.println(i);
        }

        List<Integer> listReverse = new ArrayList<>();

        ListIterator<Integer> listIt = list.listIterator();
        while (listIt.hasNext()){
            listIt.next();
        }

        while (listIt.hasPrevious()){
            listReverse.add(listIt.previous());
        }

        System.out.println("Reverse-ordered list: ");
        for (int num : listReverse){
            System.out.println(num);
        }







    }
}
