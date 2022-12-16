package com.order.manager.model.dto;

import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Getter @Setter
public class OrderDTO {

    @NotNull(message = "Campo 'id' deve ser Preenchido.")
    private long id;

    @NotBlank(message = "Campo 'item' deve ser Preenchido.")
    private Item item;

    @NotNull(message = "Campo 'quantity' deve ser Preenchido.")
    private int quantity;


    private LocalDate creationDate;

    @NotBlank(message = "Campo 'user' deve ser Preenchido.")
    private User user;
}
