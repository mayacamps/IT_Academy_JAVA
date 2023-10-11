package n1ex05;

import java.io.*;
import java.util.ArrayList;

public class SerializationAndDeserialization {

    public static void main(String[] args) {

        if (args.length == 0) {
            ArrayList<ObjectSer> myObjects = new ArrayList<>();
            myObjects.add(new ObjectSer("oneText.txt", "F", "2023-10-10 10:48:00"));
            myObjects.add(new ObjectSer("twoText.txt", "F", "2023-10-11 12:48:00"));
            myObjects.add(new ObjectSer("threeText.txt", "F", "2023-10-11 9:37:15"));

            serializeObject(myObjects, "results.txt");
            deserializeObject("results.txt");


        } else{
//            serializeObject(myObjects, args[0] + ".txt");
//            deserializeObject(args[0]);
            System.out.println("Use: SerializationAndDeserialization name_desired_file");
        }


    }

    public static void serializeObject(ArrayList<ObjectSer> myObjects, String fileName) {
        String savePath = "C:\\Users\\lluisa\\IdeaProjects\\ITAcademy_JAVA\\Sprint1\\S1T5_JavaUtils\\src\\n1ex05";
        try (FileOutputStream fos = new FileOutputStream(savePath + "\\" + fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(myObjects);
            oos.close();
            System.out.println("Serialized Objects!");
        } catch (FileNotFoundException e) {
            System.err.println("File not found. " + e.getMessage());
            throw new RuntimeException();
        } catch (IOException e) {
            System.err.println("Error. " + e.getMessage());
        }
    }

    public static void deserializeObject(String fileName) {
        System.out.println("Reading object...");
        try (FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            ArrayList<ObjectSer> objectList = (ArrayList) ois.readObject();
            ois.close();
            if (objectList != null) {
                for (ObjectSer o : objectList){
                    System.out.println(o.toString());
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.getStackTrace();
        }
    }
}



