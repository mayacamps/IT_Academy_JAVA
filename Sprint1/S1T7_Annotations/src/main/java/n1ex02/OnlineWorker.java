package n1ex02;

public class OnlineWorker extends Worker {
    private final int INTERNET = 50;
    public OnlineWorker(String name, String surname, double priceHour) {
        super(name, surname, priceHour);
    }

    @Override
    public void calcSalary(double numHours){
        double pay = numHours * getPriceHour() + INTERNET;
        System.out.println("Worker's pay is: " + pay + "eur.");
    }

    @Deprecated
    @SuppressWarnings("deprecation")
    public void deprecatedMethod() {
        System.out.println("This is an obsolete method in OnlineWorker class.");
    }
}
