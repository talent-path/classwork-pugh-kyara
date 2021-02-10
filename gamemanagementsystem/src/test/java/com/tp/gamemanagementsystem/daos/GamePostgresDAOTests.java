package com.tp.gamemanagementsystem.daos;

import static org.junit.jupiter.api.Assertions.*;

import com.tp.gamemanagementsystem.models.Game;
import com.tp.gamemanagementsystem.models.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

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

        template.update( "INSERT INTO \"Platforms\" (\"name\") VALUES ('SEGA Dreamcast')" );
    }


    //testing if game is added with no issues
    // with all values provided properly
    @Test
    public void addGameTest()
    {
        Platform dreamCast = new Platform();
        dreamCast.setPlatformID(1);

        Game newGame = new Game();
        newGame.setGamePlatform(dreamCast);
        newGame.setTitle("Sonic Adventure");
        newGame.setCategory("RPG");
        newGame.setReleaseYear(1998);

        Game toReturn = testDAO.createGame(newGame);

        assertEquals(1,toReturn.getGameID());
        assertEquals("Sonic Adventure",toReturn.getTitle());
        assertEquals(1,toReturn.getGamePlatform().getPlatformID());

        List<Game> allGames = testDAO.getGameCollection();
        assertEquals(1,allGames.get(0).getGameID());
        assertEquals("Sonic Adventure",allGames.get(0).getTitle());
        assertEquals(1, allGames.get(0).getGamePlatform().getPlatformID());
    }
}
