package com.order.manager.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Order {


    private Long id;
    private LocalDate creationDate;
    private Item item;
    private Long quantity;
    private User user;
}
