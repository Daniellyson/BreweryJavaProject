package model;

public class Product {
    private String code;
    private String name;
    private Double price;
    private Double reductionPercentage;
    private Integer amountInventory;

    public Product(String name, Double reductionPercentage, Double price) {
        this(null, name, price, reductionPercentage, null);
    }

    public Product(String name) {
        this(null, name);
    }

    public Product(String code, String name) {
        this(code, name, null, null, null);
    }

    public Product(String code, String name, Double price, Double reductionPercentage, Integer amountInventory) {
        setCode(code);
        setName(name);
        setPrice(price);
        setReductionPercentage(reductionPercentage);
        setAmountInventory(amountInventory);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setReductionPercentage(Double reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public void setAmountInventory(Integer amountInventory) {
        this.amountInventory = amountInventory;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getReductionPercentage() {
        return reductionPercentage;
    }

    public Integer getAmountInventory() {
        return amountInventory;
    }
}
