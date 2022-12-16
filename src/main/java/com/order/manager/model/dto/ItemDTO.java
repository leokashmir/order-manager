package com.order.manager.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class ItemDTO {

    @NotNull(message = "Campo 'id' deve ser Preenchido.")
    private Long id;

    @NotBlank(message = "Campo 'name' deve ser Preenchido.")
    private String name;
}
