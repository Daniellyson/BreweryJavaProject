package model;

public class PercentProduct {
    private String nameProduct;
    private Double Percent;

    public PercentProduct(String nameProduct, Double percent) {
        setNameProduct(nameProduct);
        setPercent(percent);

    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPercent(Double percent) {
        Percent = percent;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Double getPercent() {
        return Percent;
    }
}
