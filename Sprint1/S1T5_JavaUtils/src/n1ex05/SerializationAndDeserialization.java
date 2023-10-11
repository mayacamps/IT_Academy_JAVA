package n1ex05;

import java.io.*;
import java.util.ArrayList;


public class SerializationAndDeserialization {
    static String savePath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T5_JavaUtils\\src\\n1ex05";

    public static void main(String[] args) {

        if (args.length > 0) {
            ArrayList<ObjectSer> myObjects = new ArrayList<>();
            myObjects.add(new ObjectSer("oneText.txt", "F", "2023-10-10 10:48:00"));
            myObjects.add(new ObjectSer("twoText.txt", "F", "2023-10-11 12:48:00"));
            myObjects.add(new ObjectSer("threeText.txt", "F", "2023-10-11 9:37:15"));

            String fileName = args[0] + ".ser";
            serializeObject(myObjects, fileName);
            deserializeObject(fileName);
        } else{
            System.out.println("Use: SerializationAndDeserialization name_desired_file");
        }
    }

    public static void serializeObject(ArrayList<ObjectSer> myObjects, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(savePath + "\\" + fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(myObjects);
            oos.close();
            System.out.println("Serialized objects in " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found. " + e.getMessage());
            throw new RuntimeException();
        } catch (IOException e) {
            System.err.println("Error. " + e.getMessage());
        }
    }

    public static void deserializeObject(String fileName) {
        System.out.println("Reading object...");
        try (FileInputStream fis = new FileInputStream(savePath + "\\" + fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            ArrayList<ObjectSer> objectList = new ArrayList<ObjectSer>();
            objectList = (ArrayList<ObjectSer>) ois.readObject();
            ois.close();

            for (ObjectSer o : objectList){
                System.out.println(o);
            }

        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}



