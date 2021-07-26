package com.pristavka.patient_card.config;

import com.pristavka.patient_card.component.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public TemplateEngine emailTemplateEngine() {

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        templateEngine.setTemplateResolver(stringTemplateResolver());
        templateEngine.setMessageSource(this.messageSource);

        return templateEngine;
    }

    @Bean
    public StringTemplateResolver stringTemplateResolver() {

        StringTemplateResolver resolver = new StringTemplateResolver();

        resolver.setOrder(1);
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);

        return resolver;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.applicationProperties.getMailHost());
        mailSender.setPort(this.applicationProperties.getMailPort());
        mailSender.setUsername(this.applicationProperties.getMailUserName());
        mailSender.setPassword(this.applicationProperties.getMailPassword());

        Properties properties = mailSender.getJavaMailProperties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        return mailSender;
    }
}

