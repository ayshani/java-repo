import java.io.*;

//https://www.geeksforgeeks.org/serialization-in-java/
public class SerialDeMain {
    public static void main(String[] args) {

        String filename = "demo.ser";
        System.out.println("Serialization -----");

        DemoObject obj = new DemoObject("Abc", 34);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(obj);

            outputStream.close();
            fileOutputStream.close();

            System.out.println("Object has been serialized : "+ obj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("De-Serialization -----");
        DemoObject deserializedObejct = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            deserializedObejct = (DemoObject) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Object has been de-serialized : "+ deserializedObejct);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}