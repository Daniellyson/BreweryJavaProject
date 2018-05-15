package exception;

public class LengthException extends Exception {
    private String variable;
    private Integer length;

    public LengthException(String variable, Integer length) {
        this.variable = variable;
        this.length = length;
    }

    public String getMessage() {
        return "length Error : " + variable +" must contain "+ length+" characters";
    }
}
