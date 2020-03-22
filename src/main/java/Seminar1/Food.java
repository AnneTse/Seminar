package Seminar1;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private final  String foodName;
    private int count;

    public  Food(String foodName, int count) {
        this.foodName = foodName;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + foodName + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return count == food.count &&
                Objects.equals(foodName, food.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, count);
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCount() {
        return count;
    }
}

