package n2ex01;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Restaurant> restaurants = new HashSet<Restaurant>();
        boolean isEnough = false;

        System.out.println("Let's create a restaurant list!");
        do {
            try{
                createRestaurant(restaurants);
                isEnough = !Entry.readYesNo("Do you want to add another restaurant? (y/n)");
            } catch (InputMismatchException e){
                System.err.println("Format error." + e.getMessage());
                sc.nextLine();
            }
        } while (!isEnough);
        System.out.println("Bye!");
    }

    public static void createRestaurant(HashSet<Restaurant> restaurants){
        Scanner sc = new Scanner(System.in);
        String name;
        int score;
        System.out.println("Introduce the restaurant's name:");
        name = sc.nextLine();
        System.out.println("Introduce their score");
        score = sc.nextInt();

        if (!isSameRestaurant(restaurants, name, score)){
            restaurants.add(new Restaurant(name, score));
            System.out.println("Restaurant created.");
        } else {
            System.out.println("Can't add this restaurant. Already exists a restaurant with same name and score.");
        }
    }
    public static boolean isSameRestaurant( HashSet<Restaurant> restaurants, String name, int score){
        boolean sameRest = false;

        for (Restaurant r : restaurants){
            if (r.getName().equalsIgnoreCase(name) && (r.getScore() == score)) {
                sameRest = true;
            }
        }
        return sameRest;
    }
}
