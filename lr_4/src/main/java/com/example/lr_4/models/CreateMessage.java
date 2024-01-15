package com.example.lr_4.models;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateMessage extends AuditMessage {

    private Object createdObject;

    @Override
    public String getInfo() {
        return "объект создан %s".formatted(createdObject);
    }

}
