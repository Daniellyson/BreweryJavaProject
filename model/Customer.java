package model;

import exception.InvalidFormatException;
import exception.NullException;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String customerNumber;
    private String nationalRegistrationNumber;
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

    public Customer(String customerNumber,
                    String nationalRegistrationNumber,
                    String lastName,
                    String[] firstNames,
                    String accountNumber,
                    String streetName,
                    String houseNumber,
                    String landlinePhone,
                    String mobilePhone,
                    Integer year,
                    Integer month,
                    Integer day,
                    City city) throws NullException, InvalidFormatException {
        setCustomerNumber(customerNumber);
        setNationalRegistrationNumber(nationalRegistrationNumber);
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

    public Customer(String nationalRegistrationNumber,
                    String lastName,
                    String[] firstNames,
                    String accountNumber,
                    String streetName,
                    String houseNumber,
                    String landlinePhone,
                    String mobilePhone,
                    Integer year,
                    Integer month,
                    Integer day,
                    City city) throws NullException, InvalidFormatException {
        this(null, nationalRegistrationNumber, lastName, firstNames, accountNumber, streetName, houseNumber, landlinePhone, mobilePhone, year, month, day, city);
    }

     public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setNationalRegistrationNumber(String nationalRegistrationNumber) throws NullException {
        if (nationalRegistrationNumber.isEmpty())
            throw new NullException("register number");
        this.nationalRegistrationNumber = nationalRegistrationNumber;
    }

    public void setLastName(String lastName) throws NullException, InvalidFormatException {
        if (lastName.isEmpty())
            throw new NullException("last name");
        if (RegularExpression.test(lastName, "\\d?"))
            throw new InvalidFormatException("last name", lastName);
        this.lastName = lastName;
    }

    public void setFirstNames(String[] firstNames) throws NullException, InvalidFormatException {

        for (int i = 0; i < firstNames.length; i++) {
            if (firstNames[i].isEmpty()) {
                if (i == 0) {
                    throw new NullException("first name");
                }
            } else {
                if (RegularExpression.test(firstNames[i],"\\d?")) {
                    throw new InvalidFormatException("first name", firstNames[i]);
                }
            }
        }
        this.firstNames = firstNames;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public void setAccountNumber(String accountNumber) throws NullException {
        if (accountNumber.isEmpty())
            throw new NullException("account number");
        this.accountNumber = accountNumber;
    }

    public void setStreetName(String streetNumber) throws NullException, InvalidFormatException {
        if (streetNumber.isEmpty())
            throw new NullException("street name");
        this.streetName = streetNumber;
    }

    public void setHouseNumber(String houseNumber) throws NullException {
        if (houseNumber.isEmpty())
            throw new NullException("house number");
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

    public void setBirthDate(Integer year, Integer month, Integer day) throws NullException {
        if (year == null || month == null || day == null)
            throw new NullException("date of birth");
        setBirthDate(new GregorianCalendar(year, month, day));
    }

    public void setCity(City city) throws NullException {
        if (city == null)
            throw new NullException("city");
        this.city = city;
    }

    //TODO doing gets to AllCustomersModel
    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getNationalRegistrationNumber() {
        return nationalRegistrationNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String [] getFirstNames() {
        return firstNames;
    }

    public Boolean getVip() {
        return vip;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public City getCity() {
        return city;
    }
}
