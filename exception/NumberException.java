package exception;

public class NumberException extends Exception {
    private String variable;

    public NumberException(String variable) {
        this.variable = variable;
    }


    public String getMessage() {
        return "Number Error : " + variable;
    }
}
