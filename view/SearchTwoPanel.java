package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;
import model.Customer;
import model.Order;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class SearchTwoPanel  extends JPanel {

    private JPanel searcheTwoPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel targetDateLabel;

    private JSpinner targetSpinnerDate;

    private ApplicationController controller;

    public SearchTwoPanel(ApplicationController controller, ActionReturnButton actionReturnButton)
    throws GetCustomerException {

        setLayout(new BorderLayout());

        this.controller = controller;

        searcheTwoPanel = new JPanel(new GridLayout(1, 2, 10, 25));
        add(searcheTwoPanel, BorderLayout.NORTH);

        tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        targetDateLabel = new JLabel("Target Date");
        targetDateLabel.setHorizontalAlignment(JLabel.CENTER);
        searcheTwoPanel.add(targetDateLabel);

        targetSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateFirstEdit = new JSpinner.DateEditor(targetSpinnerDate,"dd/MM/yyyy");
        targetSpinnerDate.setEditor(dateFirstEdit);
        searcheTwoPanel.add(targetSpinnerDate);


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

                GregorianCalendar targetGregorianCalendar = new GregorianCalendar();

                targetGregorianCalendar.setTime((Date) targetSpinnerDate.getValue());

                ArrayList<Customer> orderSearchTwo = new ArrayList<>();

                try {
                    orderSearchTwo = controller.getSearchTwo(targetGregorianCalendar);
                } catch (GetCustomerException e) {
                    e.printStackTrace();
                }

                SearchTwoModel searchTwoModel = new SearchTwoModel(orderSearchTwo);
                JTable searchOneTable = new JTable(searchTwoModel);

                JScrollPane searchTwoScrollPane = new JScrollPane(searchOneTable);
                tablePanel.add(searchTwoScrollPane);
                tablePanel.revalidate();
            }
        }
    }
}
