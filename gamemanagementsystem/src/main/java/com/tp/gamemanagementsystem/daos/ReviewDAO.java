package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.models.Review;

import java.util.List;

public interface ReviewDAO {

    //create a new review to type up
    Review makeReview(String review);
    //return all the reviews for a game
    List<Review> getGameReviews(Integer gameID);
    void deleteReview(Integer reviewID);
    void editReview(Integer reviewID);


}
