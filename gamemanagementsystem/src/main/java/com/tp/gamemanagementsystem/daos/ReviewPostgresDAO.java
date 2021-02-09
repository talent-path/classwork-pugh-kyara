package com.tp.gamemanagementsystem.daos;

import com.tp.gamemanagementsystem.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewPostgresDAO implements ReviewDAO {

    @Autowired
    JdbcTemplate template;

    @Override
    public Review makeReview(String review) {
        return null;
    }

    @Override
    public List<Review> getGameReviews(Integer gameID) {
        return null;
    }

    @Override
    public void deleteReview(Integer reviewID) {

    }

    @Override
    public void editReview(Integer reviewID) {

    }
}
