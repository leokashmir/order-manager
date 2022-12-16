package com.order.manager.service.impl;

import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.sendemail.EmailService;
import com.order.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private EmailService emailService;


    @Override
    public OrderDTO saveOrder(OrderRequest request) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO request) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public List<OrderDTO> listOrder() {
        return null;
    }

    @Override
    public OrderDTO getOrder(Long id) {
        return null;
    }
}
