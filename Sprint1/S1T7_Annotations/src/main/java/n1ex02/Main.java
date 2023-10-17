package n1ex02;

public class Main {
    @SuppressWarnings("deprecation")
    static void printOnlineWorkerMessage(OnlineWorker worker){
        worker.deprecatedMethod();
    }
    @SuppressWarnings("deprecation")
    static void printInPersonWorkerMessage(InPersonWorker worker){
        worker.deprecatedMethod();
    }
    public static void main(String[] args) {
        Worker w1 = new Worker("Elena", "Nito", 12.5d);
        OnlineWorker w2 = new OnlineWorker("Marco", "Polo", 7);
        InPersonWorker w3 = new InPersonWorker("Celia", "Cruz", 20.5d);

        printOnlineWorkerMessage(w2);
        printInPersonWorkerMessage(w3);
    }
}
