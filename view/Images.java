package view;

import javax.swing.*;
import java.awt.*;


public class Images extends JPanel {

    private ImageIcon imageLogo;

    public Images() {

        imageLogo = new ImageIcon("src/images/logo.png");
    }

    public JLabel getImageLogo() {

        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(imageLogo);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelLogo, BorderLayout.CENTER);
        return labelLogo;
    }
}
