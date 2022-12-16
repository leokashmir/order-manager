package com.order.manager.service;


import com.order.manager.model.dto.ItemDTO;
import com.order.manager.model.user.request.UserRequest;
import com.order.manager.model.dto.UserDTO;

import java.util.List;

public interface UserService {


    UserDTO saveItem(UserRequest request);
    UserDTO updateItem(UserDTO request);
    void deleteItem(Long id);
    List<UserDTO> listItem();
    ItemDTO getItem(Long id);
}
