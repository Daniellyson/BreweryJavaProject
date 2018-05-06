package exception;

public class GetCustomerException extends Exception {
    private Exception exception;

    public GetCustomerException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "Error during query of customer data (" + exception.getMessage() + ").";
    }
}