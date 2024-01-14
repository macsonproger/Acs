package com.example.lr_3.repositories;

import com.example.lr_3.models.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GameRepository extends JpaRepository<GameEntity, UUID> {
}
