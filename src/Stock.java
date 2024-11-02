public class Stock {
    private int amount;
    private int alertThreshold;

    public Stock(int amount, int alertThreshold) {
        this.amount = amount;
        this.alertThreshold = alertThreshold;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isLowStock() {
        return amount <= alertThreshold;
    }
}
