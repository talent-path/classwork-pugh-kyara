package com.tp.connectfour.persistence;


import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.services.ConnectFourService;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConnectFourInMemDaoTests {

    @Autowired
    ConnectFourInMemDAO toTest;

    @BeforeEach
    public void setup() throws InvalidGameIdException, NullBoardException
    {
        List<ConnectFourGame> allGames = toTest.getAllGame();

        for(ConnectFourGame toRemove : allGames)
        {
            toTest.deleteGame(toRemove.getGameID());
        }
        toTest.startGame(new String[42]);
    }

@Test
    //this is the good output for starting a game
    public void testStartGameGoldenPath() {
        try {
            String[] testBoard = new String[42];
            String[] testBoard2 = new String[42];
            int id = toTest.startGame(testBoard);
            assertEquals(2, id);

            int nextID = toTest.startGame(testBoard2);
            assertEquals(3, nextID);
        }catch(NullBoardException ex)
        {
            fail();
        }



    }

@Test
    public void testStartGameNullBOard()
    {
        //test if we get a NullBoardException
        //getting this exception means we pass
        //if we dont get it we fail


    }

    @Test
    public void testNullGameId()
    {
        //test if we get a NullGameIDException
        //getting this is a pass
        //fail otherwise
    }

    @Test
    public void testDeleteGame()
    {
        //test is the game is null
        //test if we pass in the previous id if that id is now null
    }



}
