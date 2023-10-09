package n1ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class RecursiveDirectoryList {
    public static void main(String[] args) {

        new RecursiveDirectoryList().getRecursiveListContent();
    }

    public void getRecursiveListContent(){
        Scanner sc = new Scanner(System.in);
        String path;

        System.out.println("This program lists all the contents of a specific directory.\n" +
                "Please introduce the directory's path: ");
        path = sc.nextLine();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()){
            System.out.println("Path given is not directory.");
            return;
        }

        // LOOP TO REPEAT ID line36 executes
        File [] content = dir.listFiles();
        if (content.length == 0){
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(content);
            for (File s : content) {
                if (s.isDirectory()) {
                    System.out.println("(D)" + s.getName());
                } else {
                    System.out.println("(F)" + s.getName());
                }
            }

        }




    }
}

