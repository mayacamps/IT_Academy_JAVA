package n1ex01;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryList {

    public static void main(String[] args) {
        if (args.length > 0) {
            String path = args[0];
            new DirectoryList().getListContent(path);
        } else {
            System.out.println("Use: RecursiveDirectoryList.java directory_path");
        }
    }

    public void getListContent(String path){
        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()){
            System.out.println("Path given is not directory or doesn't exist.");
            return;
        }

        String [] content = dir.list();

        if (content.length == 0){
            System.out.println("Directory is empty.");
        } else{
            Arrays.sort(content);
            for (String s : content) {
                System.out.println(s);
            }
        }

    }
}
