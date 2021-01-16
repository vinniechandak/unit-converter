package io.citrine.unitconverter.models;

public class Response {
    private String unitName;
    private String multiplicationFactor;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getMultiplicationFactor() {
        return multiplicationFactor;
    }

    public void setMultiplicationFactor(String multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }

    @Override
    public String toString() {
        return "Response{" +
                "unitName='" + unitName + '\'' +
                ", multiplicationFactor=" + multiplicationFactor +
                '}';
    }
}
