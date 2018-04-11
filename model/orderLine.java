package model;

public class orderLine {
    private String lineCode;
    private Integer lineNumber;
    private Integer price;
    private Integer reductionPercentage;
    private Integer amount;
    private Order order;
    private Sale sale;
    private Product product;

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setReductionPercentage(Integer reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
