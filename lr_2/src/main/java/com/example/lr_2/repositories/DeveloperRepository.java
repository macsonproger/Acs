package com.example.lr_2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lr_2.models.DeveloperEntity;
import java.util.List;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID> {
}
