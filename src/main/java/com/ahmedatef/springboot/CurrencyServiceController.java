package com.ahmedatef.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyServiceController {

    @Autowired
    private CurrencyServiceConfiguration currencyConfiguration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration getCurrencyConfiguration() {
        return currencyConfiguration;
    }

}