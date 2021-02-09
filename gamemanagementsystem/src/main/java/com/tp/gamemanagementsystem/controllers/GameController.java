package com.tp.gamemanagementsystem.controllers;

import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.services.GameManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameManagementService service;

    @GetMapping("/game")
    public List<Game> getGameCollection()
    {
        return service.getGameCollection();
    }

    @GetMapping("/game/{id}")
    public Game getGameByID(@PathVariable Integer gameID)
    {
        return service.getGameByID(gameID);
    }

}
