package com.example.lr_2.services;

import com.example.lr_2.models.GameEntity;
import com.example.lr_2.models.dto.GameRequest;
import com.example.lr_2.repositories.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class GameService {
    private final ObjectMapper objectMapper;

    private final GameRepository gameRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(gameRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(GameRequest gameRequest){
        GameEntity game = new GameEntity(randomUUID(), gameRequest.getTittle(), gameRequest.getDev_id());
        gameRepository.save(game);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID id) {
        gameRepository.deleteById(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
