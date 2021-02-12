package com.tp.gamemanagementsystem.daos;

import static org.junit.jupiter.api.Assertions.*;

import com.tp.gamemanagementsystem.exceptions.*;
import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@ActiveProfiles("DAOTesting")
public class GamePostgresDAOTests {
    @Autowired
    GamePostgresDAO testDAO;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup()
    {
        template.update("TRUNCATE \"GamePlatforms\", \"Reviews\", \"Games\", \"Platforms\" RESTART IDENTITY;");

        template.update( "INSERT INTO \"Platforms\" (\"name\") VALUES ('SEGA Dreamcast'), ('Playstation 5')" );
    }


//    //testing if game is added with no issues
//    // with all values provided properly
//    @Test
//    public void addGameTest()
//    {
//        Platform dreamCast = new Platform();
//        dreamCast.setPlatformID(1);
//
//        Game newGame = new Game();
//        newGame.setTitle("Sonic Adventure");
//        newGame.setCategory("RPG");
//        newGame.setReleaseYear(1998);
//
//        Game toReturn = testDAO.createGame(newGame);
//
//        assertEquals(1,toReturn.getGameID());
//        assertEquals("Sonic Adventure",toReturn.getTitle());
//
//        List<Game> allGames = testDAO.getGameCollection();
//        assertEquals(1,allGames.get(0).getGameID());
//        assertEquals("Sonic Adventure",allGames.get(0).getTitle());
//    }

    @Test
    public void addGameAltTest() throws InvalidIDException, NullTitleException, NullCategoryException, NullYearException, NullPlatformException
    {
        Platform dreamCast = new Platform();
        dreamCast.setPlatformID(1);
        Platform PS4 = new Platform();
        PS4.setPlatformID(2);

        List<Integer> platforms = new ArrayList<>();
        platforms.add(1);
        platforms.add(2);
        Game newGame = new Game();
        newGame.setTitle("Sonic Adventure");
        newGame.setCategory("RPG");
        newGame.setReleaseYear(1998);

        Game toReturn = testDAO.createGame(newGame.getTitle(),newGame.getCategory(),newGame.getReleaseYear(),platforms);

        assertEquals(1,toReturn.getGameID());
        assertEquals("Sonic Adventure",toReturn.getTitle());

        List<Game> allGames = testDAO.getGameCollection();
        assertEquals(1,allGames.get(0).getGameID());
        assertEquals("Sonic Adventure",allGames.get(0).getTitle());
    }

    @Test
    public void addGameNullTitle()
    {
        Platform dreamCast = new Platform();
        dreamCast.setPlatformID(1);

        List<Integer> platforms = new ArrayList<>();
        platforms.add(1);
        platforms.add(2);
        Game newGame = new Game();
        newGame.setTitle(null);
        newGame.setCategory("RPG");
        newGame.setReleaseYear(1998);
        assertThrows(NullTitleException.class,()-> testDAO.createGame(newGame.getTitle(),newGame.getCategory(),newGame.getReleaseYear(),platforms));
    }

    @Test
    public void addGameNullCategory()
    {
        Platform dreamCast = new Platform();
        dreamCast.setPlatformID(1);

        List<Integer> platforms = new ArrayList<>();
        platforms.add(1);
        platforms.add(2);
        Game newGame = new Game();
        newGame.setTitle("Sonic Adventure");
        newGame.setCategory(null);
        newGame.setReleaseYear(1998);
        assertThrows(NullCategoryException.class,()-> testDAO.createGame(newGame.getTitle(),newGame.getCategory(),newGame.getReleaseYear(),platforms));

    }

    @Test
    public void addGameNullYear()
    {
        Platform dreamCast = new Platform();
        dreamCast.setPlatformID(1);

        List<Integer> platforms = new ArrayList<>();
        platforms.add(1);
        platforms.add(2);
        Game newGame = new Game();
        newGame.setTitle("Sonic Adventure");
        newGame.setCategory("RPG");
        newGame.setReleaseYear(null);
        assertThrows(NullYearException.class,()-> testDAO.createGame(newGame.getTitle(),newGame.getCategory(),newGame.getReleaseYear(),platforms));
    }

    @Test
    public void addGameNullPlatforms()
    {
        List<Integer> platforms = new ArrayList<>();
        Game newGame = new Game();
        newGame.setTitle("Sonic Adventure");
        newGame.setCategory("RPG");
        newGame.setReleaseYear(1998);
        assertThrows(NullPlatformException.class,()-> testDAO.createGame(newGame.getTitle(),newGame.getCategory(),newGame.getReleaseYear(),platforms));
    }
}
