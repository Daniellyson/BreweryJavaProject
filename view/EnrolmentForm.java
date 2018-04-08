package view;

import javax.swing.*;
import java.awt.*;
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
    private JLabel mobilePhoneLabel;
    private JLabel landlinePhoneLabel;


    private JLabel cityLabel;
    private JLabel postCodeLabel;



    private JTextField registrationNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField dateOfBirth;
    private JTextField accountNumber;
    private JTextField street;
    private JTextField houseNumber;
    private JTextField mobilePhone;
    private JTextField landlinePhone;


    private JTextField city;
    private JTextField postCode;


    private JCheckBox isVIP;

    //private ActionCheckBox actionCheckBox;

    private JLabel originLabel;
    private JComboBox origin;

    private JButton returnButton;
    private JButton validationButton;
    private JButton resetButton;

    private Container container;

    //private Images images;

    public EnrolmentForm(Container container){
        this.container = container;

        choisePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        add(choisePanel, BorderLayout.NORTH);

        formPanel = new JPanel(new GridLayout(8, 2, 10, 22));
        add(formPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.SOUTH);


        actionCheckBox = new ActionCheckBox();

        newClient = new JRadioButton("New client");
        choisePanel.add(newClient);
        //newClient.addItemListener(actionCheckBox);

        editClient = new JRadioButton("Edit client");
        choisePanel.add(editClient);
        editClient.addItemListener(actionCheckBox);

        //Only one radio button at once
        enrolomentButtonGroup = new ButtonGroup();
        enrolomentButtonGroup.add(newClient);
        enrolomentButtonGroup.add(editClient);

        
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
        }
    }

}
