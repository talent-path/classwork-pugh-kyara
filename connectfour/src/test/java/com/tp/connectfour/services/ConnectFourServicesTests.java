package com.tp.connectfour.services;


import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.InvalidMoveException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.persistence.ConnectFourDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConnectFourServicesTests {

    @Autowired
    ConnectFourService service;

    @BeforeEach
    public void setup()
    {

        List<ConnectFourViewModel> allGames = service.getAllGames();
    }


    @Test
    public void startGameTestGoldenPath() throws NullBoardException
    {
        ConnectFourViewModel game = service.startGame();
        assertEquals(2, game.getGameID());
        assertEquals( " ", game.getBoard()[0]);
    }

    public void testMakeMoveGoldenPath()
    {
        //
        try{
            ConnectFourViewModel game = service.startGame();
            //make a move
            //assert that the spot the player chose is not " " should equal one of the tokens
            //otherwise the test fails
        }catch(NullBoardException ex)
        {
            fail();
        }
    }

    public void testMakeMoveBad()
    {
        //trying to catch the InvalidMoveException
        //if twe don't catch this exception the test fails
    }

    public void testMakeMoveInvalidGameId()
    {
        try
        {
            ConnectFourViewModel game = service.startGame();
            ConnectFourViewModel gameWrongID = service.makeMove(999,0);
            //making a move on the wrong ID we should throw the exception
            //others the test fails
            fail();
        }
        catch (InvalidMoveException | NullBoardException ex)
        {
            fail();
        }
        catch (InvalidGameIdException ex)
        {
            //do nothing because we want this so the test passes
        }

    }

    public void testMakeMoveNullGameId()
    {
        try
        {
            ConnectFourViewModel game = service.startGame();
            ConnectFourViewModel gameWrongID = service.makeMove(null,0);
            //making a move on the wrong ID we should throw the exception
            //others the test fails
            fail();
        }
        catch (InvalidMoveException | NullBoardException ex)
        {
            fail();
        }
        catch (InvalidGameIdException ex)
        {
            //do nothing because we want this so the test passes
        }

    }




}
