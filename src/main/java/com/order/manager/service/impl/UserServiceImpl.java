package com.order.manager.service.impl;

import com.order.manager.exceptions.GenericException;
import com.order.manager.model.dto.UserDTO;
import com.order.manager.model.entity.User;
import com.order.manager.model.user.request.UserRequest;
import com.order.manager.repository.UserRepository;
import com.order.manager.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO saveUser(UserRequest request) {
        User usr = repository.save(convertToModel(request));
        return convertToResponse(usr);
    }

    @Override
    public UserDTO updateUser(UserDTO request) {
        User usr = repository.save(convertToModel(request));
        return convertToResponse(usr);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> listUser() {
        List<User> userList = repository.findAll();
        return userList.stream().map(usr ->
                UserDTO.builder()
                        .id(usr.getId())
                        .name(usr.getName())
                        .email(usr.getEmail())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long id) {
        Optional<User> op = repository.findById(id);
        return convertToResponse(op.orElseThrow(GenericException::new));
    }
    
    
    private User convertToModel(UserRequest req){
        User usr = new User();
        usr.setName(req.getName());
        usr.setEmail(req.getEmail());
        return usr;
    }

    private User convertToModel(UserDTO dto){
        User usr = new User();
        usr.setId(dto.getId());
        usr.setName(dto.getName());
        usr.setEmail(dto.getEmail());
        return usr;
    }

    private UserDTO convertToResponse(User usr){
        return UserDTO.builder()
                .id(usr.getId())
                .name(usr.getName())
                .email(usr.getEmail())
                .build();
    }
}
