package view;
import listener.WindowListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ViewPrincipal extends JFrame {

    private Container container;

    private JMenuBar menuBar;

    private JMenu applicationMenu;
    private JMenuItem exit;
    private JMenuItem back;

    private JMenu clientMenu;
    private JMenuItem clientEnrolment;
    private JMenuItem deleteClient;

    private JMenu infosMenu;
    private JMenuItem brewery;
    private JMenuItem help;

    private JMenu listing;
    private JMenuItem listingClients;

    private JMenu search;
    private JMenuItem listingArticlesOrdered;
    private JMenuItem orderDestination;
    private JMenuItem customersWhoBoughtProduct;

    public ViewPrincipal() {

        super("DJ Brewery");

        setUpMenu();
        setUpMainWindow();

        setVisible(true);
    }

    public void setUpMenu() {

        ControlerListener controlerEvent = new ControlerListener();

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //APPLICATION
        applicationMenu = new JMenu("Application");
        applicationMenu.setMnemonic('a');
        menuBar.add(applicationMenu);

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        exit.addActionListener(controlerEvent);
        applicationMenu.add(exit);

        back = new JMenuItem("Return");
        back.addActionListener(controlerEvent);
        applicationMenu.add(back);

        //CLIENT
        clientMenu = new JMenu("Client");
        clientMenu.setMnemonic('c');
        menuBar.add(clientMenu);

        clientEnrolment = new JMenuItem("Enrolment Data (New / Edit)");
        clientMenu.add(clientEnrolment);

        deleteClient = new JMenuItem("Delete Client");
        clientMenu.add(deleteClient);


        //INFORMATIONS
        infosMenu = new JMenu("Information");
        infosMenu.setMnemonic('i');
        menuBar.add(infosMenu);

        brewery = new JMenuItem("Brewery");
        infosMenu.add(brewery);

        help = new JMenuItem("Help");
        infosMenu.add(help);


        //LISTING
        listing = new JMenu("Listing");
        listing.setMnemonic('l');
        menuBar.add(listing);
        listingClients = new JMenuItem("Clients");
        listing.add(listingClients);


        //SEARCH
        search = new JMenu("Search");
        search.setMnemonic('s');
        menuBar.add(search);
        listingArticlesOrdered = new JMenuItem("Listing des articles ordered");
        search.add(listingArticlesOrdered);
        orderDestination = new JMenuItem("Order destination");
        search.add(orderDestination);
        customersWhoBoughtProduct = new JMenuItem("Customers who bought a product");
        search.add(customersWhoBoughtProduct);



        clientEnrolment.addActionListener(controlerEvent);
        deleteClient.addActionListener(controlerEvent);

    }

    public void setUpMainWindow() {
        setBounds(100, 50, 600, 600);

        WelcomePanel welcomePanel = new WelcomePanel();
        Images imageLogo = new Images();

        addWindowListener(new WindowListener());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = this.getContentPane();
        container.setBackground(Color.WHITE);
        container.add(imageLogo.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);
        container.add(imageLogo.getGif(), BorderLayout.SOUTH);
    }

    private class ControlerListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == exit) {
                System.exit(0);
            }

            if(event.getSource() == back) {
                container.removeAll();

                WelcomePanel welcomePanel = new WelcomePanel();
                Images image = new Images();

                container.add(image.getImageLogo(), BorderLayout.NORTH);
                container.add(welcomePanel, BorderLayout.CENTER);
                container.add(image.getGif(), BorderLayout.SOUTH);
                container.setVisible(true);
                welcomePanel.revalidate();
            }

            if(event.getSource() == clientEnrolment){
                container.removeAll();
                container.add(new EnrolmentForm(container));
                container.revalidate();
            }
            if(event.getSource() == deleteClient) {
                int yes;
                yes = JOptionPane.showConfirmDialog(null, "Would you like to delete a client ?", "Attention",
                        JOptionPane.OK_OPTION);

                if(yes == JOptionPane.OK_OPTION) {
                    deleteClient();
                }
            }
        }
    }

    private void deleteClient() {
        String clientKey;
        int okOption = 0;
        boolean deleted = false;

        do {
            clientKey = JOptionPane.showInputDialog("Indicate Client ID");
            if(clientKey != null) {
                //TEST change for the DATA BASE client key
                if (clientKey.equals("123")) {
                    okOption = JOptionPane.showConfirmDialog(null, "If you click yes, ALL the client data will be deleted" +
                                    " from the data base. NO reversion. \n\n Delete ?",
                            "Information", JOptionPane.OK_OPTION);
                    if (okOption == JOptionPane.OK_OPTION) {
                        deleteFromDataBase(clientKey);
                        okOption = 1;
                        deleted = true;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong Client ID", "Attention", JOptionPane.ERROR_MESSAGE);
                    okOption = JOptionPane.showConfirmDialog(null, "Continue ?", "Pop-up",
                            JOptionPane.OK_OPTION);
                }
            }
            else {
                okOption = 1;
            }
        } while(okOption == JOptionPane.OK_OPTION);

        if(deleted) {
            JOptionPane.showMessageDialog(null, "Client " + clientKey + " was deleted from the data base",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void deleteFromDataBase(String clientKey) {

    }
}