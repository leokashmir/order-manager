package com.order.manager.model.stock.request;

import com.order.manager.model.entity.Item;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class StockRequest {

    @NotBlank(message = "Campo 'item' deve ser Preenchido.")
    private Long item;
    @NotNull(message = "Campo 'quantity' deve ser Preenchido.")
    private Long quantity;

}

