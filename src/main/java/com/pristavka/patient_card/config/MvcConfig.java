package com.pristavka.patient_card.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/auth/login").setViewName("login");
        registry.addViewController("/auth/admin").setViewName("admin");
        registry.addViewController("/auth/user").setViewName("user");
        registry.addViewController("/auth/success").setViewName("success");
    }
}

