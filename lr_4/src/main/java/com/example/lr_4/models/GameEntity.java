package com.example.lr_4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class GameEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "tittle", unique = true)
    private String tittle;

    @Column(name = "dev_id")
    private UUID dev_id;
}
