package com.order.manager.service.impl;

import com.order.manager.enums.MessageEmailEnum;
import com.order.manager.exceptions.GenericException;
import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.dto.UserDTO;
import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.Order;
import com.order.manager.model.entity.User;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.repository.OrderRepository;
import com.order.manager.sendemail.EmailService;
import com.order.manager.service.ItemService;
import com.order.manager.service.OrderService;
import com.order.manager.service.StockService;
import com.order.manager.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;


    @Override
    public OrderDTO saveOrder(OrderRequest request) {
        logger.info("======= > Init SaveOrder");
        StockDTO stock = checkStock(request);


        if(Objects.isNull(stock)){
            throw new GenericException("Item sem estoque.");
        }

        UserDTO user = userService.getUser(request.getUserId());

        if(Objects.isNull(user)){
            throw new GenericException("Usuario não esta cadastrado.");
        }

        if(request.getQuantity() > stock.getQuantity()){
            throw new GenericException("Item insuficiente para criar a Order.");
        }





        Order order =  repository.save( convertToModel(request) );

        try {
            logger.info("======= > Stock Movements ====== ");
            logger.info("======= > Atual: " + stock.getItem().getName() + ": " + stock.getQuantity());

            Long stockQtd = stock.getQuantity() - request.getQuantity();
            stock.setQuantity(stockQtd);

            stockService.updateStock(stock);
            logger.info("======= > Atualizado: " + stock.getItem().getName() + ": " + stock.getQuantity());
        }catch (Exception e){

            logger.error("======= > Stock não esta disponivel.");
            throw new GenericException("Stock não foi atualizado");

        }

        this.sendEmail(user, MessageEmailEnum.ORDER_OK.getDescription(), order.getId() );

        logger.info("======= > Order Completed " + order.getId());
        logger.info("======= > End SaveOrder ======");
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
        order.setUser(new User(request.getUserId()));
        order.setItem(new Item(request.getItemId()));
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

    private StockDTO checkStock(OrderRequest request){
        return stockService.findByItem(new Item(request.getItemId()));

    }


    private void sendEmail(UserDTO user, String msg, Long numOrder){
       logger.info("======= > Enviando email: "+ user.getEmail() + " Order ==> "+ numOrder);
        try {
           StringBuilder mens = new StringBuilder();

           mens.append("Order: ").append(numOrder).append("\n");
           mens.append(msg);

           emailService.sendEmail(user.getEmail(), mens.toString(), "order requested successfully");
       }catch (Exception ex){
           logger.error("======= > Erro ao enviar email para: " + user.getEmail() + " Order ==> "+ numOrder);
           throw new GenericException("Envio de Email esta indisponivel no momento.");
       }
    }
}
