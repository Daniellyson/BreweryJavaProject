package listener;

import view.Images;
import view.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionReturnButton implements ActionListener {
    private Container container;

    public ActionReturnButton(Container container) {
        setContainer(container);
    }

    private void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.removeAll();

        WelcomePanel welcomePanel = new WelcomePanel();
        Images image = new Images();

        container.add(image.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);
        container.add(image.getGif(), BorderLayout.SOUTH);
        container.setVisible(true);
        welcomePanel.revalidate();
    }
}
