import java.util.*;
import java.io.Serializable;

public class Cage<T extends Animal> implements Serializable {
    private int maxCapacity;
    private List<T> animals = new ArrayList<>();

    public Cage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addAnimal(T animal) throws Exception {
        if (animals.size() >= maxCapacity) {
            throw new Exception("Вольєр переповнений!");
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) throws Exception {
        if (!animals.contains(animal)) {
            throw new Exception("Цієї тварини немає у вольєрі!");
        }
        animals.remove(animal);
    }

    public int getMaxCapacity() { return maxCapacity; }
    public int getOccupiedPlaces() { return animals.size(); }
    public List<T> getAnimals() { return animals; }
}