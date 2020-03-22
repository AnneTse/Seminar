package Seminar1;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static void recordData(List<Animal> animals, String file) throws IOException {

       try (DataOutputStream outputStream = new DataOutputStream(Files.newOutputStream(Paths.get(file)))) {
           outputStream.writeInt(animals.size());
           for (Animal animal : animals) {
               outputStream.writeUTF(animal.getName());
               outputStream.writeUTF(animal.getType().name());
               outputStream.writeInt(animal.getAge());

               outputStream.writeInt(animal.getFood().size());
               for (Food food : animal.getFood()) {
                   outputStream.writeUTF(food.getFoodName());
                   outputStream.writeInt(food.getCount());
               }
           }
       }
    }

    public static List<Animal> readData(String file) throws ClassCastException, IOException {

        List<Animal> animal = new ArrayList<>();
        String name;
        TypeAn typeAn;
        int age;

        List<Food> food = new ArrayList<>();
        String foodName;
        int count;

        try(DataInputStream inputStream = new DataInputStream(Files.newInputStream(Paths.get(file)))){

            int animalCount = inputStream.readInt();
            int foodCount = inputStream.readInt();

            for (int i = 0; i < animalCount; i++) {
                name = inputStream.readUTF();
                age = inputStream.readInt();
                typeAn = TypeAn.valueOf(inputStream.readUTF());

                for (int j = 0; j < foodCount; j++) {
                    foodName = inputStream.readUTF();
                    count = inputStream.readInt();
                    food.add(new Food(foodName, count));
                }
                animal.add(new Animal(name, typeAn, age, food));
            }
        }
        return animal;
    }
}

