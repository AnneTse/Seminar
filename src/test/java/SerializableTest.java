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
        Serializable.record(animal, "file");
        assertEquals(animal, Serializable.read("file"));
        assertNotEquals(Collections.emptyList(), Serializable.read("file"));
    }
    @Test
    public void twoAnimals() throws IOException, ClassNotFoundException {
        List<Animal> animal1 = Arrays.asList(new Animal("Cow", TypeAn.HERBIVORES, 10,  Arrays.asList(new Food("Grass",5))));
        List<Animal> animal2 = Arrays.asList(new Animal("Cow2", TypeAn.HERBIVORES, 15,  Arrays.asList(new Food("Grass",6))));
        Serializable.record(animal1, "file1");
        Serializable.record(animal2, "file2");
        assertEquals(animal1, Serializable.read("file1"));
        assertNotEquals(animal1, Serializable.read("file2"));
        assertNotEquals( Serializable.read("file1"), Serializable.read("file2"));
    }

        @Test
    public void emptyData() throws IOException, ClassNotFoundException {
        Serializable.recordData(Collections.emptyList(), "file");
        assertEquals(Collections.emptyList(), Serializable.readData("file"));
    }

    @Test
    public void oneAnimalData() throws IOException {
        List<Animal> animal = Arrays.asList(new Animal("Dog", TypeAn.PREDATORS, 10,  Arrays.asList(new Food("Meat",5))));
        Serializable.recordData(animal, "test");
        assertEquals(animal,Serializable.readData("test"));
    }

    @Test
    public void twoAnimalsData() throws IOException, ClassNotFoundException {
        List<Animal> animal1 = Arrays.asList(new Animal("Rabbit", TypeAn.HERBIVORES, 9,  Arrays.asList(new Food("Grass",5))));
        List<Animal> animal2 = Arrays.asList(new Animal("Rabbit2", TypeAn.HERBIVORES, 6,  Arrays.asList(new Food("Grass",6))));
        Serializable.recordData(animal1, "file1");
        Serializable.recordData(animal2, "file2");
        assertEquals(animal1, Serializable.readData("file1"));
        assertNotEquals(animal1, Serializable.readData("file2"));
        assertNotEquals( Serializable.readData("file1"), Serializable.readData("file2"));
    }
}