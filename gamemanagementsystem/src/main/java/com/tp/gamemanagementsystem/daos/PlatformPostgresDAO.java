package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.daos.mappers.GameMapper;
import com.tp.gamemanagementsystem.daos.mappers.PlatformMapper;
import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullPlatformException;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"mainApp","DAOTesting"})
public class PlatformPostgresDAO implements PlatformDAO {

    @Autowired
    JdbcTemplate template;

    public Platform getPlatformByID(Integer platformID) throws NullIDException, InvalidIDException
    {
        if(platformID == null)
        {
            throw new InvalidIDException("Cannot retrieve a platform with a null ID!");
        }
        Platform toReturn = null;
        try {
             toReturn = template.queryForObject("SELECT \"platformID\", \"name\" FROM \"Platforms\" WHERE \"platformID\" = " + platformID + ";", new PlatformMapper());
        }
        catch (EmptyResultDataAccessException e)
        {
            throw new InvalidIDException("Cannot find a platform with ID "+platformID+"!",e);
        }
        return toReturn;
    }


    public List<Game> getGamesByPlatformID(Platform somePlatform) throws NullIDException, InvalidIDException
    {
        List<Game> allGames = template.query("SELECT \"Games\".\"gameID\", \"title\", \"category\", \"year\" FROM \"Games\"\n"+
                "INNER JOIN \"GamePlatforms\" ON \"Games\".\"gameID\" = \"GamePlatforms\".\"gameID\"\n"+
                "INNER JOIN \"Platforms\" ON \"Platforms\".\"platformID\" = \"GamePlatforms\".\"platformID\"" +
                "WHERE \"Platforms\".\"platformID\" = ?", new GameMapper(), somePlatform.getPlatformID());
        somePlatform.setAllGames(allGames);
        return allGames;
    }



    @Override
    public List<Game> getGamesByPlatformName(String platform) throws NullPlatformException {
        if(platform == null)
        {
            throw new NullPlatformException("Cannot retrieve a game with a null platform!");
        }
        List<Game> toReturn = null;
        toReturn = template.query("SELECT * FROM \"Games\" WHERE \"year\" = \'" + platform + "\'", new GameMapper());
        if(toReturn.isEmpty())
        {
            throw new NullPlatformException("Cannot retrieve a game on platform "+platform+"!");
        }
        return toReturn;
    }
}
