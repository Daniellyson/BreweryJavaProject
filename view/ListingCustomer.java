package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingCustomer extends JPanel {
    private JPanel buttonPanel;
    private JPanel listingPanel;
    private ApplicationController controller;

    private JButton returnButton;
    private JButton listButton;

    public ListingCustomer(ActionReturnButton actionReturnButton) {

        controller = new ApplicationController();

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.NORTH);

        ManagerListingCustomer managerListingCustomer = new ManagerListingCustomer();

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.addActionListener(actionReturnButton);

        listButton = new JButton("List");
        buttonPanel.add(listButton);
        listButton.addActionListener(managerListingCustomer);
    }

    private class ManagerListingCustomer implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            try {
                //TODO
                //  at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2022)
                //	at javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2348)
                //	at javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:402)
                //	at javax.swing.DefaultButtonModel.setPressed(DefaultButtonModel.java:259)
                //exception.GetCustomerException: Error during query of customer data
                // (No suitable driver found for jdbc:mysql://localhost:3306/database_brewery?useSSL=false).
                AllCustomersModel allCustomersModel = new AllCustomersModel(controller.getAllCustomers());

                JTable customerTable = new JTable(allCustomersModel);
                TableColumn column0 = customerTable.getColumnModel().getColumn(0);
                TableColumn column1 = customerTable.getColumnModel().getColumn(1);
                TableColumn column2 = customerTable.getColumnModel().getColumn(2);
                TableColumn column3 = customerTable.getColumnModel().getColumn(3);
                TableColumn column4 = customerTable.getColumnModel().getColumn(4);
                TableColumn column5 = customerTable.getColumnModel().getColumn(5);
                TableColumn column6 = customerTable.getColumnModel().getColumn(6);
                TableColumn column7 = customerTable.getColumnModel().getColumn(7);
                TableColumn column8 = customerTable.getColumnModel().getColumn(8);
                TableColumn column9 = customerTable.getColumnModel().getColumn(9);
                TableColumn column10 = customerTable.getColumnModel().getColumn(10);
                TableColumn column11 = customerTable.getColumnModel().getColumn(11);
                TableColumn column12 = customerTable.getColumnModel().getColumn(12);
                TableColumn column13 = customerTable.getColumnModel().getColumn(13);

                listingPanel = new JPanel();
                JScrollPane customerListing = new JScrollPane(customerTable);
                listingPanel.add(customerListing, BorderLayout.CENTER);
                listingPanel.setVisible(true);

            } catch (GetCustomerException e) {
                e.printStackTrace();
            }
        }
    }
}
