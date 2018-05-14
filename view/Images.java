package view;

import javax.swing.*;
import java.awt.*;

public class Images {
    public static final int NUMBER_OF_FRAMES = 30;
    private ImageIcon imageLogo;
    private ImageIcon imageHelp;
    private ImageIcon imageMenu;
    private ImageIcon imageFrame = new ImageIcon();
    private int iFrame;
    private ImageIcon [] frames;

    public Images() {

        frames = new ImageIcon[NUMBER_OF_FRAMES];

        for(int i = 0; i < NUMBER_OF_FRAMES; i++) {
            frames[i] = new ImageIcon("src/frame/frame_" + i + ".png");
        }

        imageLogo = new ImageIcon("src/image/logo.png");

        imageHelp = new ImageIcon("src/image/help.png");

        imageMenu = new ImageIcon("src/image/menu.png");
    }

    public JLabel getImageLogo() {

        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(imageLogo);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        return labelLogo;
    }

    public JLabel getImageHelp() {

        JLabel labelHelp = new JLabel();
        labelHelp.setIcon(imageHelp);
        labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
        return labelHelp;
    }

    public JLabel getImageMenu() {

        JLabel labelMenu = new JLabel();
        labelMenu.setIcon(imageMenu);
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        return labelMenu;
    }

    public ImageIcon getFrame() {
        imageFrame = frames[iFrame];
        iFrame = (iFrame + 1) % frames.length;
        return imageFrame;
    }

    /*public ImageIcon [] getFrames() {
        return frames;
    }*/
}
