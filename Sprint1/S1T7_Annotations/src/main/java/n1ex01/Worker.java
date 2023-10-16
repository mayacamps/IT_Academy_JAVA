package n1ex01;

public class Worker {
    private String name, surname;
    private int priceHour;

    public Worker(String name, String surname, int priceHour) {
        this.name = name;
        this.surname = surname;
        this.priceHour = priceHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    public void calcSalary(int numHours){
        int pay = numHours * priceHour;
        System.out.println("Worker's pay is: " + pay + "eur.");
    }
}
