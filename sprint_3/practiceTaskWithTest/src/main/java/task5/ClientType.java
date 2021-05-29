package task5;

public enum ClientType {

    NEW(1),
    SILVER(12),
    GOLD(30),
    PLATINUM (60);

    private int months;

    ClientType(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }

    public double discount() {
        switch (this) {
            case SILVER: return ((100 - this.getMonths() * 0.25) / 100);
            case GOLD: return ((100 - this.getMonths() * 0.3) / 100);
            case PLATINUM: return ((100 - this.getMonths() * 0.35) / 100);
            default: return 1.0;
        }
    }
}
