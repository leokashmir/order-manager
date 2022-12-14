package com.order.manager.model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StockMovement {

    private Long id;
    private Long quantity;
    private LocalDate creationDate;
    private Item item;
}
