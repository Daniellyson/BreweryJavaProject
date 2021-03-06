package view;

import controller.ApplicationController;
import exception.GetDataException;
import exception.InvalidFormatException;
import exception.NullException;
import exception.NumberException;
import listener.ActionReturnButton;
import model.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


public class DeleteCustomer extends JPanel {

    private JPanel buttonPanel;
    private JPanel selectPanel;

    private JLabel deleteCustomerLabel;

    private JComboBox listCustomers;

    private JButton returnButton;
    private JButton validationButton;

    private String customerId;
    private String customerLastName;
    private String customerFirstName;
    private Customer customer;

    private ActionReturnButton actionReturnButton;
    private ApplicationController controller;

    public DeleteCustomer(ActionReturnButton actionReturnButton, ApplicationController controller) throws GetDataException, InvalidFormatException, NullException, NumberException {
        this.actionReturnButton = actionReturnButton;
        this.controller = controller;

        setLayout(new BorderLayout());

        selectPanel = new JPanel(new GridLayout(2, 2, 10, 25));
        add(selectPanel, BorderLayout.NORTH);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<Customer> customers;

        customers = controller.getAllCustomers();

        Iterator<Customer> listingCustomers = customers.iterator();

        String [] customerComboBox = new String[customers.size()];

        int i = 0;
        while(listingCustomers.hasNext()) {
            customer = listingCustomers.next();

            customerId = customer.getCustomerNumber().toString();
            customerLastName = customer.getLastName();
            customerFirstName = customer.getFirstName(0);

            customerComboBox[i] = customerId + " " + customerLastName + " " + customerFirstName;
            i++;
        }

        JLabel warning = new JLabel("WARNING");
        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setForeground(Color.RED);
        JLabel text = new JLabel("Deletion is irreversible");
        text.setHorizontalAlignment(JLabel.LEFT);
        selectPanel.add(warning);
        selectPanel.add(text);


        deleteCustomerLabel = new JLabel("Select a customer to be deleted from data base");
        deleteCustomerLabel.setHorizontalAlignment(JLabel.CENTER);
        selectPanel.add(deleteCustomerLabel);

        listCustomers = new JComboBox(customerComboBox);
        selectPanel.add(listCustomers);

        
        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);

        returnButton.addActionListener(actionReturnButton);

        validationButton = new JButton("Validation");
        buttonPanel.add(validationButton);

        validationButton.addActionListener(buttonsActionListener);

    }

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int okOption;

            if (event.getSource() == validationButton) {
                okOption = JOptionPane.showConfirmDialog(null, "If you click yes, ALL the customer data will be deleted" +
                                " from the data base. NO reversion. \n\n Delete ?",
                        "Information", JOptionPane.OK_OPTION);

                String stringComboBox;
                Integer id;

                stringComboBox = listCustomers.getSelectedItem().toString();

                id = Integer.valueOf(stringComboBox.replaceAll("\\D+", ""));

                try {
                    if (okOption == JOptionPane.OK_OPTION) {
                        controller.deleteCustomer(id);
                    }

                    JOptionPane.showMessageDialog(null, "Customer " + stringComboBox + " was deleted from the data base",
                            "Information", JOptionPane.INFORMATION_MESSAGE);

                    removeAll();
                    add(new DeleteCustomer(actionReturnButton, controller));
                    revalidate();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        }
    }
}
