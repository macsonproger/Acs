package com.example.lr_4.models;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteMessage extends AuditMessage {

    private Object deletedObject;


    @Override
    public String getInfo() {
        return "объект удален %s".formatted(deletedObject);
    }

}
