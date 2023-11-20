package n1ex01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Undo {
    private static Undo instance;
    ArrayList<String> commands;

    private Undo(){
        commands = new ArrayList<>();
    }

    public static Undo getInstance(){
        if (instance == null){
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(Scanner entry){
        System.out.println("Introduce the command: ");
        String command = entry.nextLine();
        commands.add(command);
        System.out.println("Command " + command + " successfully added.\n");
    }

    public void deleteCommand(Scanner entry){
        if (commands.isEmpty()) {
            System.out.println("Can't delete any command. Command history is empty.\n");
            return;
        }

        System.out.println("Introduce the command: ");
        String command = entry.nextLine();

        if (findCommand(command) != -1){
            commands.remove(command);
            System.out.println("Command " + command + " successfully deleted.\n");
        } else {
            System.out.println(command + " is not in command history\n");
        }
    }

    public int findCommand(String command){
        if (!commands.isEmpty()){
            for (int i = 0; i < commands.size(); i++){
                if (commands.get(i).equalsIgnoreCase(command)){
                    return i;
                }
            }
        }
        return -1;
    }

    public void listLastCommands(Scanner entry){
        if (commands.isEmpty()) {
            System.out.println("Can't list commands. Command history is empty.\n");
            return;
        }

        int quantCommands = 0;
        do {
            System.out.println("How many last commands do you want to see?");
            try {
                quantCommands = entry.nextInt();
                if (quantCommands > commands.size()){
                    System.out.println("You cannot retrieve " + quantCommands + " commands. There are " + commands.size() + " commands.");
                }
            } catch (InputMismatchException e) {
                quantCommands = -1;
                entry.nextLine();
                System.out.println("Introduce a valid option.\n");
            }
        } while (quantCommands == -1 | quantCommands > commands.size());

        int startInd = commands.size() - quantCommands;

        for (int i = startInd; i < commands.size(); i++){
            System.out.println("Command " + (i + 1) + ": " + commands.get(i));
        }

    }




}
