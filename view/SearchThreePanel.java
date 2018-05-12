package view;

import controller.ApplicationController;
import listener.ActionReturnButton;
import model.Customer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class SearchThreePanel extends JPanel {
    private JSpinner firstDate, secondDate;
    private JComboBox listProducts;
    private ApplicationController controller;
    private JPanel panelButton, form, tablePanel;
    private JLabel firstDateLabel, secondDateLabel, productsLabel;
    private JButton resetButton, returnButton, validationButton;

    public SearchThreePanel(ActionReturnButton returnAction, ApplicationController controller) {
        this.setLayout(new BorderLayout());
        form = new JPanel();
        Action action = new Action();
        form.setLayout(new GridLayout(3,2,10,25));
        productsLabel = new JLabel("products");
        productsLabel.setHorizontalAlignment(JLabel.RIGHT);

        form.add(productsLabel);
        try {
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
        } catch(Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        tablePanel = new JPanel();

        this.controller = controller;

        panelButton = new JPanel();

        firstDateLabel = new JLabel("first date");
        firstDateLabel.setHorizontalAlignment(JLabel.RIGHT);
        form.add(firstDateLabel);

        firstDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEdit = new JSpinner.DateEditor(firstDate,"dd/MM/yyyy");
        firstDate.setEditor(dateEdit);
        form.add(firstDate);

        secondDateLabel = new JLabel("second date");
        secondDateLabel.setHorizontalAlignment(JLabel.RIGHT);
        form.add(secondDateLabel);

        secondDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEdit2 = new JSpinner.DateEditor(secondDate, "dd/MM/yyyy");
        secondDate.setEditor(dateEdit2);
        form.add(secondDate);

        resetButton = new JButton("reset");
        resetButton.addActionListener(action);
        panelButton.add(resetButton);

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
            if (e.getSource() == resetButton) {
                listProducts.setSelectedIndex(0);
            }

            if (e.getSource() == validationButton) {
                String stringCombobox = (String) listProducts.getSelectedItem();
                String idProduct = stringCombobox.substring(0, 6);
                Date valueDate = (Date) firstDate.getValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
                String dateString = simpleDateFormat.format(valueDate);
                Date valueDate2 = (Date) secondDate.getValue();
                String secondDateString = simpleDateFormat.format(valueDate2);
                Integer firstDateNumber = Integer.parseInt(dateString);
                Integer secondDateNumber = Integer.parseInt(secondDateString);

                try {
                    ArrayList<Customer> customers = controller.getSearchThree(idProduct,
                            new GregorianCalendar( firstDateNumber/1000000, (firstDateNumber%1000000)/10000, firstDateNumber%10000),
                            new GregorianCalendar(secondDateNumber/1000000, (secondDateNumber%1000000)/10000, secondDateNumber%10000));
                    SearchThreeModel searchThreeModel = new SearchThreeModel(customers);
                    JTable searchThreeTable = new JTable(searchThreeModel);

                    JScrollPane searchThreeScrollPane = new JScrollPane(searchThreeTable);
                    tablePanel.add(searchThreeScrollPane);
                    tablePanel.revalidate();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null ,exception.getMessage());
                }
            }
        }
    }
}
