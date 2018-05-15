package view;

import controller.ApplicationController;
import exception.GetDataException;
import exception.InvalidFormatException;
import exception.NullException;
import exception.NumberException;
import model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ListingCustomer extends JFrame{
    private ApplicationController controller;

    private Container container;

    private ArrayList<Customer> customerListing;
    private static boolean gotIn = false;

    public ListingCustomer(ApplicationController controller) throws GetDataException, NullException, InvalidFormatException, NumberException {

        super("DJ Brewery (Customer Listing)");

        if(!gotIn) {
            this.controller = controller;
            setUpMainWindow();
            setUpTable();
            setVisible(true);
        }
    }

    public void setUpMainWindow() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        container = this.getContentPane();
        container.setLayout(new BorderLayout());

    }

    public void setUpTable() throws GetDataException, NullException, InvalidFormatException, NumberException {
        customerListing = new ArrayList<>();

        customerListing = controller.getAllCustomers();

        AllCustomersModel allCustomersModel = new AllCustomersModel(customerListing);
        JTable customerTable = new JTable(allCustomersModel);
        int maxColumn = customerTable.getColumnCount();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for(int i = 0; i < maxColumn; i++) {
            customerTable.getColumnModel().getColumn(i).setPreferredWidth(100);
            customerTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        customerTable.getColumnModel().getColumn(12).setPreferredWidth(250);
        customerTable.getColumnModel().getColumn(maxColumn - 1).setPreferredWidth(350);

        customerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        container.add(customerScrollPane, BorderLayout.CENTER);

        gotIn = true;

        this.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                gotIn = false;
            }
        });

    }
}
