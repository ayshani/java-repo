import java.io.*;

//https://www.geeksforgeeks.org/externalizable-interface-java/
public class ExternalizationMain {

    public static void main(String[] args) {

        String filename = "demo.ser";
        System.out.println("Serialization -----");

        DemoObjectExternalization obj = new DemoObjectExternalization("Abc", 34, "password");

        try {
            FileOutputStream fo = new FileOutputStream(filename);
            ObjectOutputStream op = new ObjectOutputStream(fo);

            op.writeObject(obj);

            op.close();
            fo.close();

            System.out.println("Object is serialized-----");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DemoObjectExternalization deserializedObejct = null;

        System.out.println("Deserialization --------");

        try {
            FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream op = new ObjectInputStream(fi);

            deserializedObejct = (DemoObjectExternalization) op.readObject();

            op.close();
            fi.close();

            System.out.println("Deserialization completed : "+ deserializedObejct);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
