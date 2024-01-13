package com.example.lr_2.services;

import com.example.lr_2.repositories.DeveloperRepository ;
import com.example.lr_2.models.DeveloperEntity;
import com.example.lr_2.models.dto.DeveloperRequest;
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
public class DeveloperService {
    private final ObjectMapper objectMapper;

    private final DeveloperRepository developerRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(developerRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(DeveloperRequest developerRequest){
        DeveloperEntity developer = new DeveloperEntity(randomUUID(), developerRequest.getName());
        developerRepository.save(developer);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID id) {
        developerRepository.deleteById(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
