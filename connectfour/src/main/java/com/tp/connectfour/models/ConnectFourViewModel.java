package com.tp.connectfour.models;

import java.util.List;

public class ConnectFourViewModel {

     Integer gameID;
     String [] board = new String [42];
     List<Integer> spotsTaken;
     final String player1 = "X";
     final String player2 = "O";

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public List<Integer> getSpotsTaken() {
        return spotsTaken;
    }

    public void setSpotsTaken(List<Integer> spotsTaken) {
        this.spotsTaken = spotsTaken;
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
