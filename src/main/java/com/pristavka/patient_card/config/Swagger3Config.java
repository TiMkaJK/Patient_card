package com.pristavka.patient_card.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.regex;

@Configuration
@EnableSwagger2
public class Swagger3Config
{
    @Bean
    public Docket productApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pristavka.patient_card"))
                .paths(regex("/rest.*"))
                .build();
    }
}

