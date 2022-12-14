package com.order.manager.service;

import com.order.manager.sendemail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private EmailService emailService;

    @Override
    public void createOrder() {
        emailService.sendEmail();
    }
}
