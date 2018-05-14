package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import exception.InvalidFormatException;
import exception.NullException;
import exception.NumberException;
import listener.ActionReturnButton;
import model.Product;

import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class JobTask extends JPanel {
    private ApplicationController controller;

    private JPanel jobTaskPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel titleComboBox;
    private JLabel firstDateLabel;
    private JLabel secondDateLabel;

    private JComboBox listProducts;

    private JSpinner firstSpinnerDate;
    private JSpinner secondSpinnerDate;

    public JobTask(ActionReturnButton actionReturnButton, ApplicationController controller)
            throws GetCustomerException, NamingException, InvalidFormatException, NumberException, NullException {
        this.controller = controller;
        setLayout(new BorderLayout());

        jobTaskPanel = new JPanel(new GridLayout(3, 2, 10, 25));
        add(jobTaskPanel, BorderLayout.NORTH);

        tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<Product> products = controller.getAllProducts();
        String[] productCombobox = new String[products.size()];

        Iterator<Product> iteratorProduct = products.iterator();
        Product product;
        int i = 0;

        while (iteratorProduct.hasNext()) {
            product = iteratorProduct.next();
            productCombobox[i] = product.getCode()+" "+ product.getName();
            i++;
        }

        titleComboBox = new JLabel("Product data : ");
        titleComboBox.setHorizontalAlignment(JLabel.CENTER);
        jobTaskPanel.add(titleComboBox);

        listProducts = new JComboBox(productCombobox);
        jobTaskPanel.add(listProducts);

        firstDateLabel = new JLabel("First Date");
        firstDateLabel.setHorizontalAlignment(JLabel.CENTER);

        secondDateLabel = new JLabel("Second Date");
        secondDateLabel.setHorizontalAlignment(JLabel.CENTER);

        jobTaskPanel.add(firstDateLabel);
        jobTaskPanel.add(secondDateLabel);

        firstSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateFirstEdit = new JSpinner.DateEditor(firstSpinnerDate,"dd/MM/yyyy");
        firstSpinnerDate.setEditor(dateFirstEdit);

        secondSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateSecondtEdit = new JSpinner.DateEditor(secondSpinnerDate,"dd/MM/yyyy");
        secondSpinnerDate.setEditor(dateSecondtEdit);

        jobTaskPanel.add(firstSpinnerDate);
        jobTaskPanel.add(secondSpinnerDate);

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

            }
        }
    }
}
