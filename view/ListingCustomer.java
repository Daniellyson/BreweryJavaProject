package view;

import controller.ApplicationController;
import exception.GetCustomerException;
import model.City;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ListingCustomer extends JFrame {
    private ApplicationController controller;

    private Container container;

    private ArrayList<Customer> customerListing;
    private ArrayList<City> cities;

    public ListingCustomer() {

        super("DJ Brewery (Customer Listing)");
        setUpMainWindow();
        setUpTable();

        setVisible(true);
    }

    public void setUpMainWindow() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        container = this.getContentPane();
        container.setLayout(new BorderLayout());

    }

    public void setUpTable() {
        controller = new ApplicationController();
        customerListing = new ArrayList<Customer>();

        try {
            customerListing = controller.getAllCustomers();

        } catch (GetCustomerException e) {
            e.printStackTrace();
        }

        AllCustomersModel allCustomersModel = new AllCustomersModel(customerListing);
        JTable customerTable = new JTable(allCustomersModel);
        int maxColumn = customerTable.getColumnCount();

        for(int i = 0; i < maxColumn; i++) {
            customerTable.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        customerTable.getColumnModel().getColumn(maxColumn - 1).setPreferredWidth(350);

        customerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        container.add(customerScrollPane, BorderLayout.CENTER);
    }
}
