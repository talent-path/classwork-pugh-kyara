package com.tp.gamemanagementsystem.daos.mappers;

import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatformMapper implements RowMapper<Platform> {
    @Override
    public Platform mapRow(ResultSet resultSet, int i) throws SQLException {
        Platform platMap = new Platform();
        platMap.setPlatformID(resultSet.getInt("platformID"));
        platMap.setName(resultSet.getString("name"));

//        Game consoleGames = new Game();
//        consoleGames.setGameID(resultSet.getInt("gameID"));
//        consoleGames.setTitle(resultSet.getString("title"));
//        consoleGames.setCategory(resultSet.getString("category"));
//        consoleGames.setReleaseYear(resultSet.getInt("year"));
//        platMap.setAllGames(consoleGames);
        return platMap;
    }
}
