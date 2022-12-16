package com.order.manager.model.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
public class UserRequest {

    @NotBlank(message = "Campo 'name' deve ser Preenchido.")
    private String name;
    @NotBlank(message = "Campo 'email' deve ser Preenchido.")
    private String email;
}
