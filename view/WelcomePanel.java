package view;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

    private JLabel welcomeMessage;

    public WelcomePanel() {
        setBackground(Color.WHITE);
        welcomeMessage = new JLabel("<html> Welcome to <font color=black> DJ's </font>  Brewery </html>");
        welcomeMessage.setFont(new Font("Rockwell", Font.BOLD, 36));
        welcomeMessage.setForeground(new Color(153,0,0));
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(welcomeMessage, BorderLayout.CENTER);
    }
}
