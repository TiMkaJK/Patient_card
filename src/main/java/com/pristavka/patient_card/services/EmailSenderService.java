package com.pristavka.patient_card.services;

import com.pristavka.patient_card.component.ApplicationProperties;
import com.pristavka.patient_card.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ApplicationProperties applicationProperties;

    public static final String EMAIL_TEMPLATE_PATH = "/templates/email/otp-page-template.html";
    public static final String EMAIL_SUBJECT = "OTP Password";

    @Async
    public void generateEmail(User user, List<String> otpList, Locale locale) throws MessagingException {

        String emailTemplate = getEmailTemplate(EMAIL_TEMPLATE_PATH);

        Context context = new Context(locale);
        context.setVariable("user", user);
        context.setVariable("otpList", otpList);

        String text = this.templateEngine.process(emailTemplate, context);

        sendEmail(user.getEmail(), this.applicationProperties.getMailFrom(), EMAIL_SUBJECT, text);
    }

    private String getEmailTemplate(String templatePath) {

        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(new ClassPathResource(templatePath).getInputStream());
            return new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("IOException", e);
            return null;
        }
    }

    private void sendEmail(String to, String from, String subject, String text) throws MessagingException {

        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.toString());
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(text, true);

        try {
            this.mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

