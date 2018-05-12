package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;
import model.Customer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static javax.swing.JTable.AUTO_RESIZE_OFF;


public class SearchOnePanel extends JPanel {

    private JPanel searcheOnePanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel titleComboBox;
    private JLabel firstDateLabel;
    private JLabel secondDateLabel;

    private JComboBox listCustomers;

    private JSpinner firstSpinnerDate;
    private JSpinner secondSpinnerDate;

    private String customerId;
    private String customerLastName;
    private String customerFirstName;
    private Customer customer;

    private ApplicationController controller;

    public SearchOnePanel(ApplicationController controller, ActionReturnButton actionReturnButton)
    throws GetCustomerException {

        setLayout(new BorderLayout());

        this.controller = controller;


        searcheOnePanel = new JPanel(new GridLayout(3, 2, 10, 25));
        add(searcheOnePanel, BorderLayout.NORTH);

        tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<Customer> customers = controller.getAllCustomers();

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

        titleComboBox = new JLabel("Customers data : ");
        titleComboBox.setHorizontalAlignment(JLabel.CENTER);
        searcheOnePanel.add(titleComboBox);

        listCustomers = new JComboBox(customerComboBox);
        searcheOnePanel.add(listCustomers);

        firstDateLabel = new JLabel("First Date");
        firstDateLabel.setHorizontalAlignment(JLabel.CENTER);

        secondDateLabel = new JLabel("Second Date");
        secondDateLabel.setHorizontalAlignment(JLabel.CENTER);

        searcheOnePanel.add(firstDateLabel);
        searcheOnePanel.add(secondDateLabel);

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

        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();

        returnButton.addActionListener(actionReturnButton);
        validationButton.addActionListener(buttonsActionListener);
    }

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == validationButton) {
                tablePanel.removeAll();

                GregorianCalendar dateBeginning = new GregorianCalendar();
                GregorianCalendar dateEnd = new GregorianCalendar();

                String stringComboBox;
                Integer id;
                ArrayList<Product> productSearchOne = new ArrayList<>();

                stringComboBox = listCustomers.getSelectedItem().toString();

                id = Integer.valueOf(stringComboBox.replaceAll("\\D+", ""));


                dateBeginning.setTime((Date) firstSpinnerDate.getValue());

                dateEnd.setTime((Date) secondSpinnerDate.getValue());

                try {
                    productSearchOne = controller.getSearchOne(id, dateBeginning, dateEnd);
                } catch (GetCustomerException e) {
                    e.printStackTrace();
                }

                SearchOneModel searchOneModel = new SearchOneModel(productSearchOne);
                JTable searchOneTable = new JTable(searchOneModel);

                JScrollPane searchOneScrollPane = new JScrollPane(searchOneTable);
                tablePanel.add(searchOneScrollPane);
                tablePanel.revalidate();
            }
        }
    }
}
