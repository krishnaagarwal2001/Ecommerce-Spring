package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
     @EnableJpaAuditing --> enables JPA auditing features (createdAt, updatedAt)
*/
@SpringBootApplication
@EnableJpaAuditing
public class EcommerceSpringApplication {

    private static void loadEnvironmentVariables(){
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }

    public static void main(String[] args) {

        loadEnvironmentVariables() ;

        SpringApplication.run(EcommerceSpringApplication.class, args);
    }
}
