package model;

public class City {
    private Integer code;
    private String name;
    private Integer postCode;

    public City(String name, Integer postCode) {
        setName(name);
        setPostCode(postCode);
    }

    public City(Integer code, Integer postCode,  String name) {
        setCode(code);
        setName(name);
        setPostCode(postCode);
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getPostCode() {
        return postCode;
    }
}
