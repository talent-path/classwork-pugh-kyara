package com.tp.connectfour.models;

import java.util.List;

public class ConnectFourViewModel {

     Integer gameID;
     String [] board = new String [42];



    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String[] getBoard()
    {
     return board;
    }

    public void setBoard(String[] board)
    {
        this.board = board;
    }
}
