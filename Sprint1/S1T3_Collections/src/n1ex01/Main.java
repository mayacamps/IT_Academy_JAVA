package n1ex01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<Month>();

        Month jan = new Month("Jan");
        Month feb = new Month("Feb");
        Month mar = new Month("Mar");
        Month apr = new Month("Apr");
        Month mai = new Month("Mai");
        Month jun = new Month("Jun");
        Month jul = new Month("Jul");
        Month sep = new Month("Sep");
        Month oct = new Month("Oct");
        Month nov = new Month("Nov");
        Month dec = new Month("Dec");

        months.add(jan);
        months.add(feb);
        months.add(mar);
        months.add(apr);
        months.add(mai);
        months.add(jun);
        months.add(jul);
        months.add(sep);
        months.add(oct);
        months.add(nov);
        months.add(dec);

        months.add(7, new Month("August"));


        for (Month month : months){
            System.out.println(month.getName());
        }

        HashSet<Month> monthsHashSet = new LinkedHashSet<>(months);
        monthsHashSet.add(jan);


        System.out.println("\nIterate HashSet using for loop");
        for (Month month : monthsHashSet){
            System.out.println(month.getName());
        }

        System.out.println("\nIterate HashSet using iterator");
        Iterator<Month> monthIt = monthsHashSet.iterator();
        while (monthIt.hasNext()) {
            System.out.println(monthIt.next().getName());
        }


    }
}
