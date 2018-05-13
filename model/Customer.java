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


    //TODO dany test
    private GregorianCalendar dateOfBirth;
    public Customer(
            String nationalRegistrationNumber,
            String lastName,
            String[] firstNames,
            String accountNumber,
            Boolean vip,
            String streetName,
            String houseNumber,
            String landlinePhone,
            String mobilePhone,
            Integer day,
            Integer month,
            Integer year,
            Integer cityCode,
            Integer postCode,
            String cityName) throws NullException, InvalidFormatException {

        setNationalRegistrationNumber(nationalRegistrationNumber);
        setLastName(lastName);
        setFirstNames(firstNames);
                /*firstNames[0],
                firstNames[1],
                firstNames[2],*/
        setAccountNumber(accountNumber);
        setVip(vip);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
        setLandlinePhone(landlinePhone);
        setMobilePhone(mobilePhone);
        setBirthDate(year, month, day);
        setCity(cityCode, postCode, cityName);

    }
    public Customer(Integer idCustomer,
            String nationalRegistrationNumber,
            String lastName,
            String[] firstNames,
            String accountNumber,
            Boolean vip,
            String streetName,
            String houseNumber,
            String landlinePhone,
            String mobilePhone,
            Integer day,
            Integer month,
            Integer year,
            Integer cityCode,
            Integer postCode,
            String cityName) throws NullException, InvalidFormatException {

        setCustomerNumber(idCustomer);
        setNationalRegistrationNumber(nationalRegistrationNumber);
        setLastName(lastName);
        setFirstNames(firstNames);
        setAccountNumber(accountNumber);
        setVip(vip);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
        setLandlinePhone(landlinePhone);
        setMobilePhone(mobilePhone);
        setBirthDate(year, month, day);
        setCity(cityCode, postCode, cityName);

    }



    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }




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
                    Integer cityCode,
                    Integer postalCode,
                    String cityName) throws NullException, InvalidFormatException {
        this(customerNumber,
                nationalRegistrationNumber,
                lastName,
                firstNames[0],
                firstNames[1],
                firstNames[2],
                accountNumber,
                false,
                streetName,
                houseNumber,
                landlinePhone,
                mobilePhone,
                year,
                month,
                day,
                cityCode,
                postalCode,
                cityName);
    }

    public Customer(Integer customerNumber,
                    String nationalRegistrationNumber,
                    String lastName,
                    String firstName1,
                    String firstName2,
                    String firstName3,
                    String accountNumber,
                    Boolean vip,
                    String streetName,
                    String houseNumber,
                    String mobilePhone,
                    String landlinePhone,
                    Integer year,
                    Integer month,
                    Integer day,
                    Integer cityCode,
                    Integer postalCode,
                    String cityName) throws NullException, InvalidFormatException {
        setCustomerNumber(customerNumber);
        setNationalRegistrationNumber(nationalRegistrationNumber);
        setLastName(lastName);
        setFirstNames(firstName1, firstName2, firstName3);
        setAccountNumber(accountNumber);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
        setLandlinePhone(landlinePhone);
        setMobilePhone(mobilePhone);
        setCity(cityCode, postalCode, cityName);
        setVip(vip);
        setBirthDate(year, month, day);
    }



    public Customer(Integer customerNumber,
                    String nationalRegistrationNumber,
                    String lastName,
                    String firstName,
                    String accountNumber,
                    Boolean vip,
                    String streetName,
                    String houseNumber,
                    GregorianCalendar birthDate,
                    Integer cityCode,
                    Integer postCode,
                    String cityName) throws NullException, InvalidFormatException {
        this(customerNumber,
                nationalRegistrationNumber,
                lastName,
                firstName,
                null,
                null,
                accountNumber,
                vip,
                streetName,
                houseNumber,
                null,
                null,
                birthDate,
                cityCode,
                postCode,
                cityName);
    }

    public Customer(Integer customerNumber,
                    String nationalRegistrationNumber,
                    String lastName,
                    String firstName1,
                    String firstName2,
                    String firstName3,
                    String accountNumber,
                    Boolean vip,
                    String streetName,
                    String houseNumber,
                    String mobilePhone,
                    String landlinePhone,
                    GregorianCalendar birthDate,
                    Integer codeVille,
                    Integer postCode,
                    String cityName) throws NullException, InvalidFormatException{
        this(customerNumber,
                nationalRegistrationNumber,
                lastName,
                firstName1,
                firstName2,
                firstName3,
                accountNumber,
                vip,
                streetName,
                houseNumber,
                mobilePhone,
                landlinePhone,
                birthDate.get(GregorianCalendar.YEAR),
                birthDate.get(GregorianCalendar.MONTH),
                birthDate.get(GregorianCalendar.DATE),
                codeVille,
                postCode,
                cityName);
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
                    Integer code,
                    Integer postalCode,
                    String cityName) throws NullException, InvalidFormatException {
        this(null,
                nationalRegistrationNumber,
                lastName,
                firstNames,
                accountNumber,
                streetName,
                houseNumber,
                landlinePhone,
                mobilePhone,
                year,
                month,
                day,
                code,
                postalCode,
                cityName);
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
        if (RegularExpression.test(lastName, "\\d+"))
            throw new InvalidFormatException("last name", lastName);
        this.lastName = lastName;
    }

    public void setFirstNames(String[] firstNames) throws NullException, InvalidFormatException {

        for (int i = 0; i < firstNames.length; i++) {

            if (firstNames[i] == null) {
                if (i == 0) {
                    throw new NullException("first name");
                }
            } else {
                if (RegularExpression.test(firstNames[i],"\\d+")) {
                    throw new InvalidFormatException("first name", firstNames[i]);
                }
            }
        }
        this.firstNames = firstNames;
    }

    public void setFirstNames(String firstName1, String firstName2, String firstName3)throws NullException, InvalidFormatException {
        setFirstNames(new String[]{firstName1, firstName2, firstName3});
    }

    public void addFirstName(String firstName) throws InvalidFormatException {
        int i = 1;

        if (RegularExpression.test(firstName, "\\d+")) {
            throw new InvalidFormatException("first name", firstName);
        }

        while (i < firstNames.length && firstNames[i] != null) {
            i++;
        }

        if (i < firstNames.length) {
            firstNames[i] = firstName;
        }
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

    public void setCity(Integer cityCode, Integer postalCode, String cityName) throws NullException {
        setCity(new City(cityCode, postalCode, cityName));
    }

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

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFirstName(int i) {
        return firstNames[i];
    }

    public GregorianCalendar getBirthDate () {
        return birthDate;
    }


}