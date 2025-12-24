import java.util.*;

public class TurnstileController {
    private List<SkiPass> registry = new ArrayList<>();
    private TurnstileView view;
    private int totalGranted = 0;
    private int totalDenied = 0;
    private Map<PassType, Integer> typeStats = new HashMap<>();

    public TurnstileController(TurnstileView view) {
        this.view = view;
    }

    public void issuePass(SkiPass pass) {
        registry.add(pass);
    }

    public void checkPass(int passId) {
        SkiPass pass = registry.stream().filter(p -> p.getId() == passId).findFirst().orElse(null);

        if (pass == null) {
            view.printAccessDenied(null, "Картка не знайдена в реєстрі");
            totalDenied++;
            return;
        }

        if (pass.isBlocked()) {
            view.printAccessDenied(pass, "Картка заблокована");
            totalDenied++;
        } else if (pass.isCountable() && pass.getLiftsRemaining() <= 0) {
            view.printAccessDenied(pass, "Немає кредитів");
            totalDenied++;
        } else {
            pass.useLift();
            view.printAccessGranted(pass);
            totalGranted++;
            typeStats.put(pass.getPassType(), typeStats.getOrDefault(pass.getPassType(), 0) + 1);
        }
    }

    public void blockPass(int id) {
        registry.stream().filter(p -> p.getId() == id).forEach(p -> p.setBlocked(true));
    }

    public void showStats() {
        view.printStatistics(totalGranted, totalDenied, typeStats);
    }
}