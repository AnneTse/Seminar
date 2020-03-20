import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

//    @Test
//    public void record() {
//    }

    @Test
    public void read() {
    }

    @Test
    public void equals() throws IOException, ClassNotFoundException {
        List<Animal> animal1 = Arrays.asList(new Animal("Cow", TypeAn.HERBIVORES, 10,  Arrays.asList(new Food("Трава",5))));
        List<Animal> animal2 = Arrays.asList(new Animal("Cow2", TypeAn.HERBIVORES, 15,  Arrays.asList(new Food("Трава",6))));
        Serializable.record(animal1, "file");
        Serializable.record(animal2, "file2");
        assertEquals(animal1, Serializable.read("file"));
        assertNotEquals(animal1, Serializable.read("file2"));
    }
}