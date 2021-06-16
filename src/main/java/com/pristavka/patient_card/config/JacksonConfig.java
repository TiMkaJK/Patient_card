package com.pristavka.patient_card.config;

import com.pristavka.patient_card.component.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

@Configuration
@ComponentScan("com.pristavka.patient_card")
public class JacksonConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    /*@Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(this.applicationProperties.getDateTimeFormat());
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(this.applicationProperties.getDateFormat())));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(this.applicationProperties.getDateTimeFormat())));
            builder.serializers(new LocalTimeSerializer(DateTimeFormatter.ofPattern(this.applicationProperties.getTimeFormat())));
        };
    }*/

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true).dateFormat(new SimpleDateFormat(this.applicationProperties.getDateFormat()));

        return builder;
    }

}

