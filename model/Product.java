package model;

public class Product {
    private String code;
    private String name;
    private Integer price;
    private Integer reductionPercentage;
    private Integer amount;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
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
}
