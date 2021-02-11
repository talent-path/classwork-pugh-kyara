package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.exceptions.*;
import com.tp.gamemanagementsystem.models.Game;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("serviceTest")
public class GameInMemDAO implements GameDAO{
    @Override
    public Game createGame(Game game) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Game getGameByID(Integer gameID) throws NullIDException, InvalidIDException {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Game> getGameCollection() {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Game> getGameByPlatform(String platform) throws NullPlatformException {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Game> getGameByCategory(String category) throws NullCategoryException {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Game> getGameByYear(Integer year) throws NullYearException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void editGame(Integer gameID, String title, Integer releaseDate, String category, List<String> platform) throws NullIDException, InvalidIDException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteGame(Integer gameID) throws NullIDException {
        throw new UnsupportedOperationException();

    }
}
