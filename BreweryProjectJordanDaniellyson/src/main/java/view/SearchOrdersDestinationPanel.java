package view;

import controller.ApplicationController;
import listener.ActionReturnButton;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class SearchOrdersDestinationPanel extends JPanel {

    private JPanel searchTwoPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel targetDateLabel;

    private JSpinner targetSpinnerDate;

    private ApplicationController controller;

    public SearchOrdersDestinationPanel(ApplicationController controller, ActionReturnButton actionReturnButton) {

        setLayout(new BorderLayout());

        this.controller = controller;

        searchTwoPanel = new JPanel(new GridLayout(1, 2, 10, 25));
        add(searchTwoPanel, BorderLayout.NORTH);

        tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        targetDateLabel = new JLabel("Target Date");
        targetDateLabel.setHorizontalAlignment(JLabel.CENTER);
        searchTwoPanel.add(targetDateLabel);

        targetSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateFirstEdit = new JSpinner.DateEditor(targetSpinnerDate,"dd/MM/yyyy");
        targetSpinnerDate.setEditor(dateFirstEdit);
        searchTwoPanel.add(targetSpinnerDate);


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

                GregorianCalendar targetGregorianCalendar = new GregorianCalendar();

                targetGregorianCalendar.setTime((Date) targetSpinnerDate.getValue());

                ArrayList<Customer> orderSearchTwo = new ArrayList<>();

                try {
                    orderSearchTwo = controller.getOrderDestination(targetGregorianCalendar);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }

                SearchOrdersDestinationModel searchTwoModel = new SearchOrdersDestinationModel(orderSearchTwo);
                JTable searchOneTable = new JTable(searchTwoModel);

                JScrollPane searchTwoScrollPane = new JScrollPane(searchOneTable);
                tablePanel.removeAll();
                tablePanel.add(searchTwoScrollPane);
                tablePanel.revalidate();
            }
        }
    }
}
