package model;

import java.util.GregorianCalendar;

public class Customer {
    private String clientNumber;
    private String lastName;
    private String[] firstName;
    private Boolean vip;
    private String accomptNumber;
    private String streetNumber;
    private String houseNumber;
    private String phoneNumber;
    private String gsm;
    private GregorianCalendar birthDate;
    private City city;

    public Customer() {
        firstName = new String[5];
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String[] firstName) {
        this.firstName = firstName;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public void setAccomptNumber(String accomptNumber) {
        this.accomptNumber = accomptNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
