package com.example.lab_1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab_1.models.DeveloperEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class DeveloperRepository {
    @PersistenceContext
    private EntityManager em;

    public List<DeveloperEntity> findAll() {
        return em.createQuery("select i from DeveloperEntity i", DeveloperEntity.class).getResultList();
    }

    public void persist(DeveloperEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID developersId) {
        DeveloperEntity entity = em.find(DeveloperEntity.class, developersId);
        em.remove(entity);
    }
}
