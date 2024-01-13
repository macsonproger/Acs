package com.example.lab_1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab_1.repositories.GameRepository;
import com.example.lab_1.models.GameEntity;
import com.example.lab_1.models.dto.GameRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class GameService {
    @Inject
    private GameRepository gameRepository;

    public List<GameEntity> getAll() {
        return gameRepository.findAll();
    }

    public UUID create(GameRequest gameRequest) {
        GameEntity game = new GameEntity(randomUUID(), gameRequest.getTittle(), gameRequest.getDev_id());
        gameRepository.persist(game);
        return game.getId();
    }

    public void delete(UUID gameId) {
        gameRepository.delete(gameId);
    }
}
