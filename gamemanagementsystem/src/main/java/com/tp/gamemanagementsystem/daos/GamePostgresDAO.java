package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.daos.mappers.GameIDMapper;
import com.tp.gamemanagementsystem.daos.mappers.GameMapper;
import com.tp.gamemanagementsystem.exceptions.InvalidGameIDException;
import com.tp.gamemanagementsystem.exceptions.NullGameIDException;
import com.tp.gamemanagementsystem.exceptions.NullYearException;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Component
public class GamePostgresDAO implements GameDAO {

    @Autowired
    JdbcTemplate template;


    @Override
    public List<Game> getGameCollection() {
        List<Game> allGames = template.query("SELECT \"gameID\", \"title\", \"category\", \"year\" FROM \"Games\""+";", new GameMapper());
        return allGames;
    }

    @Override
    public Game createGame(Game newGame) {
        Integer gameID = template.queryForObject( "INSERT INTO \"Games\" (\"title\", \"category\", \"year\") VALUES (?, ?, ?) RETURNING \"gameID\"", new GameIDMapper(),
                newGame.getTitle(),
                newGame.getCategory(),
                newGame.getReleaseYear());
        newGame.setGameID(gameID);
        return newGame;
    }

    @Override
    public Game getGameByID(Integer gameID) throws NullGameIDException, InvalidGameIDException {
        if(gameID == null)
        {
            throw new NullGameIDException("Cannot find a game with a null ID");
        }
        Game toReturn = null;
        try {
            toReturn = template.queryForObject("SELECT * FROM \"Games\" WHERE \"gameID\" = \'" + gameID + "\'", new GameMapper());
        }
        catch(EmptyResultDataAccessException e)
        {
            throw new InvalidGameIDException("Cannot find game with ID "+ gameID+"!", e);
        }
        return toReturn;
    }

    @Override
    public List<Game> getGameByPlatform() {
        return null;
    }

    @Override
    public List<Game> getGameByCategory() {
        return null;
    }

    @Override
    public List<Game> getGameByYear(Integer year) throws NullYearException {
        if(year == null)
        {
            throw new NullYearException("Cannot retrieve a game with a null year!");
        }
        List<Game> toReturn = null;
        toReturn = template.query("SELECT * FROM \"Games\" WHERE \"year\" = \'" + year + "\'", new GameMapper());
        if(toReturn.isEmpty())
        {
            throw new NullYearException("Cannot retrieve a game with year "+year+"!");
        }
        return toReturn;
    }

    @Override
    public void editGame(Integer gameID, String title, Integer releaseDate, String category, List<String> platform) {

    }

    @Override
    public void deleteGame(Integer gameID) {

    }
}
