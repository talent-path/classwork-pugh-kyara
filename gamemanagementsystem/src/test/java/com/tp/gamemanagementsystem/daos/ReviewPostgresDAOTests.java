package com.tp.gamemanagementsystem.daos;

import static org.junit.jupiter.api.Assertions.*;

import com.tp.gamemanagementsystem.exceptions.NullIDException;
import com.tp.gamemanagementsystem.exceptions.NullReviewException;
import com.tp.gamemanagementsystem.exceptions.NullTitleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("DAOTesting")
public class ReviewPostgresDAOTests {

    @Autowired
    ReviewPostgresDAO testDAO;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup()
    {

    }

    @Test
    public void addReviewTest()
    {

    }

    @Test
    public void addReviewNullTitle()
    {
        assertThrows(NullTitleException.class,()->testDAO.makeReview(null,"My brand new review!",8, 1 ));

    }

    @Test
    public void addReviewNullReview()
    {
        assertThrows(NullReviewException.class,()->testDAO.makeReview("New Review",null,8, 1 ));

    }

    @Test
    public void addReviewNullGameID()
    {
        assertThrows(NullIDException.class,()->testDAO.makeReview("New Review","My brand new review!",8, null ));

    }

    @Test
    public void editReviewTest()
    {

    }

    @Test
    public void editReviewNullID()
    {
        assertThrows(NullIDException.class,()->testDAO.editReview(null, "My brand new review!"));

    }

    @Test
    public void editReviewNullReview()
    {
        assertThrows(NullReviewException.class,()->testDAO.editReview(1, null));

    }

    @Test
    public void deleteReviewTest()
    {


    }

    @Test
    public void deleteReviewNullID()
    {
        assertThrows(NullIDException.class, ()->testDAO.deleteReview(null));
    }



}
