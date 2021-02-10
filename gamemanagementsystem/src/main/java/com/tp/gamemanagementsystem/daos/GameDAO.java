package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.models.Game;

import java.util.List;

public interface GameDAO {

    Game createGame(Game game);
    Game getGameByID(Integer gameID);
    List<Game> getGameCollection();
    List<Game> getGameByPlatform();
    List<Game> getGameByCategory();
    List<Game> getGameByYear(Integer year);
    void editGame(Integer gameID, String title, Integer releaseDate, String category, List<String> platform);
    void deleteGame(Integer gameID);

}
