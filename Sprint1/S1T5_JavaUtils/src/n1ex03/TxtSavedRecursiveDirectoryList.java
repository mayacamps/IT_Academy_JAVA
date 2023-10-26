package n1ex03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class TxtSavedRecursiveDirectoryList {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static int dirLev = 0;

    public static void main(String[] args) {

        if (args.length>0){
            File dir;
            String path, savePath;
            boolean isDir = false;


            do {
                path = args[0];
                dir = new File(path);

                if (!dir.exists() || !dir.isDirectory()) {
                    System.out.println("Path given is not directory.");
                } else {
                    isDir = true;
                    try {
                        PrintWriter writer = new PrintWriter(new FileWriter("DirectoryListing.txt"));
                        System.out.println("Saving directory content listing in txt file...");
                        getRecursiveTxtListContent(dir, "", writer);

                        writer.close();
                        System.out.println("Content saved in DirectoryListing.txt");
                    } catch (IOException e){
                        System.out.println("Error." + e.getMessage());
                    }
                }
            } while (!isDir);
        } else {
            System.out.println("Use: TxtRecursiveDirectoryList.java directory_path");
        }
    }

    public static void getRecursiveTxtListContent(File dir, String tab, PrintWriter writer){
        File [] content = dir.listFiles();
        if (content == null){
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(content);
            for (File s : content) {
                for (int i = 0; i < dirLev; i++){
                    writer.write(tab);
                }
                if (s.isDirectory()) {
                    dirLev++;
                    writer.write(String.format("%s %s" , "(D)" + s.getName(), "Last modification: " + getModDate(s) + "\n"));
                    getRecursiveTxtListContent(s, "\t", writer);

                } else {
                    writer.write(String.format("%s %s" , "(F)" + s.getName(), "Last modification: " + getModDate(s) + "\n"));
                }
            }
            dirLev --;
        }
    }

    public static String getModDate(File file){
        long datetime = file.lastModified();
        return dateFormat.format(datetime);
    }
}

