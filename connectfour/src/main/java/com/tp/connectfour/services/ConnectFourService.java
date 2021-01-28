package com.tp.connectfour.services;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.InvalidMoveException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.persistence.ConnectFourDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFourService {


    @Autowired
    ConnectFourDAO dao;

    //start a new game
    public ConnectFourViewModel startGame() throws NullBoardException
    {
        //create a blank board
        String[]board = new String[42];
        for (int i = 0; i < 42; i++) {
            board[i] = " ";
        }
        //2. insert the game into the dao
        int newID = dao.startGame(board);
        //3. get back the ID from the dao
        //4. return a view model from that game
        return this.getGameById(newID);
    }

//retrieve a list of all games started
    public List<ConnectFourViewModel> getAllGames()
    {
        List<ConnectFourGame> allGames = dao.getAllGame();
        List<ConnectFourViewModel> converted = new ArrayList<>();

        for(ConnectFourGame toConvert : allGames)
        {
           converted.add(convertModel(toConvert));
        }
        return converted;
    }


    public ConnectFourViewModel getGameById(Integer gameID)
    {
        boolean turn = true;
        ConnectFourGame game = dao.getGameById(gameID);
        return convertModel(game);
    }

    public ConnectFourViewModel makeMove(Integer gameID, int index) throws InvalidMoveException, InvalidGameIdException
    {


        //the player makes a bad move throw exceptions
        if(index < 0 || index > 6)
        {
            throw new InvalidMoveException("You cannot make that kind of move!");
        }

        if(gameID == null)
        {
            throw new InvalidGameIdException("Could not find game with ID"+gameID);
        }

        ConnectFourGame game = dao.getGameById(gameID);

        //not sure if we need this or not
//        if(!game.getBoard()[index].equals(" "));
//        {
//            throw new InvalidMoveException("Cannot move in a spot that is already taken!");
//        }

        if(game == null)
        {
            throw new InvalidGameIdException("Could not find game with id " + gameID);
        }
        game.getSpotsTaken().add(index);
        dao.updateGame(game);
        return convertModel(game);


    }

    private ConnectFourViewModel convertModel(ConnectFourGame game)
    {
        //here is where take in the game update the board based
        // on the moves the computer and the player make

        //blank connect four board
        //might not need this since we should be working with the same board
        String [] partialBoard;

        ConnectFourViewModel toReturn = new ConnectFourViewModel();
        toReturn.setBoard(game.getBoard());
        toReturn.setGameID(game.getGameID());
        return toReturn;
    }

    public void deleteGame(Integer gameID) throws InvalidGameIdException{
        dao.deleteGame(gameID);
    }
}
