package n1ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class RecursiveDirectoryList {
    public static void main(String[] args) {

        new RecursiveDirectoryList().getRecursiveListContent(getDirectory(),"");
    }

    public static File getDirectory() {
        Scanner sc = new Scanner(System.in);
        File dir;
        String path;
        boolean isDir = false;

        System.out.println("This program lists all the contents of a specific directory.");

        do {
            System.out.println("Please introduce the directory's path: ");
            path = sc.nextLine();
            dir = new File(path);

            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("Path given is not directory.");
            } else {
                isDir = true;
            }
        } while (!isDir);

        return dir;
    }

    public void getRecursiveListContent(File dir, String tab){
        File [] content = dir.listFiles();
        if (content == null){
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(content);
            for (File s : content) {
                System.out.print(tab);
                if (s.isDirectory()) {
                    System.out.println("(D)" + s.getName());
                    getRecursiveListContent(s, "\t");
                } else {
                    System.out.println("(F)" + s.getName());
                }
            }
        }
    }
}

