package io.citrine.unitconverter.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {
    public static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String error() {
        return "Something went wrong! Please contact Citrine Support team!";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
