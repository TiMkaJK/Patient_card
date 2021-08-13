package com.pristavka.patient_card.config;

import com.pristavka.patient_card.component.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Service
public class EmailConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    /*@Bean
    public SpringTemplateEngine springTemplateEngine() {

        var templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());

        return templateEngine;
    }
    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver(){

        var emailTemplateResolver = new SpringResourceTemplateResolver();
        emailTemplateResolver.setPrefix("/templates/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());

        return emailTemplateResolver;
    }*/

   /* @Autowired
    private MessageSource messageSource;

    @Bean
    public TemplateEngine emailTemplateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(stringTemplateResolver());
        templateEngine.setMessageSource(this.messageSource);

        return templateEngine;
    }

    @Bean
    public StringTemplateResolver stringTemplateResolver()
    {
        StringTemplateResolver resolver = new StringTemplateResolver();
        resolver.setOrder(1);
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);

        return resolver;
    }*/

    /*@Bean
    public JavaMailSender getJavaMailSender() {

        var mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.applicationProperties.getMailHost());
        mailSender.setPort(this.applicationProperties.getMailPort());
        mailSender.setUsername(this.applicationProperties.getMailUserName());
        mailSender.setPassword(this.applicationProperties.getMailPassword());

        var props = mailSender.getJavaMailProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }*/
}

