package task5;

public class InsufficientAmountException extends RuntimeException {
    private double amount;

    public InsufficientAmountException(double amount){
        super("Sorry, but you are short $" + amount);
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public double getAmount(){
        return amount;
    }
}
