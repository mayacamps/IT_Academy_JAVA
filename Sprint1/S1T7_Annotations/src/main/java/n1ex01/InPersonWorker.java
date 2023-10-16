package n1ex01;

public class InPersonWorker extends Worker{
    private static int gas;
    public InPersonWorker(String name, String surname, int priceHour) {
        super(name, surname, priceHour);
        gas = 100;
    }

    @Override
    public void calcSalary(int numHours) {
        int pay = numHours * getPriceHour() + gas;
        System.out.println("Worker's pay is: " + pay + "eur.");
    }
}
