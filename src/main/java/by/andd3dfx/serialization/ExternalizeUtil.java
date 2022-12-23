package by.andd3dfx.serialization;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizeUtil {

    @SneakyThrows
    public static void write(String fileName, Object object) {
        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(object);
        }
    }

    @SneakyThrows
    public static Object read(String fileName) {
        try (var objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        }
    }
}
