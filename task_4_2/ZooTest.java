public class ZooTest {
    public static void main(String[] args) {
        try {
            // Створюємо вольєри
            Cage<Lion> lionCage = new Cage<>(2);
            Cage<Ungulate> ungulateCage = new Cage<>(3);
            Cage<Bird> birdCage = new Cage<>(5);

            // Додаємо тварин
            lionCage.addAnimal(new Lion("Сімба"));
            ungulateCage.addAnimal(new Zebra("Марті"));
            ungulateCage.addAnimal(new Giraffe("Мелман"));
            birdCage.addAnimal(new Eagle("Зевс"));

            // Робота з класом Zoo
            Zoo myZoo = new Zoo();
            myZoo.addCage(lionCage);
            myZoo.addCage(ungulateCage);
            myZoo.addCage(birdCage);

            System.out.println("Всього тварин у зоопарку: " + myZoo.getCountOfAnimals());

            // Перевірка виключної ситуації при переповненні
            lionCage.addAnimal(new Lion("Муфаса"));
            try {
                lionCage.addAnimal(new Lion("Скар"));
            } catch (Exception e) {
                System.out.println("Очікувана помилка: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}