package model;

public class OrderLine {
    private String lineCode;
    private Integer lineNumber;
    private Integer price;
    private Integer reductionPercentage;
    private Integer amount;
    private Order order;
    private Sale sale;
    private Product product;

    public OrderLine(String lineCode, Integer lineNumber, Integer price, Integer reductionPercentage, Integer amount, Order order, Sale sale, Product product) {
        setLineCode(lineCode);
        setLineNumber(lineNumber);
        setPrice(price);
        setReductionPercentage(reductionPercentage);
        setAmount(amount);
        setOrder(order);
        setSale(sale);
        setProduct(product);
    }

    public OrderLine(Integer amount, Product product) {
        this(null, null, null, null, amount, null, null, product);
    }

    public String getLineCode() {
        return lineCode;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getReductionPercentage() {
        return reductionPercentage;
    }

    public Integer getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }

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
