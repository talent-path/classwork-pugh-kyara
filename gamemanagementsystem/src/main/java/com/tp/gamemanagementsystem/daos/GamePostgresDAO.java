package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.daos.mappers.GamePlatformMapper;
import com.tp.gamemanagementsystem.daos.mappers.IntegerMapper;
import com.tp.gamemanagementsystem.daos.mappers.GameMapper;
import com.tp.gamemanagementsystem.daos.mappers.PlatformMapper;
import com.tp.gamemanagementsystem.exceptions.*;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Component
@Profile({"mainApp","DAOTesting"})
public class GamePostgresDAO implements GameDAO {

    @Autowired
    JdbcTemplate template;


    @Override
    public List<Game> getGameCollection() {
        List<Game> allGames = template.query("SELECT \"Games\".\"gameID\", \"title\", \"category\", \"year\" FROM \"Games\"", new GameMapper());
        return allGames;
    }

    @Override
    public Game createGame(String title, String category, Integer year, List<Integer> platforms) throws InvalidIDException, NullTitleException, NullCategoryException, NullYearException, NullPlatformException {
        if(title == null)
        {
            throw new NullTitleException("Cannot create a game with a null title!");
        }
        if(category == null)
        {
            throw new NullCategoryException("Cannot create a game with a null category!");
        }
        if(year == null)
        {
            throw new NullYearException("Cannot create a game with a null year!");
        }
        if(platforms.isEmpty())
        {
            throw new NullPlatformException("Cannot create a game with a null platform!");
        }
        Game newGame = new Game();
        Integer gameID = template.queryForObject( "INSERT INTO \"Games\" (\"title\", \"category\", \"year\") VALUES (?, ?, ?) RETURNING \"gameID\"", new IntegerMapper("gameID"),
                title,
                category,
                year);
        newGame.setGameID(gameID);
        newGame.setReleaseYear(year);
        newGame.setTitle(title);
        newGame.setCategory(category);
            for (int i = 0; i < platforms.size(); i++) {
                try {
                    template.query("INSERT INTO \"GamePlatforms\" (\"platformID\",\"gameID\") VALUES (?, ?) RETURNING \"platformID\",\"gameID\"", new GamePlatformMapper(),
                            platforms.get(i),
                            newGame.getGameID());
                }catch (DataIntegrityViolationException e) {
                    throw new InvalidIDException("Cannot add a game on a platform with ID " + platforms.get(i)+"!");
                }
            }
        return newGame;
    }

    @Override
    public Game getGameByID(Integer gameID) throws NullIDException, InvalidIDException {
        if(gameID == null)
        {
            throw new NullIDException("Cannot find a game with a null ID");
        }
        Game toReturn = null;
        try {
            toReturn = template.queryForObject("SELECT * FROM \"Games\" WHERE \"gameID\" = \'" + gameID + "\'", new GameMapper());
        }
        catch(EmptyResultDataAccessException e)
        {
            throw new InvalidIDException("Cannot find game with ID "+ gameID+"!", e);
        }
        return toReturn;
    }

    @Override
    public List<Game> getGameByCategory(String category) throws NullCategoryException {
        if(category == null)
        {
            throw new NullCategoryException("Cannot retrieve a game with a null category!");
        }
        List<Game> toReturn = null;
        toReturn = template.query("SELECT * FROM \"Games\" WHERE \"category\" = ?", new GameMapper(),category);
        if(toReturn.isEmpty())
        {
            throw new NullCategoryException("Cannot retrieve a game with the category "+category+"!");
        }
        return toReturn;
    }
    @Override
    public List<Game> getGameByTitle(String title) throws NullTitleException {
        if(title == null)
        {
            throw new NullTitleException("Cannot retrieve a game with a null category!");
        }
        List<Game> toReturn = null;
        toReturn = template.query("SELECT * FROM \"Games\" WHERE \"title\" = ?", new GameMapper(),title);
        if(toReturn.isEmpty())
        {
            throw new NullTitleException("Cannot retrieve a game with the title "+title+"!");
        }
        return toReturn;
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
    public void editGame(Integer gameID, String title, String category, Integer releaseDate) throws NullIDException, InvalidIDException, NullTitleException, NullYearException, NullCategoryException {
        if (gameID == null) {
            throw new NullIDException("Cannot edit a game with a null ID!");
        }
        if (title == null) {
            throw new NullTitleException("Cannot edit a game with a null title!");
        }
        if (releaseDate == null) {
            throw new NullYearException("Cannot edit a game with a null release year!");
        }
        if (category == null) {
            throw new NullCategoryException("Cannot edit a game with a null category!");
        }
        //update game with new info
        try {
//            toEdit = template.queryForObject("SELECT * FROM \"Games\" WHERE \"gameID\" = \'" + gameID + "\'", new GameMapper());
            template.update("UPDATE \"Games\" SET \"title\" = \'" + title + "\' , \"category\" = \'" + category + "\' , \"year\" = \'" + releaseDate + "\' WHERE \"gameID\" = \'" + gameID + "\';");
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidIDException("Cannot make changes to a game with ID " + gameID + "!");
        }
    }

        //TO BE MOVED SOMEWHERE ELSE
//        //insert new platforms
//            for (int i = 0; i < platforms.size(); i++) {
//                try {
//                    template.query("INSERT INTO \"GamePlatforms\" (\"platformID\",\"gameID\") VALUES (?, ?) RETURNING \"platformID\",\"gameID\"", new GamePlatformMapper(),
//                            platforms.get(i),
//                            gameID);
//                    template.update("UPDATE \"GamePlatforms\" SET \"gameID\" = \'"+gameID+"\' WHERE \"platformID\" = \'" + platforms.get(i)+"\'");
//                } catch (DataIntegrityViolationException e)
//                {
//                    throw new InvalidIDException("Cannot add a game on a platform with ID " + platforms.get(i)+"!");
//                }
//            }



    //delete a game by the gameID
    @Override
    public void deleteGame(Integer gameID) throws NullIDException, InvalidIDException {
        if(gameID == null)
        {
            throw new NullIDException("Cannot delete a game with a null ID");
        }
        template.update("DELETE FROM \"GamePlatforms\" WHERE \"gameID\"="+gameID);
        template.update("DELETE FROM \"Reviews\" WHERE \"gameID\"="+gameID);
        template.update("DELETE FROM \"Games\" WHERE \"gameID\"="+gameID);
    }
}
