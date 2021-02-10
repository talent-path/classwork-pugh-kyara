package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.*;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile({"mainApp","DAOTesting"})
public interface GameDAO {

    Game createGame(Game game);
    Game getGameByID(Integer gameID) throws NullGameIDException, InvalidGameIDException;
    List<Game> getGameCollection();
    List<Game> getGameByPlatform(String platform) throws NullPlatformException;
    List<Game> getGameByCategory(String category) throws NullCategoryException;
    List<Game> getGameByYear(Integer year) throws NullYearException;
    void editGame(Integer gameID, String title, Integer releaseDate, String category, List<String> platform) throws NullGameIDException, InvalidGameIDException;
    void deleteGame(Integer gameID) throws NullGameIDException;

}
