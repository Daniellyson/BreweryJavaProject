package view;

import javax.swing.*;

public class Images {
    public static final int NUMBER_OF_FRAMES = 30;
    private ImageIcon imageLogo;
    private ImageIcon imageHelp;
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

    public ImageIcon getFrame() {
        imageFrame = frames[iFrame];
        iFrame = (iFrame + 1) % frames.length;
        return imageFrame;
    }

    /*public ImageIcon [] getFrames() {
        return frames;
    }*/
}
