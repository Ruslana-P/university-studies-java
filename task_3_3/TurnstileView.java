import java.util.Map;

public class TurnstileView {
    public void printAccessGranted(SkiPass pass) {
        System.out.println(">>> ПРОХІД ДОЗВОЛЕНО [ID:" + pass.getId() + "]");
    }

    public void printAccessDenied(SkiPass pass, String reason) {
        System.out.println("!!! ПРОХІД ЗАБОРОНЕНО [ID:" + (pass != null ? pass.getId() : "Unknown") + "]. Причина: " + reason);
    }

    public void printStatistics(int granted, int denied, Map<PassType, Integer> stats) {
        System.out.println("\n--- СТАТИСТИКА ТУРНІКЕТУ ---");
        System.out.println("Успішних проходів: " + granted);
        System.out.println("Відмов: " + denied);
        stats.forEach((type, count) -> System.out.println(type + ": " + count));
    }
}