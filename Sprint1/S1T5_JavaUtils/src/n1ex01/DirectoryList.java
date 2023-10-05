package n1ex01;

import java.io.File;
import java.util.Scanner;

public class DirectoryList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;

        System.out.println("This program lists all the contents of a specific directory.\n" +
                "Please introduce the directory's path: ");
        path = sc.nextLine();

        new DirectoryList().getListContent(path);

    }

    public void getListContent(String path){
        File file = new File(path);

        if (!file.exists() || !file.isDirectory()){
            System.out.println("Path given is not directory.");
            return;
        }

        String [] content = file.list();

        if (content.length == 0){
            System.out.println("Directory is empty.");
        } else{
            for (String s : content) {
                System.out.println(s);
            }
        }

    }
}
