package exception;

public class GetCostumerException extends Exception {
    private Exception exception;

    public GetCostumerException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "Error during query of customer data (" + exception.getMessage() + ").";
    }
}