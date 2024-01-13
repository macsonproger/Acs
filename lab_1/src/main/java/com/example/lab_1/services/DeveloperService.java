package com.example.lab_1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab_1.repositories.DeveloperRepository;
import com.example.lab_1.models.DeveloperEntity;
import com.example.lab_1.models.dto.DeveloperRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class DeveloperService {
    @Inject
    private DeveloperRepository developerRepository;


    public List<DeveloperEntity> getAll() {
        return developerRepository.findAll();
    }

    public UUID create(DeveloperRequest developerRequest) {
        DeveloperEntity developer = new DeveloperEntity(randomUUID(), developerRequest.getName());
        developerRepository.persist(developer);
        return developer.getId();
    }

    public void delete(UUID developertId) {
        developerRepository.delete(developertId);
    }
}
