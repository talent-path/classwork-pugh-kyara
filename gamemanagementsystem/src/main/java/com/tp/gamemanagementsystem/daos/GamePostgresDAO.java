package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Component
public class GamePostgresDAO implements GameDAO {

    @Autowired
    JdbcTemplate template;


    @Override
    public Game createGame(Game game) {
        return null;
    }

    @Override
    public Game getGameByID(Integer gameID) {

        return null;
    }

    @Override
    public List<Game> getGameCollection() {
        return null;
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
    public List<Game> getGameByYear() {
        return null;
    }

    @Override
    public void editGame(Integer gameID, String title, Integer releaseDate, String category, List<String> platform) {

    }

    @Override
    public void deleteGame(Integer gameID) {

    }
}
