package exception;

public class NullException extends Exception {
    private String variable;

    public NullException(String variable) {
        setVariable(variable);
    }

    public String getMessage() {
        return variable + " not initialised";
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
