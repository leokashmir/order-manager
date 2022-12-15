package com.order.manager.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.ws.ServiceMode;

@Getter
@Setter
public class ItemRequest {

    private String name;
    private int quantity;

}
