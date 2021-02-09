package com.tp.gamemanagementsystem.models;

public class Review {

    private Integer reviewID;
    private String reviewText;

    //default constructor for testing
    public Review()
    {

    }

    //edit a review
    public Review(String reviewText)
    {
        this.reviewText = reviewText;
    }

    //copy constructor
    public Review(Review that)
    {
        this.reviewText = that.reviewText;
    }
}
