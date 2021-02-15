package com.tp.gamemanagementsystem.controllers;

import com.tp.gamemanagementsystem.exceptions.InvalidIDException;
import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullReviewException;
import com.tp.gamemanagementsystem.exceptions.NullTitleException;
import com.tp.gamemanagementsystem.models.Review;
import com.tp.gamemanagementsystem.services.GameManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import requests.UpdateReviewRequest;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    GameManagementService service;

    //return all reviews by most recent
    @GetMapping("/reviews")
    public List<Review> getAllReviews()
    {

        List<Review> allReviews = service.getAllReviews();
        return allReviews;
    }

    //reviews by game ID
    @GetMapping("/review/game/ID")
    public List<Review> getReviewsByGameID(@RequestBody Integer gameID)
    {
        List<Review> allReviews = null;
        try
        {
            allReviews = service.getReviewsByGameID(gameID);
        }
        catch(NullIDException | InvalidIDException e)
        {
            e.printStackTrace();
        }
        return allReviews;
    }

    //reviews by game name
    @GetMapping("/review/game")
    public List<Review> getReviewsByGame(@RequestBody String title)
    {
        List<Review> allReviews = null;
        try
        {
            allReviews = service.getReviewsByGameName(title);
        }
        catch(NullTitleException e)
        {
            e.printStackTrace();
        }
        return allReviews;
    }

    //edit a game review by the review ID
    @GetMapping("/delete/review")
    public String editReview(@RequestBody UpdateReviewRequest request)
    {
        List<Review> allReviews = null;
        try
        {
            service.editReview(request.getReviewID(), request.getReview());
        }
        catch(NullIDException | NullReviewException e)
        {
            e.getMessage();
        }
        return "Review successfully edited!";
    }

    //delete a game review by the review ID
    @GetMapping("/delete/review")
    public String deleteReview(@RequestBody Integer reviewID)
    {
        try
        {
            service.deleteReview(reviewID);
        }
        catch(NullIDException e)
        {
            e.getMessage();
        }
        return "Review successfully deleted!";
    }

}
