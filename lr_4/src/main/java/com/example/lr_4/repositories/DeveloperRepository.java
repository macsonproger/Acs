package com.example.lr_4.repositories;

import com.example.lr_4.models.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID>{
}
