package n1ex01;

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker("Elena", "Nito", 12.5d);
        Worker w2 = new OnlineWorker("Marco", "Polo", 7);
        Worker w3 = new InPersonWorker("Celia", "Cruz", 20.5d);

        w1.calcSalary(10);
        w2.calcSalary(10);
        w3.calcSalary(10);
    }
}
