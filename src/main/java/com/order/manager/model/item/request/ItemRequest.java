package com.order.manager.model.item.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ItemRequest {

    @NotBlank(message = "Campo 'name' deve ser Preenchido.")
    private String name;

}
