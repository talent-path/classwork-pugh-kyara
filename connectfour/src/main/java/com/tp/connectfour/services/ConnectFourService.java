package com.tp.connectfour.services;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.InvalidMoveException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.persistence.ConnectFourDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class ConnectFourService {


    @Autowired
    ConnectFourDAO dao;

//    public ConnectFourViewModel startGame()
//    {
//
//    }
//
//    public List<ConnectFourViewModel> getAllGames()
//    {
//
//    }


    public ConnectFourViewModel getGameById(Integer gameID)
    {
        ConnectFourGame game = dao.getGameById(gameID);
        return convertModel(game);
    }

    public ConnectFourViewModel makeMove(Integer gameID, Integer index) throws InvalidMoveException, InvalidGameIdException
    {
        ConnectFourGame game = dao.getGameById(gameID);

        //the player makes a bad move throw exceptions
        if(index < 0 || index > 6)
        {
            throw new InvalidMoveException("You cannot make that kind of move!");
        }
        if(!game.getBoard()[index].equals(" "));
        {
            throw new InvalidMoveException("Cannot move in a spot that is already taken!");
        }

        for(int i = 0; i < 42; i++) {

        }

        if(gameID == null)
        {
            throw new InvalidGameIdException("Could not find game with ID"+gameID);
        }

        if(game == null)
        {
            throw new InvalidGameIdException("Could not find game with id " + gameID);
        }



    }

    private ConnectFourViewModel convertModel(ConnectFourGame game)
    {
        //here is where take in the game update the board based
        // on the moves the computer and the player make

        //blank connect four board
        String blankBoard = "";
        ConnectFourViewModel toReturn = new ConnectFourViewModel();
        toReturn.setSpotsTaken(game.getSpotsTaken());
        toReturn.setGameID(game.getGameID());
        return toReturn;
    }
}
