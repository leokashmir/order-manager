package com.order.manager.model.dto;

import com.order.manager.model.entity.Item;

import java.time.LocalDate;

public class StockDTO {

    private Item item;
    private int quantity;
    private LocalDate creationDate;
}
