package com.arpit.spring.cloud.config.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @Autowired
    ConfigProperties configProperties;

    @Value("${some.other.property}")
    private String someOtherProperty;


    @GetMapping
    @RefreshScope
    public String getProperties()
    {
        return configProperties.getProperty() +" || " + someOtherProperty;
    }


}
