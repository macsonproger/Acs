package com.example.lr_3.controllers;

import com.example.lr_3.services.DeveloperService;
import com.example.lr_3.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final DeveloperService developerService;

    private final GameService gameService;

    @GetMapping(value = "/developers_xml")
    public String getDevelopers(Model model) throws Exception {
        return developerService.getDevelopers(model);
    }

    @GetMapping(value = "/game_xml")
    public String getGames(Model model) throws Exception {
        return gameService.getGames(model);
    }
}