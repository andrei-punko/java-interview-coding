package by.andd3dfx.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Check link for details: https://javarush.ru/groups/posts/2023-znakomstvo-s-interfeysom-externalizable
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialize object
        FileOutputStream fileOutputStream = new FileOutputStream("./sandbox-core/target/save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        UserInfo userInfo = new UserInfo("Ivan", "Ivanov", "Ivan Ivanov's passport data");
        objectOutputStream.writeObject(userInfo);
        objectOutputStream.close();

        // Deserialize object
        FileInputStream fileInputStream = new FileInputStream("./sandbox-core/target/save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        UserInfo deserializedUserInfo = (UserInfo) objectInputStream.readObject();
        System.out.println(deserializedUserInfo);
        objectInputStream.close();
    }
}
