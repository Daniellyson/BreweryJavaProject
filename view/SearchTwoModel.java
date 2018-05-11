package view;

import model.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchTwoModel extends AbstractTableModel {

    private ArrayList<String> colummNames;
    private ArrayList<Customer> contents;

    public SearchTwoModel(ArrayList<Customer> customers) {
        colummNames = new ArrayList<>();
        colummNames.add("Last Name");
        colummNames.add("First Name");
        colummNames.add("Street");
        colummNames.add("House Number");
        colummNames.add("City");
        colummNames.add("PostCode");

        setContents(customers);
    }

    public void setContents(ArrayList<Customer> contents) {
        this.contents = contents;
    }

    public int getColumnCount() {
        return colummNames.size();
    }

    public int getRowCount() {
        return contents.size();
    }

    public String getColumnName(int column) {
        return colummNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Customer customer = contents.get(row);
        switch (column) {
            case 0 :
                return customer.getLastName();
            case 1 :
                return customer.getFirstName(0);
            case 2 :
                return customer.getStreetName();
            case 3 :
                return customer.getHouseNumber();
            case 4 :
                return customer.getCity().getName();
            case 5 :
                return customer.getCity().getPostCode();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class classCustomer = null;
        switch (column) {
            case 0 :
                classCustomer = String.class;
                break;
            case 1 :
                classCustomer = String.class;
                break;
            case 2 :
                classCustomer = String.class;
                break;
            case 3 :
                classCustomer = Integer.class;
                break;
            case 4 :
                classCustomer = String.class;
                break;
            case 5 :
                classCustomer = Integer.class;
                break;
            default :
                classCustomer = String.class;
        }

        return classCustomer;
    }
}
