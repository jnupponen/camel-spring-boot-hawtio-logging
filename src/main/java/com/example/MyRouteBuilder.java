package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

    // See property file in src/main/resources/application.yml
    @Value("${my.property}")
    private String myProperty;
    
    @Override
    public void configure() {
        from("timer:trigger")
        .transform().constant(myProperty)
        .to("log:out");
    }
}
