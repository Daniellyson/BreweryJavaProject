package listener;

import thread.ThreadAnimation;
import view.Images;
import view.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionReturnButton implements ActionListener {
    private Container container;
    private ThreadAnimation threadAnimation;

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
        Images images = new Images();

        container.add(images.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);
        threadAnimation = new ThreadAnimation(container);
        threadAnimation.start();
        container.setVisible(true);
        welcomePanel.revalidate();
    }
}
