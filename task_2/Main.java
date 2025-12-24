import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // a. Створюємо екземпляр Student
        Address address = new Address("Main St", "10A");
        Student originalStudent = new Student("Ivan", "Ivanov", address);

        // b. Конвертуємо в JSON (Серіалізація)
        String json = gson.toJson(originalStudent);
        System.out.println("JSON representation: " + json);

        // c. Конвертуємо назад в об’єкт (Десеріалізація)
        Student deserializedStudent = gson.fromJson(json, Student.class);

        // d. Перевіряємо equals-ом
        boolean result = originalStudent.equals(deserializedStudent);
        System.out.println("Are objects equal? " + result); // Має бути true
    }
}