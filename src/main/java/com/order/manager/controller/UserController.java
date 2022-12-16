package com.order.manager.controller;


import com.order.manager.model.dto.ItemDTO;
import com.order.manager.model.dto.UserDTO;
import com.order.manager.model.item.request.ItemRequest;
import com.order.manager.model.user.request.UserRequest;
import com.order.manager.service.UserService;
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
@RequestMapping("/v1/user")
@Tag(name = "User Manage", description = "API Version 1.0")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRequest request) {
        return  ResponseEntity.ok(service.saveUser(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO request) {
        return  ResponseEntity.ok(service.updateUser(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelUser(@PathVariable("id")  Long idUser) {
        service.deleteUser(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable("id")  Long idUser) {
        return  ResponseEntity.ok(service.getUser(idUser));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUser() {
        return new ResponseEntity<List<UserDTO>>(service.listUser(), HttpStatus.OK);
    }
}
