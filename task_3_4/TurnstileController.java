import java.util.*;

public class TurnstileController {
    private List<Card> registry = new ArrayList<>();
    private TurnstileView view;
    private int successCount = 0;
    private int failCount = 0;
    private Map<String, Integer> stats = new HashMap<>();
    private final double TICKET_PRICE = 8.0;

    public TurnstileController(TurnstileView view) {
        this.view = view;
    }

    public void registerCard(Card card) { registry.add(card); }

    public void processCard(String cardId) {
        Card card = registry.stream().filter(c -> c.getId().equals(cardId)).findFirst().orElse(null);
        
        if (card == null) {
            view.printResult(false, "Картка не знайдена");
            failCount++;
            return;
        }

        boolean canPass = false;
        Date now = new Date();

        if (card.getType() == CardType.WALLET) {
            if (card.getBalance() >= TICKET_PRICE) {
                card.setBalance(card.getBalance() - TICKET_PRICE);
                canPass = true;
            }
        } else if (card.getExpiryDate() != null && card.getExpiryDate().before(now)) {
            canPass = false;
        } else if (card.getType() == CardType.BY_TRIPS) {
            if (card.getTripsRemaining() > 0) {
                card.setTripsRemaining(card.getTripsRemaining() - 1);
                canPass = true;
            }
        } else {
            canPass = true; 
        }

        if (canPass) {
            view.printResult(true, card.toString());
            successCount++;
            String key = card.getCategory() + "_" + card.getType();
            stats.put(key, stats.getOrDefault(key, 0) + 1);
        } else {
            view.printResult(false, "Недостатньо коштів/поїздок або термін вичерпано");
            failCount++;
        }
    }

    public void showStats() {
        view.printStats(successCount, failCount, stats);
    }
}