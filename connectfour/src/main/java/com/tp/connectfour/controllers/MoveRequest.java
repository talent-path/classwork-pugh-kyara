package com.tp.connectfour.controllers;

public class MoveRequest {

    private Integer gameID;
    private int move;

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }


}
