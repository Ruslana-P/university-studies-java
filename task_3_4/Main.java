import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TurnstileView view = new TurnstileView();
        TurnstileController controller = new TurnstileController(view);

        // Підготовка дат
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        Date future = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, -20);
        Date past = cal.getTime();

        // Випуск карток
        controller.registerCard(new Card("S1", CardCategory.SCHOOL, CardType.BY_TRIPS, 5, future));
        controller.registerCard(new Card("W1", 50.0)); // Накопичувальна
        controller.registerCard(new Card("O1", CardCategory.STANDARD, CardType.TEN_DAYS, 0, past));

        // Симуляція
        controller.processCard("S1"); // OK
        controller.processCard("W1"); // OK
        controller.processCard("O1"); // Fail (Expired)
        controller.processCard("X9"); // Fail (Not found)

        controller.showStats();
    }
}