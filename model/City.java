package model;

public class City {
    private Integer code;
    private String name;
    private Integer postCode;

    public City(String name, Integer postCode) {
        setName(name);
        setCodePostal(postCode);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodePostal(Integer postCode) {
        this.postCode = postCode;
    }
}
