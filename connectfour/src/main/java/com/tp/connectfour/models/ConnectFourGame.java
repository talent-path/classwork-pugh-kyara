package com.tp.connectfour.models;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame {

    private Integer gameID;
    private String [] board;
    private List<Integer> spotsTaken;
    private final String player1 = "X";
    private final String player2 = "O";

    //new game constructor
    public ConnectFourGame(Integer gameID) {
        this.gameID = gameID;
        board = new String[42];
    }

    //for an existing game
    public ConnectFourGame(Integer gameID,String[] board, List<Integer> spotsTaken) {
        this.gameID = gameID;
        this.board = board;
        spotsTaken = new ArrayList<>();

    }

    public List<Integer> getSpotsTaken() {
        return spotsTaken;
    }

    public void setSpotsTaken(List<Integer> spotsTaken) {
        this.spotsTaken = spotsTaken;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
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
