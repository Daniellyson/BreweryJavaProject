package view;
import listener.ActionReturnButton;
import listener.WindowListener;
import thread.ThreadAnimation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewPrincipal extends JFrame {

    private List<ImageIcon> images;

    private ThreadAnimation threadAnimation;

    private ActionReturnButton actionReturnButton;

    private Container container;

    private JMenuBar menuBar;

    private JMenu applicationMenu;
    private JMenuItem exit;

    private JMenu customerMenu;
    private JMenuItem customerEnrolment;
    private JMenuItem deleteCustomer;

    private JMenu infosMenu;
    private JMenuItem brewery;
    private JMenuItem help;

    private JMenu listing;
    private JMenuItem listingCustomers;

    private JMenu search;
    private JMenuItem listingArticlesOrdered;
    private JMenuItem orderDestination;
    private JMenuItem customersWhoBoughtProduct;

    private JLabel frame;

    public ViewPrincipal() {

        super("DJ Brewery");

        setUpMainWindow();
        setUpMenu();

        setVisible(true);
    }

    public void setUpMenu() {

        ControlerListener controlerEvent = new ControlerListener();
        actionReturnButton = new ActionReturnButton(container, this);

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


        //TODO doing thread - problem button Return(back)
        /*back = new JMenuItem("Return");
        back.addActionListener(actionReturnButton);
        applicationMenu.add(back);*/

        //CLIENT
        customerMenu = new JMenu("Customer");
        customerMenu.setMnemonic('c');
        menuBar.add(customerMenu);

        customerEnrolment = new JMenuItem("Enrolment Data (New / Edit)");
        customerMenu.add(customerEnrolment);

        deleteCustomer = new JMenuItem("Delete Customer");
        customerMenu.add(deleteCustomer);


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
        listingCustomers = new JMenuItem("Customers");
        listing.add(listingCustomers);


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


        customerEnrolment.addActionListener(controlerEvent);
        deleteCustomer.addActionListener(controlerEvent);

        frame = new JLabel();
    }

    public void setUpMainWindow() {
        setBounds(100, 50, 600, 600);

        WelcomePanel welcomePanel = new WelcomePanel();
        Images imagesLogo = new Images();

        ArrayList<ImageIcon> image = new ArrayList<>();
        images = Collections.synchronizedList(image);

        addWindowListener(new WindowListener());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = this.getContentPane();
        container.setBackground(Color.WHITE);
        container.add(imagesLogo.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);

        threadAnimation = new ThreadAnimation(this);
        threadAnimation.start();

    }

    public void changeFrameView(ImageIcon imageIcon) {
        frame.setIcon(imageIcon);
        container.remove(frame);
        frame.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(frame, BorderLayout.SOUTH);
        container.revalidate();

        if(imageIcon == null) {
            container.remove(frame);
        }
    }

    public List<ImageIcon> getImages() {
        return images;
    }

    private class ControlerListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == exit) {
                System.exit(0);
            }

            if(event.getSource() == customerEnrolment){
                //TODO doing thread - stop the thread
                new ThreadAnimation(false);
                container.removeAll();
                container.add(new EnrolmentForm(actionReturnButton));
                container.revalidate();
            }
            if(event.getSource() == deleteCustomer) {

            }
        }
    }

    private void deleteCustomer() {

    }

    private void deleteFromDataBase(String customerKey) {

    }
}