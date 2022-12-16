package com.order.manager.model.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserRequest {

    private String name;
    private String email;
}
