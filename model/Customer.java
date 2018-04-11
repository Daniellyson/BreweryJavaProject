package model;

import java.util.GregorianCalendar;

public class Customer {
    private String customerNumber; //we must find a process for the creation
    private String registerNumber;
    private String lastName;
    private String[] firstNames = new String[3];
    private Boolean vip;
    private String accountNumber;
    private String streetName;
    private String houseNumber;
    private String landlinePhone;
    private String mobilePhone;
    private GregorianCalendar birthDate;
    private City city;

    public Customer(String registerNumber, String lastName, String[] firstNames, String accountNumber, String streetName, String houseNumber, String landlinePhone, String mobilePhone, Integer year, Integer month, Integer day, City city) {
        setRegisterNumber(registerNumber);
        setLastName(lastName);
        setFirstNames(firstNames);
        setAccountNumber(accountNumber);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
        setLandlinePhone(landlinePhone);
        setMobilePhone(mobilePhone);
        setCity(city);
        setVip(false);
        setBirthDate(year, month, day);
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setRegisterNumber(String registerNumber) { this.registerNumber = registerNumber; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstNames(String[] firstNames) {
        this.firstNames = firstNames;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setStreetName(String streetNumber) {
        this.streetName = streetNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(Integer year, Integer month, Integer day) {
        setBirthDate(new GregorianCalendar(year, month, day));
    }

    public void setCity(City city) {
        this.city = city;
    }
}
