import java.util.*;

enum PassType {
    WORKING_DAYS, WEEKENDS, SEASON
}

enum DurationType {
    HALF_DAY_AM, HALF_DAY_PM, FULL_DAY, TWO_DAYS, FIVE_DAYS, UNLIMITED
}

public class SkiPass {
    private final int id;
    private final PassType passType;
    private final DurationType duration;
    private int liftsRemaining;
    private boolean isBlocked;
    private final boolean isCountable; 

    public SkiPass(int id, PassType type, DurationType duration, int lifts, boolean isCountable) {
        this.id = id;
        this.passType = type;
        this.duration = duration;
        this.liftsRemaining = lifts;
        this.isCountable = isCountable;
        this.isBlocked = false;
    }

    public int getId() { return id; }
    public PassType getPassType() { return passType; }
    public boolean isBlocked() { return isBlocked; }
    public void setBlocked(boolean blocked) { isBlocked = blocked; }
    public int getLiftsRemaining() { return liftsRemaining; }
    public boolean isCountable() { return isCountable; }

    public boolean useLift() {
        if (isCountable && liftsRemaining > 0) {
            liftsRemaining--;
            return true;
        }
        return !isCountable;
    }

    @Override
    public String toString() {
        return String.format("ID:%d | Тип:%s | Термін:%s | Залишок:%s | Блок:%b", 
            id, passType, duration, (isCountable ? liftsRemaining : "∞"), isBlocked);
    }
}