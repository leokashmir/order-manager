package com.order.manager.model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private Long quantity;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name ="id_item", referencedColumnName = "id")
    private Item item;
}
