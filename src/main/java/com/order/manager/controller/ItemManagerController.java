package com.order.manager.controller;


import com.order.manager.model.request.ItemRequest;
import com.order.manager.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/item")
@Tag(name = "Item Manage", description = " Micro-Service - Version 1.0")
public class ItemManagerController {

    @Autowired
    private ItemService service;

    @PostMapping("/add")
    public ResponseEntity<String> insertItem(@RequestBody ItemRequest request) {
        service.saveItem(request);
        return  ResponseEntity.ok("Create");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateItem() {
        return  ResponseEntity.ok("Update");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem() {
        return  ResponseEntity.ok("Cancel");
    }

    @GetMapping("/find")
    public ResponseEntity<String> findItem() {
        return  ResponseEntity.ok("find");
    }

    @GetMapping("/list")
    public ResponseEntity<String> listItem() {
        return  ResponseEntity.ok("list");
    }
}
