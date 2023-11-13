package n1ex02;

public class InPersonWorker extends Worker {
    private static int gas;
    public InPersonWorker(String name, String surname, double priceHour) {
        super(name, surname, priceHour);
        gas = 100;
    }

    @Override
    public void calcSalary(double numHours) {
        double pay = numHours * getPriceHour() + gas;
        System.out.println("Worker's pay is: " + pay + "eur.");
    }

    @Deprecated
    @SuppressWarnings("deprecation")
    public void deprecatedMethod(){
        System.out.println("This is an obsolete method in InPersonWorker class.");
    }
}
