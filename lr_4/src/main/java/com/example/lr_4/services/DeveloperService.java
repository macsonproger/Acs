package com.example.lr_4.services;

import com.example.lr_4.models.AuditEvent;
import com.example.lr_4.models.DeveloperEntity;
import com.example.lr_4.models.dto.DeveloperRequest;
import com.example.lr_4.repositories.DeveloperRepository;
import com.example.lr_4.utils.ObjectToDomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.example.lr_4.utils.EventLogger;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class DeveloperService {
    private final ObjectMapper objectMapper;

    private final EventLogger eventLogger;

    private final DeveloperRepository developerRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(developerRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(DeveloperRequest developerRequest){
        DeveloperEntity developer = new DeveloperEntity(randomUUID(), developerRequest.getName());
        developerRepository.save(developer);
        eventLogger.log(developer, AuditEvent.CREATE);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID id) {
        DeveloperEntity developer = new DeveloperEntity(id, developerRepository.getReferenceById(id).getName());
        eventLogger.log(developer, AuditEvent.DELETE);
        developerRepository.deleteById(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public String getDevelopers(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("developers");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<DeveloperEntity> developers = developerRepository.findAll();
        for (DeveloperEntity developer : developers) {

            transformer.transform(element, developer, "developer");
        }

        model.addAttribute("developers", element);
        return "developers";
    }
}
