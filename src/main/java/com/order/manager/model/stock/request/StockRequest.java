package com.order.manager.model.stock.request;

import com.order.manager.model.entity.Item;

import java.time.LocalDate;

public class StockRequest {

    private Item item;
    private int quantity;
    private LocalDate creationDate;
}

