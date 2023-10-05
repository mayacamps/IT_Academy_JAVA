package n1ex01;

import java.util.ArrayList;

public class Months {
    private ArrayList<String> months;

    public Months() {
        months = new ArrayList<>();
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("Jun");
        months.add("Jul");
        months.add("Aug");
        months.add("Sept");
        months.add("Oct");
        months.add("Nov");
        months.add("Dec");
    }

    public ArrayList<String> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<String> months) {
        this.months = months;
    }
}
