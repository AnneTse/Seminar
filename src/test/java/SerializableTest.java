import Seminar1.Animal;
import Seminar1.Food;
import Seminar1.Serializable;
import Seminar1.TypeAn;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SerializableTest {
    @Test
    public void empty() throws IOException, ClassNotFoundException {
        Serializable.record(Collections.emptyList(), "file");
        assertEquals(Collections.emptyList(), Serializable.read("file"));
    }

    @Test
    public void oneAnimal() throws IOException, ClassNotFoundException {
        List<Animal> animal = Arrays.asList(new Animal("Wolf", TypeAn.PREDATORS, 10,  Arrays.asList(new Food("Meat",5))));
        Serializable.record(animal, "fileOne");
        assertEquals(animal, Serializable.read("fileOne"));
        assertNotEquals(Collections.emptyList(), Serializable.read("fileOne"));
    }
    @Test
    public void twoAnimals() throws IOException, ClassNotFoundException {
        List<Animal> animal1 = Arrays.asList(new Animal("Cow", TypeAn.HERBIVORES, 10,  Arrays.asList(new Food("Grass",5))));
        List<Animal> animal2 = Arrays.asList(new Animal("Cow2", TypeAn.HERBIVORES, 15,  Arrays.asList(new Food("Grass",6))));
        Serializable.record(animal1, "fileTwo1");
        Serializable.record(animal2, "fileTwo2");
        assertEquals(animal1, Serializable.read("fileTwo1"));
        assertNotEquals(animal1, Serializable.read("fileTwo2"));
        assertNotEquals( Serializable.read("fileTwo1"), Serializable.read("fileTwo2"));
    }

        @Test
    public void emptyData() throws IOException {
        Serializable.recordData(Collections.emptyList(), "file");
        assertEquals(Collections.emptyList(), Serializable.readData("file"));
    }

    @Test
    public void oneAnimalData() throws IOException {
        List<Animal> animal = Arrays.asList(new Animal("Dog", TypeAn.PREDATORS, 10,  Arrays.asList(new Food("Meat",5))));
        Serializable.recordData(animal, "fileOne");
        assertEquals(animal,Serializable.readData("fileOne"));
    }

    @Test
    public void twoAnimalsData() throws IOException, ClassNotFoundException {
        List<Animal> animal1 = Arrays.asList(new Animal("Rabbit", TypeAn.HERBIVORES, 9,  Arrays.asList(new Food("Grass",5))));
        List<Animal> animal2 = Arrays.asList(new Animal("Rabbit2", TypeAn.HERBIVORES, 6,  Arrays.asList(new Food("Grass",6))));
        Serializable.recordData(animal1, "fileTwoData1");
        Serializable.recordData(animal2, "fileTwoData2");
        assertEquals(animal1, Serializable.readData("fileTwoData1"));
        assertNotEquals(animal1, Serializable.readData("fileTwoData2"));
        assertNotEquals( Serializable.readData("fileTwoData1"), Serializable.readData("fileTwoData2"));
    }
}