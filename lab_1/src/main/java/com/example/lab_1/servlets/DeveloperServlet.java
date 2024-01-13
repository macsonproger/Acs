package com.example.lab_1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab_1.services.DeveloperService;
import com.example.lab_1.models.dto.DeveloperRequest;
import com.example.lab_1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "developerServlet", value = "/developers")
public class DeveloperServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private DeveloperService developerService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(developerService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            DeveloperRequest developerRequest = objectMapper.readValue(is, DeveloperRequest.class);
            developerService.create(developerRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        UUID developerId = UUID.fromString(req.getPathInfo().substring(1));
        developerService.delete(developerId);
    }
}
