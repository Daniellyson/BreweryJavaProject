package view;

import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchProductsOrderModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Product> contents;

    public SearchProductsOrderModel(ArrayList<Product> products) {
        columnNames = new ArrayList<>();
        columnNames.add("Product");
        columnNames.add("Reduction (%)");
        columnNames.add("Price");
        setContents(products);
    }

    public void setContents(ArrayList<Product> contents) {
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
        Class classProduct;
        switch (column) {
            case 0 :
                classProduct = String.class;
                break;
            case 1 :
                classProduct = Double.class;
                break;
            case 2 :
                classProduct = Double.class;
                break;
            default :
                classProduct = String.class;
        }

        return classProduct;
    }
}