package exception;

public class AddCustomerException extends Exception{
    private Exception exception;

    public AddCustomerException(Exception exception){
        this.exception = exception;
    }

    public String getMessage(){
        return "Error during the customer data insertion (" + exception.getMessage() + ").";
    }
}