package thread;

import view.Images;

import javax.swing.*;
import java.awt.*;

public class ThreadAnimation extends Thread {
    private  Container container;
    private static boolean keepGoing;

    public ThreadAnimation(Container container, boolean keepGoing) {
        this.container = container;
        this.keepGoing = keepGoing;
    }

    public ThreadAnimation(Container container) {
        this(container, true);
    }

    public ThreadAnimation(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    public void run() {
        //TODO doing thread
        Images img = new Images();
        JLabel frame = new JLabel();
        try {
            while (keepGoing) {
                Thread.sleep(70);
                ImageIcon imageIcon = img.changeFrame();
                frame.setIcon(imageIcon);
                container.remove(frame);
                frame.setHorizontalAlignment(SwingConstants.CENTER);
                container.add(frame, BorderLayout.SOUTH);
                container.revalidate();
                container.repaint();
                System.out.println("KEEP");
            }
            if(!keepGoing) {
                System.out.println("STOP");
                container.remove(frame);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}