public class Main {
    public static void main(String[] args) {
        TurnstileView view = new TurnstileView();
        TurnstileController system = new TurnstileController(view);

        // 1. Випуск карток
        system.issuePass(new SkiPass(1, PassType.WORKING_DAYS, DurationType.FULL_DAY, 0, false));
        system.issuePass(new SkiPass(2, PassType.WEEKENDS, DurationType.UNLIMITED, 10, true));
        system.issuePass(new SkiPass(3, PassType.SEASON, DurationType.UNLIMITED, 0, false));

        // 2. Симуляція проходів
        system.checkPass(1); // OK
        system.checkPass(2); // OK (залишиться 9)
        
        system.blockPass(3);
        system.checkPass(3); // Denied (Blocked)
        
        system.checkPass(99); // Denied (Unknown)

        // 3. Звіт
        system.showStats();
    }
}