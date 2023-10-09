package n1ex03;

import java.io.*;
import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static String workingPath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T3_Collections\\src\\n1ex03";
    public static void main(String[] args) {
        playGame();
    }

    public static HashMap<String, String> mapFromTxt() {
        HashMap<String, String> countries = new LinkedHashMap<String, String>();
        BufferedReader bufRead = null;
        String line = null;

        try {
            bufRead = new BufferedReader(new FileReader(workingPath + "\\countries.txt"));

            line = bufRead.readLine();

            while (line != null) {
                String[] parts = line.split(" ");

                String country = parts[0];
                String capital = parts[1];

                if (!country.isEmpty() && !capital.isEmpty()) {
                    country = country.replace("_", " ");
                    capital = capital.replace("_", " ");

                    countries.put(country, capital);
                }
                line = bufRead.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error." + e.getMessage());
        } finally {
            if (bufRead != null) {
                try {
                    bufRead.close();
                } catch (Exception e) {
                    System.err.println("Error closing file. " + e.getMessage());
                }
            }
        }
        return countries;
    }

    public static String getUserName(){
        String name;
        System.out.println("What is your name?");
        name = sc.nextLine();
        return name;
    }

    public static void createResultFile(String name, int score){
        try (PrintWriter writer = new PrintWriter(new FileWriter(workingPath + "\\classification.txt"))) {
            writer.write(name + " has scored " + score + " points");
            writer.close();
            System.out.println("You have scored " + score + " points.\n" +
                    "Successfully saved " + name + "'s score in 'classifications.txt'");
        } catch (IOException e){
            System.err.println("Error." + e.getMessage());
        }

    }

    public static void playGame(){
        int score = 0;
        String capital, user;

        HashMap<String, String> countries = mapFromTxt();
        user = getUserName();

        System.out.println("Let's start the game!");

        for (int i= 0; i < 10; i++){
            int randomInd = new Random().nextInt(countries.size());

            String country = countries.keySet().toArray()[randomInd].toString();

            System.out.println("What is the capital of " + country + "?");
            capital = sc.nextLine();

            if (capital.equalsIgnoreCase(countries.get(country))){
                System.out.println("Correct! +1 point.");
                score++;
            } else {
                System.out.println("Incorrect! The answer was: " + countries.get(country));
            }
        }

        System.out.println("End of the game!");
        createResultFile(user, score);
    }
}
