package com.pristavka.patient_card.services;

import com.pristavka.patient_card.component.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ApplicationProperties applicationProperties;

    public void sendEmail(String to, String subject, String text) throws MessagingException {

        var message = this.mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.toString());

        helper.setTo(to);
        helper.setFrom(this.applicationProperties.getMailFrom());
        helper.setSubject(subject);
        helper.setText(text, true);

        try {
            this.mailSender.send(message);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

