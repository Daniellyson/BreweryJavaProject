package view;

import listener.ActionReturnButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteCustomer extends JPanel {

    private JPanel buttonPanel;

    private JLabel deleteCustomerLabel;

    private JButton returnButton;
    private JButton validationButton;

    DeleteCustomer(ActionReturnButton actionReturnButton) {

        setLayout(new BorderLayout());


        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(buttonPanel, BorderLayout.SOUTH);


        //Buttons South
        ButtonsActionListener buttonsActionListener = new ButtonsActionListener();

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);
        returnButton.addActionListener(actionReturnButton);

        validationButton = new JButton("Validation");
        buttonPanel.add(validationButton);
        validationButton.addActionListener(buttonsActionListener);
    }

    private class ButtonsActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == validationButton) {

            }
        }
    }
}
