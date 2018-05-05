package view;

import model.Customer;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AllCustomersModel extends AbstractTableModel {

    private ArrayList<String> colummNames;
    private ArrayList<Customer> contents;

    public AllCustomersModel(ArrayList<Customer> customers) {
        colummNames = new ArrayList<>();
        colummNames.add("Customer Number");
        colummNames.add("Last Name");
        colummNames.add("First Name");
        colummNames.add("Second First Name");
        colummNames.add("Third First Name");
        colummNames.add("VIP");
        colummNames.add("National Resgistration Number");
        colummNames.add("Account Number");
        colummNames.add("City");
        colummNames.add("Postcode");
        colummNames.add("Street");
        colummNames.add("House Number");
        colummNames.add("Mobile Phone");
        colummNames.add("Landline Phone");
        colummNames.add("Date of Birth");
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
                return customer.getCustomerNumber();
            case 1 :
                return customer.getLastName();
            case 2 :
                return customer.getFirstNames();
            case 3 :
                return customer.getLastName();
            case 4 :
                if(customer.getVip() != null) {
                    return customer.getVip();
                } else {
                    return null;
                }
            case 5 :
                return customer.getNationalRegistrationNumber();
            case 6 :
                return customer.getAccountNumber();
            case 7 :
                return customer.getCity().getName();
            case 8 :
                return customer.getCity().getPostCode();
            case 9 :
                return customer.getStreetName();
            case 10 :
                return customer.getHouseNumber();
            case 11 :
                return customer.getMobilePhone();
            case 12 :
                if(customer.getLandlinePhone() != null) {
                    return customer.getLandlinePhone();
                } else {
                    return null;
                }
            case 13 :
                return customer.getBirthDate();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class classCostumer = null;
        switch (column) {
            case 4 :
                classCostumer = Boolean.class;
                break;
            case 13 :
                classCostumer = GregorianCalendar.class;
                break;
            default :
                 classCostumer = String.class;
        }

        return classCostumer;
    }
}
