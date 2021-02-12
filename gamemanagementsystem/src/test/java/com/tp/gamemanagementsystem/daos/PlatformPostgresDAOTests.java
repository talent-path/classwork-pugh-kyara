package com.tp.gamemanagementsystem.daos;

import static org.junit.jupiter.api.Assertions.*;

import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullTitleException;
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
public class PlatformPostgresDAOTests {

    @Autowired
    PlatformPostgresDAO testDAO;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup()
    {
        template.update("TRUNCATE \"GamePlatforms\", \"Reviews\", \"Games\", \"Platforms\" RESTART IDENTITY;");

        template.update( "INSERT INTO \"Platforms\" (\"name\") VALUES ('Gamecube'), ('Playstation 5')" );
    }

    @Test
    public void addPlatformTest() throws NullTitleException
    {
        Platform newPlatform = testDAO.addPlatform("Nintendo Switch");
        assertEquals(3,newPlatform.getPlatformID());
    }

    @Test
    public void addPlatformNullName()
    {
     assertThrows(NullTitleException.class, ()-> testDAO.addPlatform(null));
    }

    @Test
    public void deletePlatform()
    {
        assertTrue(false);
    }

    @Test
    public void deletePlatformNullID()
    {
        assertThrows(NullIDException.class, ()->testDAO.deletePlatform(null));

    }


}
