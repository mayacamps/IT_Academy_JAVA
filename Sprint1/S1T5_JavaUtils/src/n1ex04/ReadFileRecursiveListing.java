package n1ex04;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFileRecursiveListing {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
                    savePath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T5_JavaUtils\\src\\n1ex04";

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
                writer.write(tab);
                if (s.isDirectory()) {
                    writer.write("(D)" + s.getName() + "\n" + ". Last modification: " + getModDate(s));
                    getRecursiveTxtListContent(s, "\t", writer);
                } else {
                    writer.write("(F)" + s.getName() + "\n" + ". Last modification: " + getModDate(s));
                    readFile(s);
                }
            }

        }
    }

    public static String getModDate(File file){
        long datetime = file.lastModified();
        return dateFormat.format(datetime);
    }

    public static void readFile(File file){
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}

