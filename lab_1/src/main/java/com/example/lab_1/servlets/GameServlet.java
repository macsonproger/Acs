package com.example.lab_1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab_1.services.GameService;
import com.example.lab_1.models.dto.GameRequest;
import com.example.lab_1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private GameService gameService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(gameService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            GameRequest gameRequest = objectMapper.readValue(is, GameRequest.class);
            gameService.create(gameRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        UUID gameId = UUID.fromString(req.getPathInfo().substring(1));
        gameService.delete(gameId);
    }
}
