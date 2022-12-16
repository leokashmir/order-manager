package com.order.manager.enums;

public enum MessageEmailEnum {

    ORDER_OK("Sua orderm foi processada com sucesso."),
    ORDER_ERRO("Sua orderm  não foi processada.");

    private final String description;

    MessageEmailEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
