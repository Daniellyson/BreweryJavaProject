package model;

import java.util.GregorianCalendar;

public class Order {
    private String number;
    private GregorianCalendar creationDate;
    private GregorianCalendar targetDate;
    private Customer customer;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setTargetDate(GregorianCalendar targetDate) {
        this.targetDate = targetDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public GregorianCalendar getTargetDate() {
        return targetDate;
    }

    public Customer getCustomer() {
        return customer;
    }
}
