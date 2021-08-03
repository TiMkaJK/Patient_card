package com.pristavka.patient_card.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationProperties {

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private Integer mailPort;

    @Value("${spring.mail.username}")
    private String mailUserName;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Value("${spring.mail.from}")
    private String mailFrom;

    @Value("${spring.elasticsearch.rest.uris}")
    private String esHostAndPort;

    @Value("${spring.elasticsearch.rest.username}")
    private String esUsername;

    @Value("${spring.elasticsearch.rest.password}")
    private String esPassword;

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;
}

