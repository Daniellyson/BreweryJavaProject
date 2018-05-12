package view;

import model.Customer;
import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.util.ArrayList;

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
        colummNames.add("Street");
        colummNames.add("House Number");
        colummNames.add("Mobile Phone");
        colummNames.add("Landline Phone");
        colummNames.add("Date of Birth");
        colummNames.add("City Code");
        colummNames.add("Postcode");
        colummNames.add("City");
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
                return customer.getFirstName(0);
            case 3 :
                return customer.getFirstName(1);
            case 4 :
                return customer.getFirstName(2);
            case 5 :
                if(customer.getVip() != null) {
                    return customer.getVip();
                } else {
                    return null;
                }
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
                if(customer.getLandlinePhone() != null) {
                    return customer.getLandlinePhone();
                } else {
                    return null;
                }
            case 12 :
                return customer.getBirthDate().getTime();
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
        Class classCostumer;
        switch (column) {
            case 0 :
                classCostumer = Integer.class;
                break;
            case 5 :
                classCostumer = Boolean.class;
                break;
            case 11 :
                classCostumer = Date.class;
                break;
            case 12 :
                classCostumer = Integer.class;
                break;
            case 13 :
                classCostumer = Integer.class;
                break;
            default :
                classCostumer = String.class;
        }

        return classCostumer;
    }
}
