package com.order.manager.service;

import com.order.manager.model.entity.Item;
import com.order.manager.model.request.ItemRequest;
import com.order.manager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public void saveItem(ItemRequest request) {
        Item item = new Item();
        item.setName(request.getName());
        repository.save(item);
    }

    @Override
    public void deleteItem() {

    }

    @Override
    public void updateItem() {

    }

    @Override
    public void listItem() {

    }

    @Override
    public void getItem() {

    }
}
