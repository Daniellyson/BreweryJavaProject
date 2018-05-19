package view;

import listener.ActionReturnButton;

import javax.swing.*;
import java.awt.*;

public class Help extends JPanel {

    public Help(ActionReturnButton actionReturnButton) {
        Images imageHelp = new Images();
        JPanel buttonPanel;
        JPanel imagePanel;
        JButton returnButton;

        setLayout(new BorderLayout());

        imagePanel = new JPanel();
        add(imagePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(buttonPanel, BorderLayout.SOUTH);

        imagePanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);

        imagePanel.add(imageHelp.getImageHelp(), BorderLayout.CENTER);

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);

        returnButton.addActionListener(actionReturnButton);
    }
}
