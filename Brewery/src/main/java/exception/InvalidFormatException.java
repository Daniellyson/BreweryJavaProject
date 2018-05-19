package exception;

public class InvalidFormatException extends Exception {
    private String variable, error;

    public InvalidFormatException(String variable, String erreur) {
        setVariable(variable);
        setError(erreur);
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return variable + " can not contains numbers (" + error + ")";
    }
}
