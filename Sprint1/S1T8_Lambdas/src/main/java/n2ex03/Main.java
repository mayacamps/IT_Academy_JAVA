package n2ex03;

public class Main {
    public static void main(String[] args) {
        OperationInterface addition = Float::sum;
        OperationInterface subtraction = (a,b) -> a - b;
        OperationInterface multiplication = (a,b) -> a * b;
        OperationInterface division = (a,b) -> a / b;

        System.out.println("2 + 5.5 = " + addition.operation(2, 5.5f));
        System.out.println("34.7 - 22 = " + subtraction.operation(34.7f, 22));
        System.out.println("4 * 3 = " + multiplication.operation(4, 3));
        System.out.println("32 / 6 = " + division.operation(32, 6));
    }
}
