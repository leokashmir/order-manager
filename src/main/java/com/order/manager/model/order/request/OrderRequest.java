package com.order.manager.model.order.request;

import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.User;

import java.time.LocalDate;

public class OrderRequest {

    private Item item;
    private int quantity;
    private LocalDate creationDate;
    private User user;
}
