package view;

import javax.swing.*;

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
            frames[i] = new ImageIcon("src/main/java/frame/frame_" + i + ".png");
        }

        imageLogo = new ImageIcon("src/main/java/image/logo.png");

        imageHelp = new ImageIcon("src/main/java/image/help.png");

        imageMenu = new ImageIcon("src/main/java/image/menu.png");
    }

    public JLabel getImageLogo() {
        return getImage(imageLogo);
    }

    public JLabel getImageHelp() {
        return getImage(imageHelp);
    }

    public JLabel getImageMenu() {
        return getImage(imageMenu);
    }

    public JLabel getImage(ImageIcon image) {
        JLabel labelMenu = new JLabel();
        labelMenu.setIcon(image);
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
