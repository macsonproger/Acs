package com.example.lr_4.repositories;

import com.example.lr_4.models.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<GameEntity, UUID>{
}
