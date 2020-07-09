package by.epamtc.degtyarovea.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria criteria = (Criteria) o;
        return Objects.equals(productType, criteria.productType) &&
                Objects.equals(attribute, criteria.attribute) &&
                Objects.equals(value, criteria.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, attribute, value);
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "productType='" + productType + '\'' +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
