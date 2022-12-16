package com.order.manager.model.dto;

import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.User;

import java.time.LocalDate;

public class OrderDTO {

    private long id;
    private Item item;
    private int quantity;
    private LocalDate creationDate;
    private User user;
}
