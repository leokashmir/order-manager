package com.order.manager.service.impl;

import com.order.manager.exceptions.GenericException;
import com.order.manager.model.dto.ItemDTO;
import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.Order;
import com.order.manager.model.item.request.ItemRequest;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.repository.OrderRepository;
import com.order.manager.sendemail.EmailService;
import com.order.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderRepository repository;


    @Override
    public OrderDTO saveOrder(OrderRequest request) {
        Order order =  repository.save( convertToModel(request) );
        return convertToResponse(order);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO request) {
        Order order =  repository.save( convertToModel(request) );
        return convertToResponse(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<OrderDTO> listOrder() {

        List<Order> lstOrder = repository.findAll();

        return lstOrder.stream().map( obj ->
                OrderDTO.builder()
                        .id(obj.getId())
                        .user(obj.getUser())
                        .creationDate(obj.getCreationDate())
                        .item(obj.getItem())
                        .quantity(obj.getQuantity())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Optional<Order> op = repository.findById(id);
        return convertToResponse(op.orElseThrow(GenericException::new));
    }


    private Order convertToModel(OrderRequest request){
        Order order = new Order();
        order.setUser(request.getUser());
        order.setItem(request.getItem());
        order.setQuantity(request.getQuantity());
        order.setCreationDate(LocalDate.now());
        return order;
    }

    private Order convertToModel(OrderDTO request){
        Order order = new Order();
        order.setId(request.getId());
        order.setUser(request.getUser());
        order.setItem(request.getItem());
        order.setQuantity(request.getQuantity());

        return order;
    }

    private OrderDTO convertToResponse(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .quantity(order.getQuantity())
                .creationDate(order.getCreationDate())
                .item(order.getItem())
                .user(order.getUser())
                .build();
    }
}
