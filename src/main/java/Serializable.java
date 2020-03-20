import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Serializable implements java.io.Serializable {
    public static void record(List<Animal> animal, String file) throws IOException {
        Path path = Paths.get(file);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(animal);
        }
    }
    public static List<Animal> read(String file) throws IOException, ClassNotFoundException {
        List<Animal> animal;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            animal = (List<Animal>) inputStream.readObject();
        }
        return animal;
    }
}

