package com.order.manager.controller;

import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/order")
@Tag(name = "Order Manage", description = " API Version 1.0")
public class OrderManagerController {

    @Autowired
    private OrderServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderRequest request) {
        return  ResponseEntity.ok(service.saveOrder(request));
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDTO> updateOrder(@Valid @RequestBody OrderDTO request) {
        return  ResponseEntity.ok(service.updateOrder(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable("id")  Long idOrder) {
        service.deleteOrder(idOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<OrderDTO> findOrder(@PathVariable("id")  Long idOrder) {
        return  ResponseEntity.ok(service.getOrder(idOrder));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderDTO>> listOrder() {
        return new ResponseEntity<List<OrderDTO>>(service.listOrder(), HttpStatus.OK);
    }

}
