package com.tp.connectfour.models;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame {

    private Integer gameID;
    private String [] board;


    //new game constructor
    public ConnectFourGame(Integer gameID) {
        this.gameID = gameID;
        board = new String[42];
    }

    //for an existing game
    public ConnectFourGame(Integer gameID,String[] board) {
        this.gameID = gameID;
        this.board = board;

    }


    //copy constructor
    public ConnectFourGame(ConnectFourGame that)
    {
        this.gameID = that.gameID;
    }

//getters
    public Integer getGameID() {
        return gameID;
    }


    public String[] getBoard() {
        return board;
    }
}
