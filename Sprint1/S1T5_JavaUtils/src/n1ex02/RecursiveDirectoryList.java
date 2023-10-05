package n1ex02;

import java.util.Collection;
import java.util.Scanner;

public class RecursiveDirectoryList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;

        System.out.println("This program lists all the contents of a specific directory.\n" +
                "Please introduce the directory's path: ");
        path = sc.nextLine();

        new RecursiveDirectoryList().getRecursiveListContent(path);
    }

    public void getRecursiveListContent(String path){

    }
}
