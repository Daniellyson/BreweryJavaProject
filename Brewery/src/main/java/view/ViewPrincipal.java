package view;
import controller.ApplicationController;
import listener.ActionReturnButton;
import listener.WindowListener;
import thread.ThreadAnimation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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

    private JMenu infoMenu;
    private JMenuItem beerList;
    private JMenuItem help;

    private JMenu search;
    private JMenuItem listingArticlesOrdered;
    private JMenuItem orderDestination;
    private JMenuItem customersWhoBoughtProduct;

    private JMenu jobTask;
    private JMenuItem productsSalesPercentage;

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

        ControllerListener controllerEvent = new ControllerListener();
        actionReturnButton = new ActionReturnButton(container, this);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        
        applicationMenu = new JMenu("Application");
        applicationMenu.setMnemonic('a');
        menuBar.add(applicationMenu);

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        exit.addActionListener(controllerEvent);
        applicationMenu.add(exit);

        
        customerMenu = new JMenu("Customer");
        customerMenu.setMnemonic('c');
        menuBar.add(customerMenu);

        customerEnrolment = new JMenuItem("Enrolment Data (New / Edit)");
        customerMenu.add(customerEnrolment);

        deleteCustomer = new JMenuItem("Delete Customer");
        customerMenu.add(deleteCustomer);

        listingCustomers = new JMenuItem("Listing");
        customerMenu.add(listingCustomers);

        infoMenu = new JMenu("Information");
        infoMenu.setMnemonic('i');
        menuBar.add(infoMenu);

        beerList = new JMenuItem("Beer List");
        infoMenu.add(beerList);

        help = new JMenuItem("Help");
        infoMenu.add(help);


        
        search = new JMenu("Searches");
        search.setMnemonic('s');
        menuBar.add(search);
        listingArticlesOrdered = new JMenuItem("Listing products ordered");
        search.add(listingArticlesOrdered);
        orderDestination = new JMenuItem("Order destination");
        search.add(orderDestination);
        customersWhoBoughtProduct = new JMenuItem("Customers who bought a product");
        search.add(customersWhoBoughtProduct);


        
        jobTask = new JMenu("Job Task");
        jobTask.setMnemonic('j');
        menuBar.add(jobTask);
        productsSalesPercentage = new JMenuItem("Statistic of Products Sales (Percentage)");
        jobTask.add(productsSalesPercentage);


        customerEnrolment.addActionListener(controllerEvent);
        deleteCustomer.addActionListener(controllerEvent);
        listingCustomers.addActionListener(controllerEvent);
        listingArticlesOrdered.addActionListener(controllerEvent);
        orderDestination.addActionListener(controllerEvent);
        customersWhoBoughtProduct.addActionListener(controllerEvent);
        productsSalesPercentage.addActionListener(controllerEvent);
        help.addActionListener(controllerEvent);
        beerList.addActionListener(controllerEvent);

    }

    public void setUpMainWindow() {
        setBounds(100, 50, 600, 600);

        WelcomePanel welcomePanel = new WelcomePanel();
        Images imagesLogo = new Images();

        addWindowListener(new WindowListener());
        

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

    private class ControllerListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == exit) {
                System.exit(0);
            }
            if(event.getSource() == customerEnrolment){
                setUpPanel(new EnrolmentForm(actionReturnButton, controller));
            }
            if(event.getSource() == deleteCustomer) {
                try {
                    setUpPanel(new DeleteCustomer(actionReturnButton, controller));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
            if(event.getSource() == listingCustomers) {
                try {
                    new ListingCustomer(controller);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
            
            if(event.getSource() == listingArticlesOrdered) {
                try {
                    setUpPanel(new SearchProductsOrderedPanel(controller, actionReturnButton));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
            
            if(event.getSource() == orderDestination) {
                try {
                    setUpPanel(new SearchOrdersDestinationPanel(controller, actionReturnButton));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
            
            if(event.getSource() == customersWhoBoughtProduct){
                try {
                    setUpPanel(new SearchPurchasesCustomerPanel(actionReturnButton, controller));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
            
            if (event.getSource() == productsSalesPercentage) {
                    setUpPanel(new PurchasePercentagePanel(actionReturnButton, controller));
            }
            
            if(event.getSource() == help) {
                setUpPanel(new Help(actionReturnButton));
            }

            if(event.getSource() == beerList) {
                setUpPanel(new BeerList(actionReturnButton) );
            }
        }

        private void setUpPanel(JPanel panel) {
            new ThreadAnimation(false);
            container.removeAll();
            container.add(panel);
            container.revalidate();
        }
    }
}