package exception;

import view.DeleteCustomer;

public class DeleteCustomerException extends Exception {
    private Exception excetpion;

    public DeleteCustomerException(Exception exception) {
        this.excetpion = exception;
    }

    public String getMessage() {
        return "error delete customer ("+excetpion.getMessage()+")";
    }
}
