import java.util.Map;

public class TurnstileView {
    public void printResult(boolean success, String message) {
        String prefix = success ? "[OK] Прохід дозволено" : "[REJECTED] Відмова";
        System.out.println(prefix + ": " + message);
    }

    public void printStats(int totalSuccess, int totalFail, Map<String, Integer> typeStats) {
        System.out.println("\n--- СТАТИСТИКА ТУРНІКЕТУ ---");
        System.out.println("Успішно: " + totalSuccess);
        System.out.println("Відмов: " + totalFail);
        System.out.println("Деталізація за типами:");
        typeStats.forEach((type, count) -> System.out.println(" - " + type + ": " + count));
    }
}