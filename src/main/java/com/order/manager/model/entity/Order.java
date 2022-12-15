package com.order.manager.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name ="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @OneToMany
    @JoinColumn(name = "id_item")
    private Set<Item> items;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
