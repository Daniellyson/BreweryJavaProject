package listener;

import thread.ThreadAnimation;
import view.Images;
import view.ViewPrincipal;
import view.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionReturnButton implements ActionListener {
    private Container container;
    private ViewPrincipal viewPrincipal;
    private ThreadAnimation threadAnimation;


    public ActionReturnButton(Container container, ViewPrincipal viewPrincipal) {
        this.viewPrincipal = viewPrincipal;
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

        threadAnimation = new ThreadAnimation(viewPrincipal);
        threadAnimation.start();

        container.setVisible(true);
        welcomePanel.revalidate();
    }
}
