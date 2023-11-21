package n1ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {
        Undo undo = Undo.getInstance();
        int menuOpt = -1;

        do {
            try{
                System.out.println("Command option menu:" +
                        "\n1. Add command" +
                        "\n2. Delete command" +
                        "\n3. List last commands" +
                        "\n0. Exit");

                menuOpt = entry.nextInt();
                entry.nextLine();

                switch (menuOpt){
                    case 1 -> undo.addCommand(entry);
                    case 2 -> undo.deleteCommand(entry);
                    case 3 -> undo.listLastCommands(entry);
                    case 0 -> System.out.println("Bye!");
                    default -> System.err.println("Please introduce a valid value.\n");
                }
            } catch (InputMismatchException e){
                entry.nextLine();
                System.err.println("Wrong format input. Please introduce a valid value.\n");
            }
        } while (menuOpt != 0);
    }
}
