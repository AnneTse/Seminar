import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private final  String name;
    private int cout;

    public  Food(String name, int cout) {
        this.name = name;
        this.cout = cout;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", cout=" + cout +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return cout == food.cout &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cout);
    }

    public String getName() {
        return name;
    }

    public int getCout() {
        return cout;
    }
}

