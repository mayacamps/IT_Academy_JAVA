package n1ex08;

public class Main {
    public static void main(String[] args) {
        String original = "Learning lambdas";
        String reversed = "";

        ReverseInterface ri = (s -> new StringBuilder(s).reverse().toString());
        reversed = ri.reverse(original);

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
