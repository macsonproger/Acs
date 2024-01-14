package com.example.lr_3.models.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class GameRequest {
    private String tittle;
    private UUID dev_id;
}
