package io.citrine.unitconverter.utils;

import io.citrine.unitconverter.models.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitParserTests {

    private UnitParser parser;

    @BeforeEach
    void setUp() {
        parser = new UnitParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test_getConvertedUnitAndFactor() {
        String input = "(minute/hectare)";
        Response result = parser.getConvertedUnitAndFactor(input);
        assert result.getUnitName().equals("(s/m2)");
        assert result.getMultiplicationFactor().equals("0.00600000000000");
    }

    @Test
    public void test_getConvertedUnitAndFactor_2() {
        String input = "(degree/(minute*hectare))";
        Response result = parser.getConvertedUnitAndFactor(input);
        assert result.getUnitName().equals("(rad/(s*m2))");
        assert result.getMultiplicationFactor().equals("0.00000002908882");
    }
}
