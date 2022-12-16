package com.order.manager.service.impl;

import com.order.manager.exceptions.GenericException;
import com.order.manager.model.entity.Item;
import com.order.manager.model.item.request.ItemRequest;
import com.order.manager.model.dto.ItemDTO;
import com.order.manager.repository.ItemRepository;
import com.order.manager.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository repository;

    @Override
    public ItemDTO saveItem(ItemRequest request) {
        Item item =  repository.save( convertToModel(request) );
        return convertToResponse(item);
    }


    public ItemDTO updateItem(ItemDTO request) {
        Item item =  repository.save( convertToModel(request) );
        return convertToResponse(item);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ItemDTO> listItem() {
        List<Item> lsItem = repository.findAll();

        return lsItem.stream().map( obj ->
             ItemDTO.builder()
                    .id(obj.getId())
                    .name(obj.getName())
                    .build()
        ).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItem(Long id) {
        Optional<Item> op = repository.findById(id);
        return convertToResponse(op.orElseThrow(GenericException::new));
    }


    private Item convertToModel(ItemRequest request){
        Item item = new Item();
        item.setName(request.getName());
        return item;
    }

    private Item convertToModel(ItemDTO request){
        Item item = new Item();
        item.setName(request.getName());
        item.setId(request.getId());
        return item;
    }

    private ItemDTO convertToResponse(Item item){
        return ItemDTO.builder()
                .name(item.getName())
                .id(item.getId())
                .build();
    }

}
