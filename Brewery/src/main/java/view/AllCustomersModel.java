package view;

import model.Customer;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AllCustomersModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<Customer> contents;

    public AllCustomersModel(ArrayList<Customer> customers) {
        columnNames = new ArrayList<>();
        columnNames.add("Customer Number");
        columnNames.add("Last Name");
        columnNames.add("First Name");
        columnNames.add("Second First Name");
        columnNames.add("Third First Name");
        columnNames.add("VIP");
        columnNames.add("National Resgistration Number");
        columnNames.add("Account Number");
        columnNames.add("Street");
        columnNames.add("House Number");
        columnNames.add("Mobile Phone");
        columnNames.add("Landline Phone");
        columnNames.add("Date of Birth");
        columnNames.add("City Code");
        columnNames.add("Postcode");
        columnNames.add("City");
        setContents(customers);
    }

    public void setContents(ArrayList<Customer> contents) {
        this.contents = contents;
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public int getRowCount() {
        return contents.size();
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Customer customer = contents.get(row);
        switch (column) {
            case 0 :
                return customer.getCustomerNumber();
            case 1 :
                return customer.getLastName();
            case 2 :
                return customer.getFirstName(0);
            case 3 :
                return customer.getFirstName(1);
            case 4 :
                return customer.getFirstName(2);
            case 5 :
                return customer.getVip();
            case 6 :
                return customer.getNationalRegistrationNumber();
            case 7 :
                return customer.getAccountNumber();
            case 8 :
                return customer.getStreetName();
            case 9 :
                return customer.getHouseNumber();
            case 10 :
                return customer.getMobilePhone();
            case 11 :
                return customer.getLandlinePhone();
            case 12 :
                return customer.getBirthDate().get(GregorianCalendar.DATE)+"/"
                        +customer.getBirthDate().get(GregorianCalendar.MONTH)+"/"
                        +customer.getBirthDate().get(GregorianCalendar.YEAR);
            case 13 :
                return customer.getCity().getCode();
            case 14 :
                return customer.getCity().getPostCode();
            case 15 :
                return customer.getCity().getName();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class classCustomer;
        switch (column) {
            case 0 :
                classCustomer = Integer.class;
                break;
            case 5 :
                classCustomer = Boolean.class;
                break;
            case 12 :
                classCustomer = String.class;
                break;
            case 13 :
                classCustomer = Integer.class;
                break;
            case 14 :
                classCustomer = Integer.class;
                break;
            default :
                classCustomer = String.class;
        }

        return classCustomer;
    }
}
