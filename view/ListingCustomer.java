package view;

import listener.ActionReturnButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingCustomer extends JPanel {
    private JPanel buttonPanel;
    //private JPanel listingPanel;

    private JButton returnButton;
    private JButton listButton;

    public ListingCustomer(ActionReturnButton actionReturnButton) {

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

        }
    }
}
