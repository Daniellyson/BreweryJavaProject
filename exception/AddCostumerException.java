package exception;

public class AddCostumerException extends Exception{
    private Exception exception;

    public AddCostumerException(Exception exception){
        this.exception = exception;
    }

    public String getMessage(){
        return "Error during the costumer data insertion (" + exception.getMessage() + ").";
    }
}