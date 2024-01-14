package com.example.lr_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lr_3.models.DeveloperEntity;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID> {
}
