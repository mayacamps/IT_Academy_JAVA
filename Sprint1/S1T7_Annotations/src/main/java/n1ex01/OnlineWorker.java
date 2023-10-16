package n1ex01;

public class OnlineWorker extends Worker{
    private final int INTERNET = 50;
    public OnlineWorker(String name, String surname, int priceHour) {
        super(name, surname, priceHour);
    }

    @Override
    public void calcSalary(int numHours){
        int pay = numHours * getPriceHour() + INTERNET;
        System.out.println("Worker's pay is: " + pay + "eur.");
    }
}
