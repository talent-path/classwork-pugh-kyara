package com.tp.gamemanagementsystem.controllers;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import com.tp.gamemanagementsystem.services.GameManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatformController {
    @Autowired
    GameManagementService service;

    @GetMapping("platform/id")
    public ResponseEntity getPlatformByID(@RequestBody Integer platID)
    {
        Platform plat = null;
        try {
            plat = service.getPlatformByID(platID);
        }
        catch (InvalidIDException | NullIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(plat);
    }

    //get all the games on one platform by the platform's ID
    @GetMapping("platform/games")
    public ResponseEntity getPlatformGamesByID(@RequestBody Platform somePlatform)
    {
        List<Game> allGames = null;
        try {
            allGames = service.getGamesByPlatformID(somePlatform);
        }
        catch (InvalidIDException | NullIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(allGames);
    }
}
