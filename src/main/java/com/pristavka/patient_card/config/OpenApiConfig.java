package com.pristavka.patient_card.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig
{
    @Bean
    public OpenAPI customConfiguration()
    {
        return new OpenAPI().info(new Info()
                .title("Patient_Cards application API")
                .description("REST API documentation")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact()
                        .name("Dmitriy Pristavka")
                        .email("dmytro.prystavka@faceit.com.ua")
                        .url("http://localhost:8080/swagger-ui-patient-card.html"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }

    /* @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {

        return new OpenAPI().info(new Info()
                .title("sample application API")
                .version(appVersion)
                .description(appDesciption)
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }*/
}
