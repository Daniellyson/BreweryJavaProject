package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EnrolmentForm  extends JPanel {
    private JPanel choisePanel;
    private JPanel formPanel;
    private JPanel buttonPanel;


    private ButtonGroup enrolomentButtonGroup;
    private JRadioButton newClient;
    private JRadioButton editClient;


    private JLabel clientNumberLabel;
    private JTextField clientNumber;

    private ActionCheckBox actionCheckBox;

    private JLabel registrationNumberLabel;
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


    private JTextField registrationNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField dateOfBirth;
    private JTextField accountNumber;
    private JTextField street;
    private JTextField houseNumber;

    private JTextField city;
    private JTextField postCode;

    private JTextField mobilePhone;
    private JTextField landlinePhone;

    private JCheckBox isVIP;

    private JButton returnButton;
    private JButton validationButton;
    private JButton resetButton;

    private Container container;

    public EnrolmentForm(Container container){
        this.container = container;

        choisePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        add(choisePanel, BorderLayout.NORTH);

        formPanel = new JPanel(new GridLayout(12, 2, 10, 10));
        add(formPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        //CHOISE PANEL

        actionCheckBox = new ActionCheckBox();

        newClient = new JRadioButton("New client");
        choisePanel.add(newClient);
        newClient.addItemListener(actionCheckBox);

        editClient = new JRadioButton("Edit client");
        choisePanel.add(editClient);
        editClient.addItemListener(actionCheckBox);

        //Only one radio button at once
        enrolomentButtonGroup = new ButtonGroup();
        enrolomentButtonGroup.add(newClient);
        enrolomentButtonGroup.add(editClient);


        clientNumberLabel = new JLabel("Client Id Number");
        clientNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        choisePanel.add(clientNumberLabel);
        clientNumber = new JTextField();
        choisePanel.add(clientNumber);
        clientNumberLabel.setEnabled(false);
        clientNumber.setEnabled(false);
        clientNumber.addActionListener(new ActionClientIdNumber());

        //FORM PANEL

        registrationNumberLabel = new JLabel("Registration Number: ");
        registrationNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(registrationNumberLabel);
        registrationNumber = new JTextField();
        formPanel.add(registrationNumber);

        registrationNumberLabel.setEnabled(false);
        registrationNumber.setEnabled(false);


        firstNameLabel = new JLabel("First name:");
        firstNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(firstNameLabel);
        firstName = new JTextField();
        formPanel.add(firstName);

        firstNameLabel.setEnabled(false);
        firstName.setEnabled(false);


        lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(lastNameLabel);
        lastName = new JTextField();
        formPanel.add(lastName);

        lastNameLabel.setEnabled(false);
        lastName.setEnabled(false);


        dateOfBirthLabel = new JLabel("Date of birth:");
        dateOfBirthLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(dateOfBirthLabel);
        dateOfBirth = new JTextField();
        formPanel.add(dateOfBirth);

        dateOfBirthLabel.setEnabled(false);
        dateOfBirth.setEnabled(false);

        accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(accountNumberLabel);
        accountNumber = new JTextField();
        formPanel.add(accountNumber);

        accountNumberLabel.setEnabled(false);
        accountNumber.setEnabled(false);

        //actionCheckBox = new ActionCheckBox();

        isVIP = new JCheckBox("VIP");
        formPanel.add(isVIP);
        isVIP.setEnabled(false);
        formPanel.add(new JLabel(""));


        //ADRESSE
        streetLabel = new JLabel("Street:");
        streetLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(streetLabel);
        street = new JTextField();
        formPanel.add(street);

        streetLabel.setEnabled(false);
        street.setEnabled(false);


        houseNumberLabel = new JLabel("House number:");
        houseNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(houseNumberLabel);
        houseNumber = new JTextField();
        formPanel.add(houseNumber);

        houseNumberLabel.setEnabled(false);
        houseNumber.setEnabled(false);


        cityLabel = new JLabel("City:");
        cityLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(cityLabel);
        city = new JTextField();
        formPanel.add(city);

        cityLabel.setEnabled(false);
        city.setEnabled(false);


        postCodeLabel = new JLabel("Post Code:");
        postCodeLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(postCodeLabel);
        postCode = new JTextField();
        formPanel.add(postCode);

        postCodeLabel.setEnabled(false);
        postCode.setEnabled(false);


        //PHONES
        mobilePhoneLabel = new JLabel("Mobile phone:");
        mobilePhoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(mobilePhoneLabel);
        mobilePhone = new JTextField();
        formPanel.add(mobilePhone);

        mobilePhoneLabel.setEnabled(false);
        mobilePhone.setEnabled(false);

        landlinePhoneLabel = new JLabel("Landline phone:");
        landlinePhoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        formPanel.add(landlinePhoneLabel);
        landlinePhone = new JTextField();
        formPanel.add(landlinePhone);

        landlinePhoneLabel.setEnabled(false);
        landlinePhone.setEnabled(false);


        //Buttons South
        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        //returnButton.addActionListener(new ButtonsActionListener());

        validationButton = new JButton("Validation");
        buttonPanel.add(validationButton);
        //validationButton.addActionListener(new ButtonsActionListener());

        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        //resetButton.addActionListener(new ButtonsActionListener());
    }

    private class ActionCheckBox implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if(event.getSource() == editClient) {
                if(event.getStateChange() == ItemEvent.SELECTED) {
                    clientNumberLabel.setEnabled(true);
                    clientNumber.setEnabled(true);
                }
                else {
                    clientNumberLabel.setEnabled(false);
                    clientNumber.setEnabled(false);
                }
            }
            if(event.getSource() == newClient) {
                if(event.getStateChange() == ItemEvent.SELECTED) {
                    registrationNumberLabel.setEnabled(true);
                    registrationNumber.setEnabled(true);
                    firstNameLabel.setEnabled(true);
                    firstName.setEnabled(true);
                    lastNameLabel.setEnabled(true);
                    lastName.setEnabled(true);
                    dateOfBirthLabel.setEnabled(true);
                    dateOfBirth.setEnabled(true);
                    accountNumberLabel.setEnabled(true);
                    accountNumber.setEnabled(true);
                    streetLabel.setEnabled(true);
                    street.setEnabled(true);
                    houseNumberLabel.setEnabled(true);
                    houseNumber.setEnabled(true);
                    cityLabel.setEnabled(true);
                    city.setEnabled(true);
                    mobilePhoneLabel.setEnabled(true);
                    mobilePhone.setEnabled(true);
                    landlinePhoneLabel.setEnabled(true);
                    landlinePhone.setEnabled(true);
                }
                else {
                    registrationNumberLabel.setEnabled(false);
                    registrationNumber.setEnabled(false);
                    firstNameLabel.setEnabled(false);
                    firstName.setEnabled(false);
                    lastNameLabel.setEnabled(false);
                    lastName.setEnabled(false);
                    dateOfBirthLabel.setEnabled(false);
                    dateOfBirth.setEnabled(false);
                    accountNumberLabel.setEnabled(false);
                    accountNumber.setEnabled(false);
                    streetLabel.setEnabled(false);
                    street.setEnabled(false);
                    houseNumberLabel.setEnabled(false);
                    houseNumber.setEnabled(false);
                    cityLabel.setEnabled(false);
                    city.setEnabled(false);
                    mobilePhoneLabel.setEnabled(false);
                    mobilePhone.setEnabled(false);
                    landlinePhoneLabel.setEnabled(false);
                    landlinePhone.setEnabled(false);
                }
            }
        }
    }

    private class ActionClientIdNumber implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            //Test listener ID NUMBER
            if(event.getSource() == clientNumber) {
                if(clientNumber.getText().equals("123")) {
                    registrationNumberLabel.setEnabled(true);
                    registrationNumber.setEnabled(true);
                    firstNameLabel.setEnabled(true);
                    firstName.setEnabled(true);
                    lastNameLabel.setEnabled(true);
                    lastName.setEnabled(true);
                    dateOfBirthLabel.setEnabled(true);
                    dateOfBirth.setEnabled(true);
                    accountNumberLabel.setEnabled(true);
                    accountNumber.setEnabled(true);
                    streetLabel.setEnabled(true);
                    street.setEnabled(true);
                    houseNumberLabel.setEnabled(true);
                    houseNumber.setEnabled(true);
                    cityLabel.setEnabled(true);
                    city.setEnabled(true);
                    mobilePhoneLabel.setEnabled(true);
                    mobilePhone.setEnabled(true);
                    landlinePhoneLabel.setEnabled(true);
                    landlinePhone.setEnabled(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}