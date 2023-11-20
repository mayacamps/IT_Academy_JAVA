package n1ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {
        Undo undo = Undo.getInstance();
        int menuOpt;

        do {
            System.out.println("Command option menu:" +
                    "\n1. Add command" +
                    "\n2. Delete command" +
                    "\n3. List last commands" +
                    "\n0. Exit");
            try {
                menuOpt = entry.nextInt();
            } catch (InputMismatchException e){
                menuOpt = -1;
            }
            entry.nextLine();

            switch (menuOpt){
                case 1 -> undo.addCommand(entry);
                case 2 -> undo.deleteCommand(entry);
                case 3 -> undo.listLastCommands(entry);
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Please introduce a valid value.\n");
            }
        } while (menuOpt != 0);
    }
}
