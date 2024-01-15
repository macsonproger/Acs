package com.example.lr_4.repositories;

import com.example.lr_4.models.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditRepository extends JpaRepository<AuditEntity, UUID> {
}