package com.tp.libraryuserstory.daos;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryInMemDAOTests {

    @Autowired
    LibraryInMemDAO testDAO;


    //delete all books made and create 1 new one
    @BeforeEach
    public void setup()
    {

    }


    //creation of a book with no issues
    @Test
    public void createBookGood()
    {

    }

    //Creation of a book with a null ID
    //goal is to get a InvalidBookIDException
    @Test
    public void createBookNullID()
    {

    }

    //Creation of a book with a null title
    //goal is to get a NullTitleException
    @Test
    public void createBookNullTitle()
    {

    }

    //Creation of a book with a null ID
    //goal is to get a NullAuthorException
    @Test
    public void createBookNullAuthor()
    {

    }
}

