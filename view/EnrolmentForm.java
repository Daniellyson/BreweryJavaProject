package view;

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
import java.util.ArrayList;
import java.util.Date;

public class EnrolmentForm  extends JPanel {
    private JPanel choicePanel;
    private JPanel formPanel;
    private JPanel buttonPanel;

    private ButtonGroup enrolomentButtonGroup;
    private JRadioButton newCustomer;
    private JRadioButton editCustomer;

    private JLabel requiredField;
    private JLabel customerNumberLabel;
    private JTextField customerNumber;
    //TODO doing JComboBox
    private JComboBox customersBox;


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

    //TODO doing FSpinner
    private JSpinner spinnerDateOfBirth;
    private Date valueDate;
    private String dateString;


    private JTextField city;
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

    public EnrolmentForm(ActionReturnButton actionReturnButton) {

        setLayout(new BorderLayout());

        choicePanel = new JPanel(new GridLayout(2, 2, 10, 8));
        add(choicePanel, BorderLayout.NORTH);

        formPanel = new JPanel(new GridLayout(14, 2, 10, 10));
        add(formPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        //CHOICE PANEL

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


        //ActionCustomerIdNumber actionCustomerIdNumber = new ActionCustomerIdNumber();

        requiredField = new JLabel("(*) Required Field");
        requiredField.setHorizontalAlignment(JLabel.RIGHT);
        choicePanel.add(requiredField);
        choicePanel.add(new JLabel(""));
        /*customerNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        choicePanel.add(customerNumberLabel);

        //TODO JComboBox  maybe ?

        String [] customers = {"Jordan", "Daniellyson", "Marie"};
        customersBox = new JComboBox(customers);
        choicePanel.add(customersBox);


        customerNumberLabel.setEnabled(false);
        /*customerNumber.setEnabled(false);
        customerNumber.addActionListener(actionCustomerIdNumber);*/



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
        //END more than one first name


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


        //TODO doing FSpinner
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


        cityLabel = new JLabel("*City:");
        cityLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(cityLabel);
        city = new JTextField();
        formPanel.add(city);

        labels.add(cityLabel);
        fields.add(city);
        fieldsNotNull.add(city);

        cityLabel.setEnabled(false);
        city.setEnabled(false);


        postCodeLabel = new JLabel("*PostCode:");
        postCodeLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(postCodeLabel);
        postCode = new JTextField();
        formPanel.add(postCode);

        labels.add(postCodeLabel);
        fields.add(postCode);
        fieldsNotNull.add(postCode);

        postCodeLabel.setEnabled(false);
        postCode.setEnabled(false);


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


        //Buttons South
        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();

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
        //customerNumber.setText(null);
        hasSecondFirstName.setSelected(false);
        hasThirdFirstName.setSelected(false);
        hasThirdFirstName.setEnabled(false);
        firstName_2.setEnabled(false);
        firstName_3.setEnabled(false);

        //TODO doing FSpinner
        //spinnerDate
    }

    public void setFieldsEnable(boolean enabled) {

        for (JTextField field : fields) {
            field.setEnabled(enabled);
        }
        for (JLabel label : labels) {
            label.setEnabled(enabled);
        }
        hasSecondFirstName.setEnabled(enabled);

        //TODO doing FSpinner
        spinnerDateOfBirth.setEnabled(enabled);
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

    private class ActionRadioBox implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == editCustomer) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    //customerNumberLabel.setEnabled(true);
                    //customerNumber.setEnabled(true);
                } else {
                    //customerNumberLabel.setEnabled(false);
                    //customerNumber.setEnabled(false);
                }
            }
            if (event.getSource() == newCustomer) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    setFieldsEnable(true);
                } else {
                    setFieldsEnable(false);
                }
            }
            resetFields();
        }
    }

    /*private class ActionCustomerIdNumber implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == customerNumber) {
                //Test listener ID NUMBER Replace by Data Base Key Customer
                if (customerNumber.getText().equals("123")) {
                    setFieldsEnable(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }*/

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == validationButton) {
                if (newCustomer.isSelected()) {
                    Customer customer;
                    int postalCodeNumber;
                    int birthDateNumber;
                    boolean blank = false;
                    String registerNumber = nationalRegistrationNumber.getText();
                    String[] firstNames = new String[3];
                    String lastNameCustomer = lastName.getText();

                    //TODO doing FSpinner
                    valueDate = (Date) spinnerDateOfBirth.getValue();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
                    dateString = simpleDateFormat.format(valueDate);


                    String accountNumberCustomer = accountNumber.getText();
                    String streetName = street.getText();
                    String houseNumberCustomer = houseNumber.getText();
                    String cityName = city.getText();
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

                        if (RegularExpression.test(lastNameCustomer, "\\d?")) {
                            JOptionPane.showMessageDialog(null, "");
                        }

                        if (RegularExpression.test(firstNames[0], "\\d?")) {
                            JOptionPane.showMessageDialog(null, "");
                        }

                        for (int i = 1; i < firstNames.length; i++) {
                            if (!firstNames[i].isEmpty()) {
                                if (RegularExpression.test(firstNames[i], "\\d?"))
                                    JOptionPane.showMessageDialog(null,"");
                            }
                        } //manque des messages et faut et des else
                        
                        try {
                            postalCodeNumber = Integer.parseInt(postalCode);
                            try {
                                birthDateNumber = Integer.parseInt(dateString);
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
                                        new City(cityName,
                                                postalCodeNumber));
                                //TODO addCustomer()
                                resetFields();
                            } catch (NumberFormatException exception) {
                                JOptionPane.showMessageDialog(null, "field date of birth must be a number");
                            }
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "field post code must be a number");
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }
                    }
                }
            }

            if (event.getSource() == resetButton) {
                resetFields();
            }
        }
    }
}