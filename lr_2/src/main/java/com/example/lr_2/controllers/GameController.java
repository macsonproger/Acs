package com.example.lr_2.controllers;

import com.example.lr_2.models.dto.GameRequest;
import com.example.lr_2.services.GameService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor

public class GameController {
    private final GameService gameService;

    @GetMapping("/game")
    public ResponseEntity<String> getAll() {
        return gameService.getAll();
    }

    @PostMapping("/game")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody GameRequest gameRequest) {

        return gameService.create(gameRequest);

    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return gameService.delete(id);
    }
}
