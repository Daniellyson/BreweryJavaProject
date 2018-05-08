package model;

import exception.InvalidFormatException;
import exception.NullException;

import javax.swing.text.StyledEditorKit;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private Integer customerNumber;
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


    //TODO testing data base
    private String firstName;
    private String firstName2;
    private String firstName3;
    private Integer cityCode;
    private Date dateBirth;
    private Integer postCode;
    private String name;

    public Customer(Integer customerNumber,
                    String nationalRegistrationNumber,
                    String lastName,
                    String firstName,
                    String firstName2,
                    String firstName3,
                    String accountNumber,
                    Boolean vip,
                    String streetName,
                    String houseNumber,
                    String landlinePhone,
                    String mobilePhone,
                    Date dateBirth,
                    Integer cityCode,
                    Integer postCode,
                    String name) throws NullException, InvalidFormatException {
        this.customerNumber = customerNumber;
        this.nationalRegistrationNumber = nationalRegistrationNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.firstName2 = firstName2;
        this.firstName3 = firstName3;
        this.accountNumber = accountNumber;
        this.vip = vip;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.landlinePhone = landlinePhone;
        this.mobilePhone = mobilePhone;
        this.dateBirth = dateBirth;
        this.cityCode = cityCode;
        this.postCode = postCode;
        this.name = name;

        //new City(cityCode, postCode, name);
        //System.out.println(cityCode + " " + postCode + " " + name);
        /*this.postCode = getPostCode();
        this.name = getName();*/
    }
    //TODO doing gets to AllCustomersModel
    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public String getNationalRegistrationNumber() {
        return nationalRegistrationNumber;
    }

    public String getLastName() {
        return lastName;
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

    public City getCity() {
        return city;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public String getName() {
        return name;
    }

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public String [] getFirstNames() {
        return firstNames;
    }

    public String getFirstName3() {
        return firstName3;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public GregorianCalendar getBirthDate () {
        return birthDate;
    }

    //TODO test unil here for CustomerDataBaseAccess

    public Customer(Integer customerNumber,
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

     public void setCustomerNumber(Integer customerNumber) {
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


}
