package n1ex03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TxtSavedRecursiveDirectoryList {
    static int countLoop  = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dir;
        String path, savePath;
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
                try {
                    savePath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T5_JavaUtils\\src\\n1ex03";

                    PrintWriter writer = new PrintWriter(new FileWriter(savePath + "\\DirectoryListing.txt"));
                    System.out.println("Saving directory content listing in txt file...");
                    getRecursiveTxtListContent(dir, "", writer);

                    writer.close();
                    System.out.println("Content saved in DirectoryListing.txt");
                } catch (IOException e){
                    System.out.println("Error." + e.getMessage());
                }
            }
        } while (!isDir);
    }


    public static void getRecursiveTxtListContent(File dir, String tab, PrintWriter writer){
        File [] content = dir.listFiles();
        if (content == null){
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(content);
            for (File s : content) {
                for (int i = 0; i < countLoop; i++){
                    writer.write(tab);
                }
                if (s.isDirectory()) {
                    countLoop++;
                    writer.write("(D)" + s.getName() + "\n");
                    getRecursiveTxtListContent(s, "\t", writer);
                } else {
                    writer.write("(F)" + s.getName() + "\n");
                }
            }

        }
    }
}

