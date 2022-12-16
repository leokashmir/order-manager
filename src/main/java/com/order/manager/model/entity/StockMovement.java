package com.order.manager.model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name ="stockmovement")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    @NotNull(message = "Campo 'quantity' deve ser Preenchido.")
    private Long quantity;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name ="id_item", referencedColumnName = "id")
    @NotNull(message = "Campo 'item' deve ser Preenchido.")
    private Item item;
}
