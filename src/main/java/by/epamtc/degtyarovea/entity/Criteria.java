package by.epamtc.degtyarovea.entity;

public class Criteria {
    private String productType;
    private String attribute;
    private String value;

    public Criteria(String productType, String attribute, String value) {
        this.productType = productType;
        this.attribute = attribute;
        this.value = value;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
