package com.example.lr_2.controllers;

import com.example.lr_2.models.dto.DeveloperRequest;
import com.example.lr_2.services.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping("/developers")
    public ResponseEntity<String> getAll() {
        return developerService.getAll();
    }

    @PostMapping("/developers")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody DeveloperRequest developerRequest) {

        return developerService.create(developerRequest);

    }

    @DeleteMapping("/developers/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return developerService.delete(id);
    }
}
