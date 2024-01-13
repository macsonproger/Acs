package com.example.lr_2.models;

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
@Table(name = "developers")
public class DeveloperEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;
}
