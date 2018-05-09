package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class SearchOnePanel extends JPanel {

    private JPanel searcheOnePanel;
    private JPanel buttonPanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel titleComboBox;
    private JLabel firstDate;
    private JLabel secondDate;

    private JComboBox listCustomers;

    private JSpinner firstSpinnerDate;
    private JSpinner secondSpinnerDate;

    private String customerId;
    private String customerLastName;
    private String customerFirstName;
    private Customer customer;

    public SearchOnePanel(ApplicationController controller, ActionReturnButton actionReturnButton) throws GetCustomerException {

        setLayout(new BorderLayout());

        searcheOnePanel = new JPanel(new GridLayout(3, 2, 10, 25));
        add(searcheOnePanel, BorderLayout.NORTH);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
        add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<Customer> customers = controller.getAllCustomers();

        Iterator<Customer> listingCustomers = customers.iterator();

        String [] customerComboBox = new String[customers.size()];

        int i = 0;
        while(listingCustomers.hasNext()) {
            customer = listingCustomers.next();

            customerId = customer.getCustomerNumber().toString();
            customerLastName = customer.getLastName();
            customerFirstName = customer.getFirstName();

            customerComboBox[i] = customerId + " " + customerLastName + " " + customerFirstName;
            i++;
        }

        titleComboBox = new JLabel("Customers data : ");
        titleComboBox.setHorizontalAlignment(JLabel.CENTER);
        searcheOnePanel.add(titleComboBox);

        listCustomers = new JComboBox(customerComboBox);
        searcheOnePanel.add(listCustomers);

        firstDate = new JLabel("First Date");
        firstDate.setHorizontalAlignment(JLabel.CENTER);

        secondDate = new JLabel("Second Date");
        secondDate.setHorizontalAlignment(JLabel.CENTER);

        searcheOnePanel.add(firstDate);
        searcheOnePanel.add(secondDate);

        firstSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateFirstEdit = new JSpinner.DateEditor(firstSpinnerDate,"dd/MM/yyyy");
        firstSpinnerDate.setEditor(dateFirstEdit);

        secondSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateSecondtEdit = new JSpinner.DateEditor(secondSpinnerDate,"dd/MM/yyyy");
        secondSpinnerDate.setEditor(dateSecondtEdit);

        searcheOnePanel.add(firstSpinnerDate);
        searcheOnePanel.add(secondSpinnerDate);

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);


        validationButton = new JButton("Validation");
        buttonPanel.add(validationButton);

        //TODO
        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();

        returnButton.addActionListener(actionReturnButton);
        validationButton.addActionListener(buttonsActionListener);
    }

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == validationButton) {
                String stringComboBox;
                Date firstDate;
                Date lastDate;
                Integer id;
                stringComboBox = listCustomers.getSelectedItem().toString();

                id = Integer.valueOf(stringComboBox.replaceAll("\\D+", ""));

                System.out.println(id);

            }
        }
    }
}
