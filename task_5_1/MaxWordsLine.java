import java.io.*;
import java.util.*;

public class MaxWordsLine {
    public static void main(String[] args) {
        String fileName = "input.txt";
        List<String> maxLines = new ArrayList<>();
        int maxCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                // Використовуємо регулярний вираз \\s+, щоб врахувати будь-яку кількість пробілів
                String[] words = currentLine.trim().split("\\s+");
                
                // Перевірка на порожній рядок
                int currentCount = (currentLine.trim().isEmpty()) ? 0 : words.length;

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxLines.clear(); // Знайдено новий рекорд, очищуємо старі результати
                    maxLines.add(currentLine);
                } else if (currentCount == maxCount && maxCount > 0) {
                    maxLines.add(currentLine); // Рядок з такою ж кількістю слів
                }
            }

            if (maxLines.isEmpty()) {
                System.out.println("Файл порожній або не містить слів.");
            } else {
                System.out.println("Максимальна кількість слів: " + maxCount);
                System.out.println("Знайдено рядків: " + maxLines.size());
                System.out.println("--- Список рядків ---");
                for (String line : maxLines) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}