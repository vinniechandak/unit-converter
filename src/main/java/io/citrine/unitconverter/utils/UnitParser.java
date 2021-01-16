package io.citrine.unitconverter.utils;


import io.citrine.unitconverter.controllers.UnitConversionController;
import io.citrine.unitconverter.models.Response;
import io.citrine.unitconverter.models.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class UnitParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnitParser.class.getName());

    public static final String SPACE = "";
    public static final String START_BRACKETS = "\\(";
    public static final String END_BRACKETS = "\\)";

    public Response getConvertedUnitAndFactor(String input) {
        Response response = new Response();
        StringBuilder convertedUnit = new StringBuilder();
        StringBuilder factor = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (Character character: input.toCharArray()) {
            if (character.toString().equals("(")) {
                convertedUnit.append(character);
                factor.append(character);
            }
            else if (character.toString().equals("*") || character.toString().equals("/")) {
                String inputUnit = temp.toString().replaceAll(START_BRACKETS, SPACE).replaceAll(END_BRACKETS, SPACE);
                if (Unit.fromString(inputUnit) != null) {
                    Unit unit = Unit.fromString(inputUnit);
                    convertedUnit.append(unit.getSIUnit());
                    factor.append(unit.getMultiplicationFactor());
                    convertedUnit.append(character);
                    factor.append(character);
                    temp = new StringBuilder();
                }
            }
            else if (character.toString().equals(")")) {
                String inputUnit = temp.toString().replaceAll(START_BRACKETS, SPACE).replaceAll(END_BRACKETS, SPACE);
                if (Unit.fromString(inputUnit) != null) {
                    Unit unit = Unit.fromString(inputUnit);
                    convertedUnit.append(unit.getSIUnit());
                    factor.append(unit.getMultiplicationFactor());
                    convertedUnit.append(character);
                    factor.append(character);
                    temp = new StringBuilder();
                } else {
                    convertedUnit.append(character);
                    factor.append(character);
                }
            }
            else {
                temp.append(character);
            }
        }
        LOGGER.info("Converted Units :: " +  convertedUnit.toString());
        ExpressionParser parser = new SpelExpressionParser();
        Double result = parser.parseExpression(factor.toString()).getValue(Double.class);
        LOGGER.info("Multiplication Factor :: " +  result);
        response.setUnitName(convertedUnit.toString());
        response.setMultiplicationFactor(String.format("%.14f", result));
        return response;
    }

}
