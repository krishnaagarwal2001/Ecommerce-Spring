package com.example.EcommerceSpring.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
    The annotation @ConfigurationProperties in Spring Boot is used for mapping external
    configuration (like application.properties, application.yml, or environment variables)
    into a strongly-typed Java object.

    It tells Spring Boot:
    “Take all the properties with a given prefix, bind them to fields in this Java class, and manage it as a bean.”

    Spring Boot has a concept called the Environment abstraction, which loads properties from multiple sources and merges them.

    When you use @ConfigurationProperties, Spring Boot doesn’t care whether the value came from .env,
    application.properties, application.yml, system environment variables, or command-line args
    — it just asks the Environment for the value.
*/

@Component
@ConfigurationProperties(prefix = "fake-store")
public class FakeStoreConfig {
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
