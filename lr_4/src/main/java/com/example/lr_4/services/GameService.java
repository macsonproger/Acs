package com.example.lr_4.services;

import com.example.lr_4.models.AuditEvent;
import com.example.lr_4.models.GameEntity;
import com.example.lr_4.models.dto.GameRequest;
import com.example.lr_4.repositories.GameRepository;
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
public class GameService {
    private final ObjectMapper objectMapper;

    private final EventLogger eventLogger;

    private final GameRepository gameRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(gameRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(GameRequest gameRequest){
        GameEntity game = new GameEntity(randomUUID(), gameRequest.getTittle(), gameRequest.getDev_id());
        gameRepository.save(game);
        eventLogger.log(game, AuditEvent.CREATE);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID id) {
        GameEntity game = new GameEntity(id, gameRepository.getReferenceById(id).getTittle(),gameRepository.getReferenceById(id).getDev_id());
        eventLogger.log(game, AuditEvent.DELETE);
        gameRepository.deleteById(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public String getGames(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("games");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<GameEntity> games = gameRepository.findAll();
        for (GameEntity game : games) {

            transformer.transform(element, game, "game");
        }

        model.addAttribute("games", element);
        return "games";
    }
}
