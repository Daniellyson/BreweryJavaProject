package thread;

import view.Images;
import view.ViewPrincipal;

import javax.swing.*;
import java.awt.*;

public class ThreadAnimation extends Thread {
    private ViewPrincipal viewPrincipal;
    private static boolean keepGoing;

    public ThreadAnimation(ViewPrincipal viewPrincipal) {
        this.viewPrincipal = viewPrincipal;
        keepGoing = true;
    }

    public ThreadAnimation(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    public void run() {
        //TODO doing thread
        Images img = new Images();
        try {
            while (keepGoing) {
                Thread.sleep(70);
                ImageIcon imageIcon = img.getFrame();
                viewPrincipal.changeFrameView(imageIcon);
                viewPrincipal.repaint();
            }
            if(!keepGoing) {
                viewPrincipal.changeFrameView(null);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}