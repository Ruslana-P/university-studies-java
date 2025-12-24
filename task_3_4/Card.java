import java.util.Date;

enum CardCategory { SCHOOL, STUDENT, STANDARD }
enum CardType { MONTHLY, TEN_DAYS, BY_TRIPS, WALLET }

public class Card {
    private String id;
    private CardCategory category;
    private CardType type;
    private int tripsRemaining;
    private double balance;
    private Date expiryDate;

    public Card(String id, CardCategory category, CardType type, int trips, Date expiry) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.tripsRemaining = trips;
        this.expiryDate = expiry;
    }

    public Card(String id, double initialBalance) {
        this.id = id;
        this.category = CardCategory.STANDARD;
        this.type = CardType.WALLET;
        this.balance = initialBalance;
    }

    public String getId() { return id; }
    public CardCategory getCategory() { return category; }
    public CardType getType() { return type; }
    public int getTripsRemaining() { return tripsRemaining; }
    public double getBalance() { return balance; }
    public Date getExpiryDate() { return expiryDate; }

    public void setTripsRemaining(int trips) { this.tripsRemaining = trips; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("ID:%s | %s | %s", id, category, type);
    }
}