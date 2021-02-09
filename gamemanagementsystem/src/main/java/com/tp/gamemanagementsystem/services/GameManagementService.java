package com.tp.gamemanagementsystem.services;

import com.tp.gamemanagementsystem.daos.GameDAO;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameManagementService {
    @Autowired
    GameDAO dao;

    public Game getGameByID(Integer gameID) {
        return dao.getGameByID(gameID);
    }
}
