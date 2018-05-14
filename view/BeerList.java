package view;

import listener.ActionReturnButton;

import javax.swing.*;
import java.awt.*;

public class BeerList extends JPanel {

    public BeerList(ActionReturnButton actionReturnButton) {
        Images imageMenu = new Images();
        JPanel buttonPanel;
        JPanel imagePanel;
        JButton returnButton;

        setLayout(new BorderLayout());

        imagePanel = new JPanel();
        add(imagePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(buttonPanel, BorderLayout.SOUTH);

        imagePanel.setBackground(new Color(255,255,204));
        buttonPanel.setBackground(new Color(255,255,204));

        imagePanel.add(imageMenu.getImageMenu(), BorderLayout.CENTER);

        returnButton = new JButton("Return");
        buttonPanel.add(returnButton);

        returnButton.addActionListener(actionReturnButton);
    }
}
