import java.io.*;
import java.util.List;

public class ZooManager {
    public static void saveAnimalsToFile(List<Animal> animals, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(animals);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Animal> loadAnimalsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Animal>) ois.readObject();
        }
    }
}