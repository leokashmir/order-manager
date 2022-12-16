package com.order.manager.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Campo 'Name' deve ser Preenchido.")
    private String name;

    @Column(name = "email")
    @NotBlank(message = "Campo 'email' deve ser Preenchido.")
    private String email;

}
