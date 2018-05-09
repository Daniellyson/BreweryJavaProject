package view;

import model.Customer;
import model.Product;

import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.util.ArrayList;

public class SearchOneModel  extends AbstractTableModel {
    private ArrayList<String> colummNames;
    private ArrayList<Product> contents;

    public SearchOneModel(ArrayList<Product> products) {
        colummNames = new ArrayList<>();
        colummNames.add("Product");
        colummNames.add("Reduction (%)");
        colummNames.add("Price");
        setContents(products);
    }

    public void setContents(ArrayList<Product> contents) {
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
        Product product = contents.get(row);
        switch (column) {
            case 0 :
                return product.getName();
            case 1 :
                return product.getReductionPercentage();
            case 2 :
                return product.getPrice();

            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class classProduct = null;
        switch (column) {
            case 0 :
                classProduct = Integer.class;
                break;
            case 1 :
                classProduct = Integer.class;
                break;
            case 2 :
                classProduct = String.class;
                break;
            default :
                classProduct = String.class;
        }

        return classProduct;
    }
}