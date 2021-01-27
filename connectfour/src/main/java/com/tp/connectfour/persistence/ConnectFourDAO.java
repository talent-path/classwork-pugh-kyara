package com.tp.connectfour.persistence;

import com.tp.connectfour.models.ConnectFourGame;

import java.util.List;

public interface ConnectFourDAO {

    ConnectFourGame getGameById(Integer gameID);
    List<ConnectFourGame> getAllGame();
    void updateGame(ConnectFourGame game);
    int startGame(Integer index);
    void deleteGame(Integer gameID);

}
