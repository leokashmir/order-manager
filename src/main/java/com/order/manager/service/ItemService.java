package com.order.manager.service;

import com.order.manager.model.request.ItemRequest;


public interface ItemService {

    void saveItem(ItemRequest request);

    void  deleteItem();

    void  updateItem();

    void  listItem();

    void  getItem();
}
