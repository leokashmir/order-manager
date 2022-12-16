package com.order.manager.service;


import com.order.manager.model.dto.ItemDTO;
import com.order.manager.model.user.request.UserRequest;
import com.order.manager.model.dto.UserDTO;

import java.util.List;

public interface UserService {


    UserDTO saveUser(UserRequest request);
    UserDTO updateUser(UserDTO request);
    void deleteUser(Long id);
    List<UserDTO> listUser();
    UserDTO getUser(Long id);
}
