package com.example.lab_1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab_1.models.GameEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class GameRepository {
    @PersistenceContext
    private EntityManager em;

    public List<GameEntity> findAll() {
        return em.createQuery("select i from GameEntity i", GameEntity.class).getResultList();
    }

    public void persist(GameEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID gameId) {
        GameEntity entity = em.find(GameEntity.class, gameId);
        em.remove(entity);
    }
}
