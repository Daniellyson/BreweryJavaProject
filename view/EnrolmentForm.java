package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;
import model.City;
import model.Customer;
import model.RegularExpression;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class EnrolmentForm  extends JPanel {
    private JPanel choicePanel;
    private JPanel formPanel;
    private JPanel buttonPanel;

    private ButtonGroup enrolomentButtonGroup;
    private JRadioButton newCustomer;
    private JRadioButton editCustomer;

    private JLabel requiredField;

    private JLabel nationalRegistrationNumberLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel accountNumberLabel;
    private JLabel streetLabel;
    private JLabel houseNumberLabel;

    private JLabel cityLabel;
    private JLabel postCodeLabel;

    private JLabel mobilePhoneLabel;
    private JLabel landlinePhoneLabel;

    //MORE THAN ONE FIRST NAME (not obligatory)
    private JCheckBox hasSecondFirstName;
    private JTextField firstName_2;
    private JCheckBox hasThirdFirstName;
    private JTextField firstName_3;


    private JTextField nationalRegistrationNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField accountNumber;
    private JTextField street;
    private JTextField houseNumber;

    private JSpinner spinnerDateOfBirth;
    private Date valueDate;
    private String dateString;

    private JComboBox listCities;
    private JTextField postCode;

    private JTextField mobilePhone;
    private JTextField landlinePhone;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JTextField> fields = new ArrayList<>();
    private ArrayList<JTextField> fieldsNotNull = new ArrayList<>();

    private JCheckBox isVIP;

    private JButton returnButton;
    private JButton validationButton;
    private JButton resetButton;

    private ApplicationController controller;

    private Integer comboBoxCitiesSize;
    private String [] citiesComboBox;

    private JLabel customerLabel;
    private JComboBox listCustomers;
    private String [] customerComboBox;
    private boolean listingCustomerIsEnable;

    private JButton buttonGetAllCustomerInfo;

    ArrayList<Customer> customers;


    public EnrolmentForm(ActionReturnButton actionReturnButton, ApplicationController controller) {

        this.controller = controller;

        setLayout(new BorderLayout());

        choicePanel = new JPanel(new GridLayout(2, 2, 10, 7));
        add(choicePanel, BorderLayout.NORTH);

        formPanel = new JPanel(new GridLayout(15, 2, 10, 8));
        add(formPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        add(buttonPanel, BorderLayout.PAGE_END);


        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();
        ActionRadioBox actionRadioBox = new ActionRadioBox();


        newCustomer = new JRadioButton("New customer");
        choicePanel.add(newCustomer);
        newCustomer.addItemListener(actionRadioBox);

        editCustomer = new JRadioButton("Edit customer");
        choicePanel.add(editCustomer);
        editCustomer.addItemListener(actionRadioBox);

        //Only one radio button at once
        enrolomentButtonGroup = new ButtonGroup();
        enrolomentButtonGroup.add(newCustomer);
        enrolomentButtonGroup.add(editCustomer);

        //TODO here EDIT

        customerLabel = new JLabel("*Customer:");
        customerLabel.setHorizontalAlignment(JLabel.RIGHT);
        choicePanel.add(customerLabel);
        labels.add(customerLabel);
        customerLabel.setEnabled(false);

        listCustomers = new JComboBox();
        choicePanel.add(listCustomers);
        listCustomers.setEnabled(false);
        listingCustomerIsEnable = false;

        requiredField = new JLabel("(*) Required Field");
        requiredField.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(requiredField);

        buttonGetAllCustomerInfo = new JButton("Get all information");
        formPanel.add(buttonGetAllCustomerInfo);
        buttonGetAllCustomerInfo.addActionListener(buttonsActionListener);


        //FORM PANEL

        nationalRegistrationNumberLabel = new JLabel("*National Registration Number: ");
        nationalRegistrationNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(nationalRegistrationNumberLabel);
        nationalRegistrationNumber = new JTextField();
        formPanel.add(nationalRegistrationNumber);

        labels.add(nationalRegistrationNumberLabel);
        fields.add(nationalRegistrationNumber);
        fieldsNotNull.add(nationalRegistrationNumber);

        nationalRegistrationNumberLabel.setEnabled(false);
        nationalRegistrationNumber.setEnabled(false);


        firstNameLabel = new JLabel("*First name:");
        firstNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(firstNameLabel);
        firstName = new JTextField();
        formPanel.add(firstName);

        labels.add(firstNameLabel);
        fields.add(firstName);
        fieldsNotNull.add(firstName);

        firstNameLabel.setEnabled(false);
        firstName.setEnabled(false);

        //MORE THAN ONE FIRST NAME (not obligatory)
        ActionCheckBox actionCheckBox = new ActionCheckBox();

        hasSecondFirstName = new JCheckBox("Seconde first name:");
        hasSecondFirstName.setHorizontalAlignment(JCheckBox.RIGHT);
        formPanel.add(hasSecondFirstName);
        hasSecondFirstName.setEnabled(false);
        hasSecondFirstName.addItemListener(actionCheckBox);
        firstName_2 = new JTextField();
        formPanel.add(firstName_2);
        firstName_2.setEnabled(false);

        fields.add(firstName_2);

        hasThirdFirstName = new JCheckBox("Third first name:");
        hasThirdFirstName.setHorizontalAlignment(JCheckBox.RIGHT);
        formPanel.add(hasThirdFirstName);
        hasThirdFirstName.setEnabled(false);
        hasThirdFirstName.addItemListener(actionCheckBox);
        firstName_3 = new JTextField();
        formPanel.add(firstName_3);
        firstName_3.setEnabled(false);

        fields.add(firstName_3);

        lastNameLabel = new JLabel("*Last name:");
        lastNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(lastNameLabel);
        lastName = new JTextField();
        formPanel.add(lastName);

        labels.add(lastNameLabel);
        fields.add(lastName);
        fieldsNotNull.add(lastName);

        lastNameLabel.setEnabled(false);
        lastName.setEnabled(false);


        spinnerDateOfBirth = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEdit = new JSpinner.DateEditor(spinnerDateOfBirth,"dd/MM/yyyy");
        spinnerDateOfBirth.setEditor(dateEdit);

        dateOfBirthLabel = new JLabel("*Date of birth:");
        dateOfBirthLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(dateOfBirthLabel);

        formPanel.add(spinnerDateOfBirth);
        spinnerDateOfBirth.setEnabled(false);

        labels.add(dateOfBirthLabel);
        dateOfBirthLabel.setEnabled(false);


        accountNumberLabel = new JLabel("*Account Number:");
        accountNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(accountNumberLabel);
        accountNumber = new JTextField();
        formPanel.add(accountNumber);

        labels.add(accountNumberLabel);
        fields.add(accountNumber);
        fieldsNotNull.add(accountNumber);

        accountNumberLabel.setEnabled(false);
        accountNumber.setEnabled(false);


        isVIP = new JCheckBox("VIP");
        isVIP.setHorizontalAlignment(JCheckBox.RIGHT);
        formPanel.add(isVIP);
        isVIP.setEnabled(false);
        formPanel.add(new JLabel(""));


        //ADRESSE
        streetLabel = new JLabel("*Street:");
        streetLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(streetLabel);
        street = new JTextField();
        formPanel.add(street);

        labels.add(streetLabel);
        fields.add(street);
        fieldsNotNull.add(street);

        streetLabel.setEnabled(false);
        street.setEnabled(false);


        houseNumberLabel = new JLabel("*House number:");
        houseNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(houseNumberLabel);
        houseNumber = new JTextField();
        formPanel.add(houseNumber);

        labels.add(houseNumberLabel);
        fields.add(houseNumber);
        fieldsNotNull.add(houseNumber);

        houseNumberLabel.setEnabled(false);
        houseNumber.setEnabled(false);


        postCodeLabel = new JLabel("*PostCode (After typing, press ENTER):");
        postCodeLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(postCodeLabel);
        postCode = new JTextField();
        formPanel.add(postCode);

        labels.add(postCodeLabel);
        fields.add(postCode);
        fieldsNotNull.add(postCode);

        postCodeLabel.setEnabled(false);
        postCode.setEnabled(false);

        postCode.addActionListener(new ActionPostCode());

        cityLabel = new JLabel("*City:");
        cityLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(cityLabel);

        listCities = new JComboBox();
        formPanel.add(listCities);


        labels.add(cityLabel);
        cityLabel.setEnabled(false);
        listCities.setEnabled(false);


        //PHONES
        mobilePhoneLabel = new JLabel("Mobile phone:");
        mobilePhoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(mobilePhoneLabel);
        mobilePhone = new JTextField();
        formPanel.add(mobilePhone);

        labels.add(mobilePhoneLabel);
        fields.add(mobilePhone);

        mobilePhoneLabel.setEnabled(false);
        mobilePhone.setEnabled(false);

        landlinePhoneLabel = new JLabel("Landline phone:");
        landlinePhoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(landlinePhoneLabel);
        landlinePhone = new JTextField();
        formPanel.add(landlinePhone);

        labels.add(landlinePhoneLabel);
        fields.add(landlinePhone);

        landlinePhoneLabel.setEnabled(false);
        landlinePhone.setEnabled(false);


        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.addActionListener(actionReturnButton);

        validationButton = new JButton("Validation");
        buttonPanel.add(validationButton);
        validationButton.addActionListener(buttonsActionListener);

        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        resetButton.addActionListener(buttonsActionListener);

    }

    public void resetFields() {
        for (JTextField field : fields) {
            field.setText(null);
            field.setBackground(Color.WHITE);
        }

        hasSecondFirstName.setSelected(false);
        hasThirdFirstName.setSelected(false);
        hasThirdFirstName.setEnabled(false);
        firstName_2.setEnabled(false);
        firstName_3.setEnabled(false);

    }

    public void setFieldsEnable(boolean enabled) {

        for (JTextField field : fields) {
            field.setEnabled(enabled);
        }
        for (JLabel label : labels) {
            label.setEnabled(enabled);
        }
        hasSecondFirstName.setEnabled(enabled);
        spinnerDateOfBirth.setEnabled(enabled);
        listCities.setEnabled(enabled);

    }

    private class ActionCheckBox implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == hasSecondFirstName) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    firstName_2.setEnabled(true);
                    hasThirdFirstName.setEnabled(true);
                    if (hasThirdFirstName.isSelected()) {
                        firstName_3.setEnabled(true);
                    }
                } else {
                    firstName_2.setEnabled(false);
                    firstName_2.setText(null);
                    if (hasThirdFirstName.isSelected()) {
                        firstName_3.setEnabled(false);
                        firstName_3.setText(null);
                        hasThirdFirstName.setSelected(false);
                        hasThirdFirstName.setEnabled(false);
                    }
                }
            }
            if (event.getSource() == hasThirdFirstName) {
                if (event.getStateChange() == ItemEvent.SELECTED && firstName_2.isEnabled()) {
                    firstName_3.setEnabled(true);
                } else {
                    firstName_3.setEnabled(false);
                    firstName_3.setText(null);
                }
            }
        }
    }

    private class ActionPostCode implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == postCode) {
                City city;
                boolean correctPostCode = true;
                Integer postalCodeNumber = null;
                String postalCode = postCode.getText();

                try {
                    postalCodeNumber = Integer.parseInt(postalCode);
                } catch (NumberFormatException exception) {
                    correctPostCode = false;
                    JOptionPane.showMessageDialog(null, "POSTCODE must be a number.",
                            "Information", JOptionPane.INFORMATION_MESSAGE);
                }

                if(correctPostCode) {
                    ArrayList<City> cities = new ArrayList<>();
                    try {
                        cities = controller.getAllCities(postalCodeNumber);
                    } catch (GetCustomerException e) {
                        e.printStackTrace();
                    }

                    Iterator<City> listingCities = cities.iterator();

                    comboBoxCitiesSize = cities.size();

                    citiesComboBox = new String[comboBoxCitiesSize];

                    listCities.removeAllItems();

                    if(cities.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "POSTCODE must be from Belgium.",
                                "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        int i = 0;
                        while (listingCities.hasNext()) {
                            city = listingCities.next();
                            citiesComboBox[i] = city.getName();
                            listCities.addItem(citiesComboBox[i]);
                            i++;
                        }
                    }
                }

            }
        }
    }

    private class ActionRadioBox implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == editCustomer) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    listCustomers.setEnabled(true);
                    customerLabel.setEnabled(true);
                    listingCustomerIsEnable = true;

                    Customer customer;
                    String customerId;
                    String customerLastName;
                    String customerFirstName;

                    customers = new ArrayList<>();
                    try {
                        customers = controller.getAllCustomers();
                    } catch (GetCustomerException e) {
                        e.printStackTrace();
                    }

                    Iterator<Customer> listingCustomers = customers.iterator();

                    customerComboBox = new String[customers.size()];

                    int i = 0;
                    while(listingCustomers.hasNext()) {
                        customer = listingCustomers.next();

                        customerId = customer.getCustomerNumber().toString();
                        customerLastName = customer.getLastName();
                        customerFirstName = customer.getFirstName(0);

                        customerComboBox[i] = customerId + " " + customerLastName + " " + customerFirstName;
                        listCustomers.addItem(customerComboBox[i]);
                        i++;
                    }

                } else {
                    listCustomers.setEnabled(false);
                    customerLabel.setEnabled(false);
                    listingCustomerIsEnable = false;
                }
            }
            if (event.getSource() == newCustomer) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    setFieldsEnable(true);
                    listCustomers.setEnabled(false);
                    customerLabel.setEnabled(false);
                    listingCustomerIsEnable = false;
                    listCustomers.removeAllItems();
                    isVIP.setSelected(false);
                } else {
                    setFieldsEnable(false);
                    listCities.removeAllItems();
                }
            }
            resetFields();
        }
    }

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == validationButton) {
                if (newCustomer.isSelected()) {
                    String errorMessage = "";
                    boolean error = false;
                    Customer customer;
                    Integer postalCodeNumber = null;
                    Integer birthDateNumber = null;
                    boolean blank = false;
                    String registerNumber = nationalRegistrationNumber.getText();
                    String[] firstNames = new String[3];
                    String lastNameCustomer = lastName.getText();

                    valueDate = (Date) spinnerDateOfBirth.getValue();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
                    dateString = simpleDateFormat.format(valueDate);


                    String accountNumberCustomer = accountNumber.getText();
                    String streetName = street.getText();
                    String houseNumberCustomer = houseNumber.getText();
                    String cityName = null;
                    if(listCities.getSelectedItem() == null) {
                        blank = true;
                    } else {
                        cityName = listCities.getSelectedItem().toString();
                    }

                    String postalCode = postCode.getText();
                    String mobilePhoneCustomer = mobilePhone.getText();
                    String landlinePhoneCustomer = landlinePhone.getText();


                    firstNames[0] = firstName.getText();
                    firstNames[1] = firstName_2.getText();
                    firstNames[2] = firstName_3.getText();

                    for (JTextField field : fieldsNotNull) {
                        if (field.getText().isEmpty()) {
                            field.setBackground(Color.RED);
                            blank = true;
                        } else {
                            field.setBackground(Color.WHITE);
                        }
                    }
                    if (blank) {
                        JOptionPane.showMessageDialog(null, "field in red can't be blank");
                    } else {

                        if (RegularExpression.test(lastNameCustomer, "\\d+")) {
                            errorMessage += "last name can't contain number\n";
                            error = true;
                        }

                        if (RegularExpression.test(firstNames[0], "\\d+")) {
                            errorMessage += "first first name can't contain number\n";
                            error = true;
                        }

                        for (int i = 1; i < firstNames.length; i++) {
                            if (!firstNames[i].isEmpty()) {
                                if (RegularExpression.test(firstNames[i], "\\d+"))
                                    errorMessage += "first name "+i+" can't contain number\n";
                                error = true;
                            }
                        }

                        try {
                            birthDateNumber = Integer.parseInt(dateString);
                        } catch (NumberFormatException exception) {
                            errorMessage += "birth date must be a number\n";
                            error = true;
                        }

                        try {
                            postalCodeNumber = Integer.parseInt(postalCode);
                        } catch (NumberFormatException exception) {
                            errorMessage += "postal code must be a number\n";
                        }

                        if (error) {
                            JOptionPane.showMessageDialog(null, errorMessage);
                        } else {
                            try {
                                customer = new Customer(registerNumber,
                                        lastNameCustomer,
                                        firstNames,
                                        accountNumberCustomer,
                                        streetName,
                                        houseNumberCustomer,
                                        landlinePhoneCustomer,
                                        mobilePhoneCustomer,
                                        birthDateNumber % 10000,
                                        (birthDateNumber / 10000) % 100,
                                        birthDateNumber / 1000000,
                                        postalCodeNumber,
                                        cityName);
                                controller.addCustomer(customer);
                                resetFields();
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, exception.getMessage());
                            }
                        }

                    }
                }
            }

            if (event.getSource() == resetButton) {
                resetFields();
            }

            if (event.getSource() == buttonGetAllCustomerInfo) {

                if(listingCustomerIsEnable) {
                    nationalRegistrationNumber.setText(customers.get(listCustomers.getSelectedIndex()).getNationalRegistrationNumber());
                    firstName.setText(customers.get(listCustomers.getSelectedIndex()).getFirstName(0));

                    if(customers.get(listCustomers.getSelectedIndex()).getFirstName(1) != null) {
                        hasSecondFirstName.setEnabled(true);
                        hasSecondFirstName.setSelected(true);
                        firstName_2.setText(customers.get(listCustomers.getSelectedIndex()).getFirstName(1));
                    }
                    else {
                        hasSecondFirstName.setEnabled(false);
                        hasSecondFirstName.setSelected(false);
                    }

                    if(customers.get(listCustomers.getSelectedIndex()).getFirstName(2) != null) {
                       hasThirdFirstName.setEnabled(true);
                       hasThirdFirstName.setSelected(true);
                        firstName_3.setText(customers.get(listCustomers.getSelectedIndex()).getFirstName(2));
                    }
                    else {
                        hasThirdFirstName.setEnabled(false);
                        hasThirdFirstName.setSelected(false);
                    }

                    lastName.setText(customers.get(listCustomers.getSelectedIndex()).getLastName());
                    accountNumber.setText(customers.get(listCustomers.getSelectedIndex()).getAccountNumber());
                    isVIP.setSelected(customers.get(listCustomers.getSelectedIndex()).getVip());
                    street.setText(customers.get(listCustomers.getSelectedIndex()).getStreetName());
                    houseNumber.setText(customers.get(listCustomers.getSelectedIndex()).getHouseNumber());
                    postCode.setText(customers.get(listCustomers.getSelectedIndex()).getCity().getPostCode().toString());
                    mobilePhone.setText(customers.get(listCustomers.getSelectedIndex()).getMobilePhone());
                    landlinePhone.setText(customers.get(listCustomers.getSelectedIndex()).getLandlinePhone());

                    setFieldsEnable(true);
                    spinnerDateOfBirth.setEnabled(false);
                    dateOfBirthLabel.setEnabled(false);
                }
            }
        }
    }
}