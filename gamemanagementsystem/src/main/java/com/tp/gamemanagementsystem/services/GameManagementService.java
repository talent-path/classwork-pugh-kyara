package com.tp.gamemanagementsystem.services;

import com.tp.gamemanagementsystem.daos.GameDAO;
import com.tp.gamemanagementsystem.daos.PlatformDAO;
import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullCategoryException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullYearException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameManagementService {
    @Autowired
    GameDAO dao;

    @Autowired
    PlatformDAO platdao;

    public List<Game> getGameCollection() {
        return dao.getGameCollection();
    }

    public Game getGameByID(Integer gameID) throws NullIDException, InvalidIDException {

            Game game = dao.getGameByID(gameID);
            return game;
    }


    public Game createGame(Game newGame) {

        return dao.createGame(newGame);
    }

    public List<Game> getGameByYear(Integer year) throws NullYearException {
        return dao.getGameByYear(year);
    }

    public List<Game> getGameByCategory(String category) throws NullCategoryException {
        return dao.getGameByCategory(category);
    }

    public Platform getPlatformByID(Integer platID) throws NullIDException, InvalidIDException{
        return platdao.getPlatformByID(platID);
    }
}
