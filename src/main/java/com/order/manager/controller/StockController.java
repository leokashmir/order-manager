package com.order.manager.controller;

import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.stock.request.StockRequest;
import com.order.manager.service.impl.StockServiceImpl;
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
@RequestMapping("/v1/stock")
@Tag(name = "Stock Manage", description = " API Version 1.0")
public class StockController {


    @Autowired
    private StockServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<StockDTO> createStock(@Valid @RequestBody StockRequest request) {
        return  ResponseEntity.ok(service.saveStock(request));
    }

    @PutMapping("/update")
    public ResponseEntity<StockDTO> updateStock(@Valid @RequestBody StockDTO request) {
        return  ResponseEntity.ok(service.updateStock(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelStock(@PathVariable("id")  Long idStock) {
        service.deleteStock(idStock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StockDTO> findStock(@PathVariable("id")  Long idStock) {
        return  ResponseEntity.ok(service.getStock(idStock));
    }

    @GetMapping("/list")
    public ResponseEntity<List<StockDTO>> listStock() {
        return new ResponseEntity<List<StockDTO>>(service.listStock(), HttpStatus.OK);
    }
}
