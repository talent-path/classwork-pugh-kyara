package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullBoardException;
import com.tp.connectfour.models.ConnectFourGame;

import java.util.List;

public interface ConnectFourDAO {

    ConnectFourGame getGameById(Integer gameID);
    List<ConnectFourGame> getAllGame();
    void updateGame(ConnectFourGame game);
    int startGame(String[] board) throws NullBoardException;
    void deleteGame(Integer gameID) throws InvalidGameIdException;

}
