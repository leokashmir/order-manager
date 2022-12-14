package com.order.manager.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("leonardobarrosbhz@gmail.com");
        msg.setTo("leonardobarros_bhz@hotmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
}
