import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Animal implements Serializable {
    private final String  name;
    private TypeAn typeAn;
    private int age;
    private List<Food> food;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + typeAn +
                ", age=" + age +
                ", food=" + food +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                Objects.equals(typeAn, animal.typeAn) &&
                Objects.equals(food, animal.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeAn, age, food);
    }

    public String getName() {
        return name;
    }

    public TypeAn getType() {
        return typeAn;
    }

    public int getAge() {
        return age;
    }

    public List<Food> getFood() {
        return food;
    }

    public Animal(String name, TypeAn typeAn, int age, List<Food> food) {
        this.name = name;
        this.typeAn = typeAn;
        this.age = age;
        this.food = food;
    }
}