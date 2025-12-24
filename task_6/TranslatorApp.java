import java.util.HashMap;
import java.util.Scanner;

public class TranslatorApp {
    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scanner = new Scanner(System.in);

        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("java", "джава");
        translator.addWord("is", "це");
        translator.addWord("great", "чудово");

        System.out.println("--- Програма-перекладач ---");
        
        System.out.print("Бажаєте додати слово у словник? (так/ні): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("так")) {
            System.out.print("Введіть англійське слово: ");
            String eng = scanner.nextLine();
            System.out.print("Введіть український переклад: ");
            String ukr = scanner.nextLine();
            translator.addWord(eng, ukr);
        }

        System.out.println("\nВведіть фразу англійською для перекладу (наприклад: hello world):");
        String input = scanner.nextLine();
        
        String translation = translator.translate(input);
        System.out.println("Результат перекладу: " + translation);
    }
}

class Translator {
    private HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase().trim(), ukrainian.toLowerCase().trim());
    }

    public String translate(String phrase) {
        if (phrase == null || phrase.isEmpty()) return "";
        
        String[] words = phrase.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");
            
            String translated = dictionary.get(cleanWord);
            if (translated != null) {
                result.append(translated).append(" ");
            } else {
                result.append("[").append(word).append("] ");
            }
        }
        return result.toString().trim();
    }
}