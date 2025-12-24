import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinUniqueApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введіть рядок зі слів:");
        String input = scanner.nextLine();
        
        String[] words = input.trim().split("\\s+");
        
        if (words.length == 0 || input.isEmpty()) {
            System.out.println("Слів не знайдено.");
            return;
        }

        String resultWord = words[0];
        int minUniqueCount = countUniqueChars(resultWord);

        for (int i = 1; i < words.length; i++) {
            int currentUniqueCount = countUniqueChars(words[i]);
            if (currentUniqueCount < minUniqueCount) {
                minUniqueCount = currentUniqueCount;
                resultWord = words[i];
            }
        }

        System.out.println("Слово з мінімальною кількістю різних символів: " + resultWord);
        System.out.println("Кількість унікальних символів: " + minUniqueCount);
    }

 
    private static int countUniqueChars(String word) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}
