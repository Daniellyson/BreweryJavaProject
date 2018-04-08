package view;

import javax.swing.*;
import java.awt.*;


public class Images extends JPanel {

    private ImageIcon imageLogo;
    private ImageIcon beerGif;

    public Images() {

        imageLogo = new ImageIcon("src/images/logo.png");

        beerGif = new ImageIcon("src/images/beer.gif");
    }

    public JLabel getImageLogo() {

        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(imageLogo);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelLogo, BorderLayout.CENTER);
        return labelLogo;
    }

    public JLabel getGif() {
        JLabel gif = new JLabel();
        gif.setIcon(beerGif);
        gif.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(gif, BorderLayout.CENTER);
        return gif;
    }
}
