package com.example.lr_4.controllers;

import com.example.lr_4.models.dto.DeveloperRequest;
import com.example.lr_4.services.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping(value = "/developers")
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAll() {
        return developerService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody DeveloperRequest developerRequest) {

        return developerService.create(developerRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return developerService.delete(id);
    }
}
