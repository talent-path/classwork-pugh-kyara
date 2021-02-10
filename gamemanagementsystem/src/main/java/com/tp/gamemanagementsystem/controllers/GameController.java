package com.tp.gamemanagementsystem.controllers;

import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.services.GameManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameManagementService service;

    @PostMapping("/newgame")
    public Game getGameCollection(@RequestBody Game newGame)
    {
        return service.createGame(newGame);
    }

    @GetMapping("/game")
    public List<Game> getGameCollection()
    {
        return service.getGameCollection();
    }

    @GetMapping("/game/{gameID}")
    public Game getGameByID(@PathVariable Integer gameID)
    {
        return service.getGameByID(gameID);
    }

    @GetMapping("/game/year/{year}")
    public List<Game> getGameByYear(@PathVariable Integer year)
    {
        return service.getGameByYear(year);
    }

}
