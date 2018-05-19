package exception;

public class GetDataException extends Exception {
    private Exception exception;

    public GetDataException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "Error during query of customer data (" + exception.getMessage() + ").";
    }
}