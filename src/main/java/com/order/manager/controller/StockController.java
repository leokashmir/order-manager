package com.order.manager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/v1/stock")
@Tag(name = "Stock Manage", description = " API Version 1.0")
public class StockController {


    @PostMapping("/create")
    public ResponseEntity<String> createOrder() { return  ResponseEntity.ok("Create"); }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrder() {
        return  ResponseEntity.ok("Update");
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelOrder() {
        return  ResponseEntity.ok("Cancel");
    }

    @GetMapping("/find")
    public ResponseEntity<String> findOrder() {
        return  ResponseEntity.ok("find");
    }

    @GetMapping("/list")
    public ResponseEntity<String> listOrder() {
        return  ResponseEntity.ok("list");
    }
}
