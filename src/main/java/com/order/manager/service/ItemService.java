package com.order.manager.service;

import com.order.manager.model.item.request.ItemRequest;
import com.order.manager.model.dto.ItemDTO;

import java.util.List;


public interface ItemService {

    ItemDTO saveItem(ItemRequest request);
    ItemDTO updateItem(ItemDTO request);
    void deleteItem(Long id);
    List<ItemDTO> listItem();
    ItemDTO getItem(Long id);
}
