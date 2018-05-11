package view;
import controller.ApplicationController;
import exception.GetCustomerException;
import listener.ActionReturnButton;
import listener.WindowListener;
import model.Customer;
import thread.ThreadAnimation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPrincipal extends JFrame {

    private ThreadAnimation threadAnimation;

    private ActionReturnButton actionReturnButton;

    private Container container;

    private JMenuBar menuBar;

    private JMenu applicationMenu;
    private JMenuItem exit;

    private JMenu customerMenu;
    private JMenuItem customerEnrolment;
    private JMenuItem deleteCustomer;
    private JMenuItem listingCustomers;

    private JMenu infosMenu;
    private JMenuItem brewery;
    private JMenuItem help;

    private JMenu search;
    private JMenuItem listingArticlesOrdered;
    private JMenuItem orderDestination;
    private JMenuItem customersWhoBoughtProduct;

    private JLabel frame;

    private ApplicationController controller;

    public ViewPrincipal() {

        super("DJ Brewery");
        container = this.getContentPane();

        controller = new ApplicationController();

        initThread();

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

        listingCustomers = new JMenuItem("Listing");
        customerMenu.add(listingCustomers);


        //INFORMATIONS
        infosMenu = new JMenu("Information");
        infosMenu.setMnemonic('i');
        menuBar.add(infosMenu);

        brewery = new JMenuItem("Brewery");
        infosMenu.add(brewery);

        help = new JMenuItem("Help");
        infosMenu.add(help);


        //SEARCH
        search = new JMenu("Searches");
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
        listingCustomers.addActionListener(controlerEvent);
        listingArticlesOrdered.addActionListener(controlerEvent);
        orderDestination.addActionListener(controlerEvent);

    }

    public void setUpMainWindow() {
        setBounds(100, 50, 600, 600);

        WelcomePanel welcomePanel = new WelcomePanel();
        Images imagesLogo = new Images();

        addWindowListener(new WindowListener());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setBackground(Color.WHITE);
        container.add(imagesLogo.getImageLogo(), BorderLayout.NORTH);
        container.add(welcomePanel, BorderLayout.CENTER);
    }

    public void initThread() {
        frame = new JLabel();
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

    private class ControlerListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == exit) {
                System.exit(0);
            }
            if(event.getSource() == customerEnrolment){
                new ThreadAnimation(false);
                container.removeAll();
                container.add(new EnrolmentForm(actionReturnButton, controller));
                container.revalidate();
            }
            if(event.getSource() == deleteCustomer) {
                new ThreadAnimation(false);
                container.removeAll();
                container.add(new DeleteCustomer(actionReturnButton, controller));
                container.revalidate();
            }
            if(event.getSource() == listingCustomers) {

                new ListingCustomer(controller);
            }
            //SEARCH ONE
            if(event.getSource() == listingArticlesOrdered) {
                new ThreadAnimation(false);
                container.removeAll();
                container.setBackground(null);

                try {
                    container.add(new SearchOnePanel(controller, actionReturnButton));
                } catch (GetCustomerException e) {
                    e.printStackTrace();
                }
                container.revalidate();
            }
            //SEARCH TWO
            if(event.getSource() == orderDestination) {
                new ThreadAnimation(false);
                container.removeAll();
                container.setBackground(null);

                try {
                    container.add(new SearchTwoPanel(controller, actionReturnButton));
                } catch (GetCustomerException e) {
                    e.printStackTrace();
                }

                container.revalidate();
            }
            //SEARCH THREE
            if(event.getSource() == customersWhoBoughtProduct){

            }
        }

    }
}