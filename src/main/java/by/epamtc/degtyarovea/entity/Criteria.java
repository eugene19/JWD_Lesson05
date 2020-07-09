package by.epamtc.degtyarovea.entity;

import java.util.Objects;

public class Criteria {
    private String deviceType;
    private String attribute;
    private String value;

    public Criteria(String deviceType, String attribute, String value) {
        this.deviceType = deviceType;
        this.attribute = attribute;
        this.value = value;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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
        return Objects.equals(deviceType, criteria.deviceType) &&
                Objects.equals(attribute, criteria.attribute) &&
                Objects.equals(value, criteria.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, attribute, value);
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "productType='" + deviceType + '\'' +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
