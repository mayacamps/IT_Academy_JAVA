package n2ex02;

import n2ex01.Restaurant;
import static n2ex01.Entry.readYesNo;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Restaurant> restaurants = new TreeSet<>();

        boolean isEnough = false;

        System.out.println("Let's create a restaurant list!");
        do {
            try{
                createRestaurant(restaurants);
                isEnough = !readYesNo("Do you want to add another restaurant? (y/n)");
            } catch (InputMismatchException e){
                System.err.println("Format error." + e.getMessage());
                sc.nextLine();
            }
        } while (!isEnough);
        System.out.println("Bye!");

        System.out.println(restaurants.size());
        for (Restaurant r : restaurants){
            System.out.println(r.toString());
        }
    }

    public static void createRestaurant(TreeSet<Restaurant> restaurants){
        Scanner sc = new Scanner(System.in);
        String name;
        int score;
        System.out.println("Introduce the restaurant's name:");
        name = sc.nextLine();
        System.out.println("Introduce their score");
        score = sc.nextInt();

        if (!isSameRestaurant(restaurants, name, score)){
            Restaurant restaurant = new Restaurant(name, score);
            restaurants.add(restaurant);
            System.out.println("Restaurant created.");
        } else {
            System.out.println("Can't add this restaurant. Already exists a restaurant with same name and score.");
        }
    }

    public static boolean isSameRestaurant( TreeSet<Restaurant> restaurants, String name, int score){
        for (Restaurant r : restaurants){
            if (r.getName().equalsIgnoreCase(name) && (r.getScore() == score)) {
                return true;
            }
        }
        return false;
    }

}
