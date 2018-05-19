package exception;

public class PercentException extends Exception {
    private Integer totalAmount;
    private Integer amount;
    public PercentException(Integer totalAmount, Integer amount) {
        this.totalAmount = totalAmount;
        this.amount = amount;
    }
    public String getMessage() {
        return "total amount (" + totalAmount + ") or amount ("+ amount + ") is negative; null in percent calculation or amount is higher than total amount";
    }
}
