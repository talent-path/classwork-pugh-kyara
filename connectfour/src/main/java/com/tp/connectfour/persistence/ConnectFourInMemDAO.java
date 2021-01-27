package com.tp.connectfour.persistence;

import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;

import java.util.List;

public class ConnectFourInMemDAO implements ConnectFourDAO{

    public ConnectFourInMemDAO()
    {
        ConnectFourGame onlyGame = new ConnectFourGame(1);
    }


    @Override
    public int startGame(Integer index) {
        return 0;
    }

    @Override
    public ConnectFourGame getGameById(Integer gameID) {
        return null;
    }

    @Override
    public List<ConnectFourGame> getAllGame() {
        return null;
    }

    @Override
    public void updateGame(ConnectFourGame game) {

    }

    @Override
    public void deleteGame(Integer gameID) {

    }
}
