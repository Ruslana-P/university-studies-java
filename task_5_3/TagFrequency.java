import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class TagFrequency {
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.google.com"; // URL на вибір
        URL url = new URL(urlString);
        Map<String, Integer> tagMap = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            // Регулярний вираз для пошуку назв тегів (напр. <div, <p)
            Pattern pattern = Pattern.compile("<([a-zA-Z1-6]+)");
            
            while ((inputLine = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
                    String tag = matcher.group(1).toLowerCase();
                    tagMap.put(tag, tagMap.getOrDefault(tag, 0) + 1);
                }
            }
        }

        // a) Сортування в лексикографічному порядку (за назвою)
        System.out.println("--- Лексикографічний порядок ---");
        tagMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // b) Сортування за частотою появи
        System.out.println("\n--- За частотою (зростання) ---");
        tagMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}