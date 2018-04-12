package view;

import javax.swing.*;

public class Images {

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
        return labelLogo;
    }

    public JLabel getGif() {
        JLabel gif = new JLabel();
        gif.setIcon(beerGif);
        gif.setHorizontalAlignment(SwingConstants.CENTER);
        return gif;
    }
}
