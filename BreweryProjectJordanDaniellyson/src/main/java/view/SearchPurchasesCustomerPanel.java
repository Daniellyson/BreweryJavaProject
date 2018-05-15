package view;

import controller.ApplicationController;
import exception.*;
import listener.ActionReturnButton;
import model.Customer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class SearchPurchasesCustomerPanel extends JPanel {
    private JSpinner firstDate, secondDate;
    private JComboBox listProducts;
    private ApplicationController controller;
    private JPanel panelButton, form, tablePanel;
    private JLabel firstDateLabel, secondDateLabel, productsLabel;
    private JButton returnButton, validationButton;

    public SearchPurchasesCustomerPanel(ActionReturnButton returnAction, ApplicationController controller) throws GetDataException, InvalidFormatException, NumberException, NullException {
        this.setLayout(new BorderLayout());
        form = new JPanel();
        Action action = new Action();
        form.setLayout(new GridLayout(3,2,10,25));
        productsLabel = new JLabel("products");
        productsLabel.setHorizontalAlignment(JLabel.RIGHT);

        form.add(productsLabel);
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
        listProducts = new JComboBox(productCombobox);
        form.add(listProducts);

        tablePanel = new JPanel();

        this.controller = controller;

        panelButton = new JPanel();

        firstDateLabel = new JLabel("first date");
        firstDateLabel.setHorizontalAlignment(JLabel.CENTER);
        form.add(firstDateLabel);

        secondDateLabel = new JLabel("second date");
        secondDateLabel.setHorizontalAlignment(JLabel.CENTER);
        form.add(secondDateLabel);

        firstDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEdit = new JSpinner.DateEditor(firstDate,"dd/MM/yyyy");
        firstDate.setEditor(dateEdit);
        form.add(firstDate);

        secondDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEdit2 = new JSpinner.DateEditor(secondDate, "dd/MM/yyyy");
        secondDate.setEditor(dateEdit2);
        form.add(secondDate);

        returnButton = new JButton("return");
        returnButton.addActionListener(returnAction);
        panelButton.add(returnButton);

        validationButton = new JButton("validation");
        validationButton.addActionListener(action);
        panelButton.add(validationButton);

        this.add(form, BorderLayout.NORTH);
        this.add(panelButton, BorderLayout.SOUTH);
        this.add(tablePanel, BorderLayout.CENTER);
    }

    private class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == validationButton) {
                String stringComboBox = (String) listProducts.getSelectedItem();
                String idProduct = stringComboBox.replaceAll("\\D+", "");
                GregorianCalendar firstDateCalendar = new GregorianCalendar();
                GregorianCalendar secondDateCalendar = new GregorianCalendar();
                firstDateCalendar.setTime((Date) firstDate.getValue());
                secondDateCalendar.setTime((Date) secondDate.getValue());

                try {
                    ArrayList<Customer> customers = controller.getPurchasesCustomer(idProduct, firstDateCalendar, secondDateCalendar);
                    SearchPurchasesCustomerModel searchThreeModel = new SearchPurchasesCustomerModel(customers);
                    JTable searchThreeTable = new JTable(searchThreeModel);

                    JScrollPane searchThreeScrollPane = new JScrollPane(searchThreeTable);
                    tablePanel.removeAll();
                    tablePanel.add(searchThreeScrollPane);
                    tablePanel.revalidate();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null ,exception.getMessage());
                }
            }
        }
    }
}