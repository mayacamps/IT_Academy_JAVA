package n2ex01;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class ConfigFileParametrization {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static int dirLev = 0;
    static String path;
    static String fileName = "DirectoryListing.txt";
    static String savePath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T5_JavaUtils\\src\\n2ex01";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isDir = false;

        System.out.println("This program lists all the contents of a specific directory.");

        do {
            System.out.println("Please introduce the directory's path: ");
            path = sc.nextLine();
            File dir = new File(path);

            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("Path given is not directory.");
            } else {
                isDir = true;
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(savePath + "\\" + fileName));
                    System.out.println("Saving directory content listing in txt file...");
                    getRecursiveTxtListContent(dir, "", writer);

                    writer.close();
                    System.out.println("Content saved in DirectoryListing.txt");
                } catch (IOException e){
                    System.out.println("Error." + e.getMessage());
                }
            }
        } while (!isDir);

        // SAVING TO PROPERTIES FILE
        String configFilePath = savePath + "\\n1ex5.properties";

        Properties n1ex5Props = new Properties();
        n1ex5Props.setProperty("Directory Path", path);
        n1ex5Props.setProperty("Name Result Txt File", fileName);
        n1ex5Props.setProperty("Directory Result Txt File", savePath);

        try {
            n1ex5Props.store(new PrintWriter(new FileWriter(configFilePath)), "storing to properties file");
            System.out.println("Properties file created successfully.");
        } catch (IOException e) {
            e.getStackTrace();
        }

//       READING PROPERTIES FILE
//        Properties prop = new Properties();
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        InputStream stream = loader.getResourceAsStream("n1ex5.properties");
//        try {
//            prop.load(stream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        for(String key : prop.stringPropertyNames()) {
//            String value = prop.getProperty(key);
//            System.out.println(key + " => " + value);
//        }
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

