package com.tp.gamemanagementsystem.services;

import com.tp.gamemanagementsystem.daos.GameDAO;
import com.tp.gamemanagementsystem.exceptions.InvalidGameIDException;
import com.tp.gamemanagementsystem.exceptions.NullGameIDException;
import com.tp.gamemanagementsystem.exceptions.NullYearException;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameManagementService {
    @Autowired
    GameDAO dao;

    public List<Game> getGameCollection() {
        return dao.getGameCollection();
    }

    public Game getGameByID(Integer gameID) throws NullGameIDException, InvalidGameIDException {

            Game game = dao.getGameByID(gameID);
            return game;
    }


    public Game createGame(Game newGame) {

        return dao.createGame(newGame);
    }

    public List<Game> getGameByYear(Integer year) throws NullYearException {
        return dao.getGameByYear(year);
    }
}
