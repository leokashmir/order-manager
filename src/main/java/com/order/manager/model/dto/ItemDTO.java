package com.order.manager.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemDTO {
    private Long id;
    private String name;
}