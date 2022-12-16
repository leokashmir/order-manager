package com.order.manager.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Campo 'Name' deve ser Preenchido.")
    private String name;

    @Column(name = "email")
    @NotNull(message = "Campo 'email' deve ser Preenchido.")
    private String email;


    public User (Long id){
        this.id = id;
    }

}
