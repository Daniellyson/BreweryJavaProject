package view;

import model.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchOrdersDestinationModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<Customer> contents;

    public SearchOrdersDestinationModel(ArrayList<Customer> customers) {
        columnNames = new ArrayList<>();
        columnNames.add("Last Name");
        columnNames.add("First Name");
        columnNames.add("Street");
        columnNames.add("House Number");
        columnNames.add("City");
        columnNames.add("PostCode");

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
        Class classCustomer;
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
