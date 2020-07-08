package by.epamtc.degtyarovea.entity;

public class Criteria {
    private String product;
    private String attribute;
    private String value;

    public Criteria(String product, String attribute, String value) {
        this.product = product;
        this.attribute = attribute;
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
