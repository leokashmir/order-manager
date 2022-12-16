package com.order.manager.model.order.request;

import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class OrderRequest {

    @NotNull(message = "Campo 'item' deve ser Preenchido.")
    private Long itemId;
    @NotNull(message = "Campo 'quantity' deve ser Preenchido.")
    private Long quantity;
    @NotNull(message = "Campo 'user' deve ser Preenchido.")
    private Long userId;
}
