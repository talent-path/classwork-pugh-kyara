package com.tp.gamemanagementsystem.controllers;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullCategoryException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullYearException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import com.tp.gamemanagementsystem.services.GameManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.CreateGameRequest;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameManagementService service;

    @PostMapping("/newgame")
    public Game createGame(@RequestBody CreateGameRequest request)
    {
        Game toReturn = null;
        try {
            toReturn = service.createGameAlt(request.getGameID(), request.getTitle(), request.getCategory(),request.getReleaseYear(), request.getPlatforms());
        }catch (InvalidIDException e)
        {
            e.getMessage();
        }
        return toReturn;
    }

    @GetMapping("/game")
    public List<Game> getGameCollection()
    {
        return service.getGameCollection();
    }

    @GetMapping("/game/id")
    public ResponseEntity getGameByID(@RequestBody Integer gameID)
    {
        Game game =null;
        try {
            game = service.getGameByID(gameID);
        }
        catch (InvalidIDException | NullIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(game);
    }

    @GetMapping("game/title")
    public ResponseEntity getGameByTitle(@RequestBody String title)
    {
        List<Game> game =null;
        try {
            game = service.getGameByCategory(title);
        }
        catch (NullCategoryException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(game);
    }

    @GetMapping("game/category")
    public ResponseEntity getGameByCategory(@RequestBody String category)
    {
        List<Game> game =null;
        try {
            game = service.getGameByCategory(category);
        }
        catch (NullCategoryException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(game);
    }


    @GetMapping("/game/year")
    public ResponseEntity getGameByYear(@RequestBody Integer year)
    {
        List<Game> game =null;
        try {
            game = service.getGameByYear(year);
        }
        catch (NullYearException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(game);
    }

}
