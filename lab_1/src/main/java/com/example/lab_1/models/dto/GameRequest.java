package com.example.lab_1.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GameRequest {
    private String tittle;
    private UUID dev_id;
}
