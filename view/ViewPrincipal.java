package view;
import javafx.scene.layout.Background;
import listeners.WindowListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ViewPrincipal extends JFrame {

    private Container container;

    private JMenuBar menuBar;

    private JMenu applicationMenu;
    private JMenuItem exit;

    private JMenu studentMenu;
    private JMenuItem studentInscription;

    private JMenu infosMenu;
    private JMenuItem brewery;
    private JMenuItem help;

    private JMenu listing;
    private JMenuItem listingClients;


    public ViewPrincipal() {

        super("DJ Brewery");

        setUpMenu();
        setUpMainWindow();

        setVisible(true);
    }

    public void setUpMenu() {

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //APPLICATION
        applicationMenu = new JMenu("Application");
        applicationMenu.setMnemonic('a');
        menuBar.add(applicationMenu);

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        applicationMenu.add(exit);

        //STUDENT
        studentMenu = new JMenu("Client");
        studentMenu.setMnemonic('s');
        menuBar.add(studentMenu);

        studentInscription = new JMenuItem("Enrolment");
        studentMenu.add(studentInscription);

        //INFORMATIONS
        infosMenu = new JMenu("Information");
        infosMenu.setMnemonic('i');
        menuBar.add(infosMenu);

        brewery = new JMenuItem("Brewery");
        infosMenu.add(brewery);

        help = new JMenuItem("Help");
        infosMenu.add(help);

        listing = new JMenu("Listing");
        listing.setMnemonic('d');
        menuBar.add(listing);
        listingClients = new JMenuItem("Clients");
        listing.add(listingClients);
        //listingClients.addActionListener(controlerEvent);

        /*
        exit.addActionListener(controlerEvent);
        iesn.addActionListener(controlerEvent);
        help.addActionListener(controlerEvent);
        studentInscription.addActionListener(controlerEvent);
        */

    }

    public void setUpMainWindow() {
        setBounds(100, 50, 600, 550);

        WelcomePanel welcomePanel = new WelcomePanel();
        Images imageLogo = new Images();

        addWindowListener(new WindowListener());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = this.getContentPane();
        container.setBackground(Color.WHITE);
        container.add(imageLogo.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);
    }
}
