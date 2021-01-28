package com.tp.connectfour.controllers;


import com.tp.connectfour.ConnectfourApplication;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.InvalidMoveException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.services.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectFourController {

    @Autowired
    ConnectFourService service;

    @GetMapping("/game")
    public List<ConnectFourViewModel> getAllGames(@PathVariable Integer gameID)
    {

        return service.getAllGames();
    }

    @GetMapping("/game/{gameID}")
    public ConnectFourViewModel getGameById(@PathVariable Integer gameID)
    {

        return service.getGameById(gameID);
    }

    @PostMapping("/move")
    public ResponseEntity makeMove(@RequestBody MoveRequest request)
    {
        ConnectFourViewModel toReturn = null;
        try {
            toReturn = service.makeMove(request.getGameID(), request.getMove());
        } catch( InvalidMoveException | InvalidGameIdException ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ex.getMessage()));
        }
        return ResponseEntity.ok(toReturn);
    }

    @PostMapping("/begin")
    public ConnectFourViewModel startGame()
    {
        ConnectFourViewModel game = null;
        try{
            game = service.startGame();
        }catch (NullBoardException e)
        {
            e.printStackTrace();
        }
        return game;
    }

    @DeleteMapping("/delete/{gameID}")
    public String delete(@PathVariable Integer gameID)
    {
        try{
            service.deleteGame(gameID);
            return "Game" + gameID + " successfully deleted";
        }catch(InvalidGameIdException e)
        {
            return e.getMessage();
        }
    }


}
