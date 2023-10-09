package n1ex02;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveDirectoryList {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

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
                getRecursiveListContent(dir, "");
            }
        } while (!isDir);
    }

    public static void getRecursiveListContent(File dir, String tab){
        File [] content = dir.listFiles();
        if (content == null){
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(content);
            for (File s : content) {
                System.out.print(tab);
                if (s.isDirectory()) {
                    System.out.println("(D)" + s.getName() + ". Last modification: " + getModDate(s));
                    getRecursiveListContent(s, "\t");
                } else {
                    System.out.println("(F)" + s.getName()+ ". Last modification: " + getModDate(s));
                }
            }
        }
    }

    public static String getModDate(File file){
        long datetime = file.lastModified();
        return dateFormat.format(datetime);
    }
}

