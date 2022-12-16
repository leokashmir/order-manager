package com.order.manager.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String email, String text, String subject) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("leonardobarros_bhz@hotmail.com");
        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);

    }
}
