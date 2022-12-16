package com.order.manager.model.dto;

import com.order.manager.model.entity.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter @Builder
public class StockDTO {

    @NotNull(message = "Campo 'id' deve ser Preenchido.")
    private Long id;
    @NotBlank(message = "Campo 'item' deve ser Preenchido.")
    private Item item;
    @NotNull(message = "Campo 'quantity' deve ser Preenchido.")
    private Long quantity;

    private LocalDate creationDate;
}
