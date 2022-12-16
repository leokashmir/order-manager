package com.order.manager.controller;


import com.order.manager.model.dto.ItemDTO;
import com.order.manager.model.item.request.ItemRequest;
import com.order.manager.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/v1/item")
@Tag(name = "Item Manage", description = "API Version 1.0")
public class ItemManagerController {


    @Autowired
    private ItemService service;

    @PostMapping("/create")
    public ResponseEntity<ItemDTO> insertItem(@Valid @RequestBody ItemRequest request) {
        return  ResponseEntity.ok(service.saveItem(request));
    }

    @PutMapping("/update")
    public ResponseEntity<ItemDTO> updateItem(@Valid @RequestBody ItemDTO request ) {
        return  ResponseEntity.ok(service.updateItem(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id")  Long idItem) {
        service.deleteItem(idItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ItemDTO> findItem(@PathVariable("id")  Long idItem) {
        return  ResponseEntity.ok(service.getItem(idItem));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> listItem() {
        return new ResponseEntity<List<ItemDTO>>(service.listItem(), HttpStatus.OK);
    }
}
