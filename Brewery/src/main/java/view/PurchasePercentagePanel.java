package view;

import controller.ApplicationController;
import exception.GetDataException;
import exception.NullException;
import exception.PercentException;
import listener.ActionReturnButton;
import model.PercentProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class PurchasePercentagePanel extends JPanel {
    private ApplicationController controller;

    private JPanel jobTaskPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton returnButton;
    private JButton validationButton;

    private JLabel firstDateLabel;
    private JLabel secondDateLabel;

    private JSpinner firstSpinnerDate;
    private JSpinner secondSpinnerDate;

    public PurchasePercentagePanel(ActionReturnButton actionReturnButton, ApplicationController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        jobTaskPanel = new JPanel(new GridLayout(2, 2, 10, 25));
        add(jobTaskPanel, BorderLayout.NORTH);

        tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(buttonPanel, BorderLayout.SOUTH);

        firstDateLabel = new JLabel("First Date");
        firstDateLabel.setHorizontalAlignment(JLabel.CENTER);

        secondDateLabel = new JLabel("Second Date");
        secondDateLabel.setHorizontalAlignment(JLabel.CENTER);

        jobTaskPanel.add(firstDateLabel);
        jobTaskPanel.add(secondDateLabel);

        firstSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateFirstEdit = new JSpinner.DateEditor(firstSpinnerDate,"dd/MM/yyyy");
        firstSpinnerDate.setEditor(dateFirstEdit);

        secondSpinnerDate = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateSecondEdit = new JSpinner.DateEditor(secondSpinnerDate,"dd/MM/yyyy");
        secondSpinnerDate.setEditor(dateSecondEdit);

        jobTaskPanel.add(firstSpinnerDate);
        jobTaskPanel.add(secondSpinnerDate);

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
                GregorianCalendar firstDateCalendar = new GregorianCalendar();
                GregorianCalendar secondDateCalendar = new GregorianCalendar();
                firstDateCalendar.setTime((Date) firstSpinnerDate.getValue());
                secondDateCalendar.setTime((Date) secondSpinnerDate.getValue());

                try {
                    ArrayList<PercentProduct> percentProducts = controller.getPurchasePercentage(firstDateCalendar, secondDateCalendar);
                    PurchasePercentageModel jobTaskModel = new PurchasePercentageModel(percentProducts);
                    JTable jTable = new JTable(jobTaskModel);

                    JScrollPane jobTaskScrollPane = new JScrollPane(jTable);
                    tablePanel.removeAll();
                    tablePanel.add(jobTaskScrollPane);
                    tablePanel.revalidate();
                } catch (GetDataException exception) {
                    JOptionPane.showMessageDialog(null ,exception.getMessage()+"get");
                }catch (PercentException exception) {
                    JOptionPane.showMessageDialog(null ,exception.getMessage()+"Percent");
                }catch (NullException exception) {
                    JOptionPane.showMessageDialog(null ,exception.getMessage()+"Null");
                }
            }
        }
    }
}
