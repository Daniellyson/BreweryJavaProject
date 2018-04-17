package model;

public class City {
    private Integer code;
    private String name;
    private Integer codePostal;

    public City(String name, Integer codePostal) {
        setName(name);
        setCodePostal(codePostal);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
}
