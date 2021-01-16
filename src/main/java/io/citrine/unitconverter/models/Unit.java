package io.citrine.unitconverter.models;

public enum Unit {

    MINUTE("minute", "min", "s", 60.0),
    HOUR("hour", "h", "s", 3600.0),
    DAY("day", "d", "s", 86400.0),
    DEGREE("degree", "O", "rad", Math.PI/180),
    ARCMINUTE("arcminute", "\'", "rad", Math.PI/10800),
    ARCSECOND("arcsecond", "\"", "rad", Math.PI/648000),
    HECTARE("hectare", "ha", "m2", 10000.0),
    LITRE("litre", "L", "m3", 0.001),
    TONNE("tonne", "t", "kg", 1000.0);

    private final String unitName;
    private final String symbol;
    private final String siUnit;
    private final Double multiplicationFactor;

    Unit(String unitName, String symbol, String siUnit, Double multiplicationFactor) {
        this.unitName = unitName;
        this.symbol = symbol;
        this.siUnit = siUnit;
        this.multiplicationFactor = multiplicationFactor;
    };

    public String getSIUnit() {
        return this.siUnit;
    }

    public Double getMultiplicationFactor() {
        return this.multiplicationFactor;
    }

    public static Unit fromString(String value) {
        for (Unit unit : Unit.values()) {
            if (unit.unitName.equals(value) || unit.symbol.equals(value)) {
                return unit;
            }
        }
        return null;
    }

}
