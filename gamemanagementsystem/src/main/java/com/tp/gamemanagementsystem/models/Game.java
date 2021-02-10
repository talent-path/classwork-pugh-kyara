package com.tp.gamemanagementsystem.models;

import java.util.List;

public class Game {

    private Integer gameID;
    private String title;
    private Integer year;
    private String category;


    //empty default constructor for testing
    public Game()
    {

    }

    //creating a new game or editing a game
    public Game(Integer gameID, String title, Integer year, String category)
    {
        this.gameID = gameID;
        this.title = title;
        this.year = year;
        this.category = category;


    }

    //updating a new game
    public Game(Game that)
    {
        this.gameID = that.gameID;
        this.title = that.title;
        this.year = that.year;
        this.category = that.category;
    }


    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return year;
    }

    public void setReleaseYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public List<String> getPlatform() {
//        return platform;
//    }
//
//    public void setPlatform(List<String> platform) {
//        this.platform = platform;
//    }
////
////    public Integer getRating() {
////        return rating;
////    }
////
////    public void setRating(Integer rating) {
////        this.rating = rating;
////    }
}
