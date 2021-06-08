package com.pristavka.patient_card.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@Getter
public class ApplicationProperties {

    @Value("${global.date-time-format}")
    private String dateTimeFormat;

    @Value("${global.date-format}")
    private String dateFormat;

    @Value("${global.time-format}")
    private String timeFormat;

}

