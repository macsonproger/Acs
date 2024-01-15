package com.example.lr_4.controllers;

import com.example.lr_4.models.dto.GameRequest;
import com.example.lr_4.services.GameService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAll() {
        return gameService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody GameRequest gameRequest) {

        return gameService.create(gameRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return gameService.delete(id);
    }

}
