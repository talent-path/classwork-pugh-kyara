package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.*;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile({"mainApp","DAOTesting"})
public interface GameDAO {

    public Game createGame(String title, String category, Integer year, List<Integer> platforms) throws InvalidIDException;
    Game getGameByID(Integer gameID) throws NullIDException, InvalidIDException;
    List<Game> getGameCollection();
    List<Game> getGameByCategory(String category) throws NullCategoryException;
    List<Game> getGameByYear(Integer year) throws NullYearException;
    void editGame(Integer gameID, String title, String category,  Integer releaseDate, List<Integer> platform) throws NullIDException, InvalidIDException, NullTitleException, NullYearException, NullCategoryException, NullPlatformException;
    void deleteGame(Integer gameID) throws NullIDException, InvalidIDException;

}
