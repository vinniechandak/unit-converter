package io.citrine.unitconverter.controllers;
import io.citrine.unitconverter.models.Response;
import io.citrine.unitconverter.utils.UnitParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/units")
public class UnitConversionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnitConversionController.class.getName());

    @Autowired
    private UnitParser unitParser;

    @GetMapping(value = "/si")
    public Response getConversions(@RequestParam(name = "units") String units) {
        try {
            return unitParser.getConvertedUnitAndFactor(units);
        } catch (Exception ex) {
            LOGGER.error("Invalid request for converting SI units!" + ex);
            return null;
        }
    }
}

