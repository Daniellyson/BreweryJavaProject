package view;

import model.PercentProduct;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PurchasePercentageModel extends AbstractTableModel {
    ArrayList<String> columnNames;
    ArrayList<PercentProduct> contents;

    public PurchasePercentageModel(ArrayList<PercentProduct> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("product name");
        columnNames.add("percent");
        this.setContents(contents);
    }

    public void setContents(ArrayList<PercentProduct> contents) {
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
        PercentProduct percentProduct = contents.get(row);
        switch(column) {
            case 0 :
                return percentProduct.getNameProduct();
            case 1 :
                return percentProduct.getPercent()+"%";
            default : return null;
        }
    }

    public Class getColumnClass(int column) {
        Class classPercentProduct;
        switch(column) {
            case 0 :
                classPercentProduct = String.class;
                break;
            case 1 :
                classPercentProduct = String.class;
                break;
            default : classPercentProduct = String.class;
        }
        return classPercentProduct;
    }
}
