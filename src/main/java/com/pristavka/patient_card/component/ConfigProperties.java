package com.pristavka.patient_card.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
@Getter
public class ConfigProperties
{
    @Value("${admin}")
    private String admin;

    @Value("${login}")
    private String login;

    @Value("${user}")
    private String user;

    @Value("${success}")
    private String success;

    @Value("${registration}")
    private String registration;

    @Value("${admin.url}")
    private String adminUrl;

    @Value("${success.url}")
    private String successUrl;

    @Value("${login.url}")
    private String loginUrl;

    @Value("${user.url}")
    private String userUrl;

    @Value("${registration.url}")
    private String registrationUrl;

    @Value("${language.pattern}")
    private String languagePattern;

    @Value("${default.url}")
    private String defaultUrl;
}

