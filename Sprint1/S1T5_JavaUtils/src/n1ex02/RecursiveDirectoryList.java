package n1ex02;

import java.io.File;
import java.util.Arrays;
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
        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()){
            System.out.println("Path given is not directory.");
            return;
        }

        boolean thereIsFolder = false;
        do {
            File [] content = dir.listFiles();
            if (content.length == 0){
                System.out.println("Directory is empty.");
            } else{
                Arrays.sort(content);

                for (File s : content) {
                    if (s.isDirectory()) {
                        thereIsFolder = true;
                        System.out.println(s.getName() + "(D)");

                        File[] folder = s.listFiles();
                        for (File a : folder) {
                            if (a.isDirectory()) {
                                System.out.println("\t" + a.getName() + "(D)");
                            } else {
                                System.out.println("\t" + a.getName() + "(F)");
                            }
                        }
                    } else {
                        System.out.println(s.getName() + "(F)");
                    }
                }
//                File[] folder = s.listFiles();
//                for (File a : folder) {

                }

        } while (!thereIsFolder);


//        File [] content = dir.listFiles();
//
//        if (content.length == 0){
//            System.out.println("Directory is empty.");
//        } else{
//            Arrays.sort(content);
//            for (File s : content) {
//                if (s.isDirectory()) {
//                    thereIsFolder = true;
//                    System.out.println(s.getName() + "(D)");
//
//                    File[] folder = s.listFiles();
//                    for (File a : folder) {
//                        if (a.isDirectory()) {
//                            System.out.println("\t" + a.getName() + "(D)");
//                        } else {
//                            System.out.println("\t" + a.getName() + "(F)");
//                        }
//                    }
//                } else {
//                    System.out.println(s.getName() + "(F)");
//                }
//            }

            
    }
}

