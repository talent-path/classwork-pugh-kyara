package com.tp.libraryuserstory.daos;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryInMemDAOTests {

    @Autowired
    LibraryInMemDAO testDAO;

    List<String> authors = new ArrayList<>();
    //delete all books made and create 1 new one
    @BeforeEach
    public void setup() throws InvalidBookIDException {

        authors.add("Jane Doe");
        testDAO.deleteBook(100);
    }


    //creation of a book with no issues
    @Test
    public void createBookGood() throws NullAuthorException, NullTitleException, NullYearException
    {
        //Book firstBook = null;
        int bookID = testDAO.createBook("My Book",authors,2009);
        assertEquals(1,bookID);
        int bookID2 = testDAO.createBook("My Book",authors,2009);
        assertEquals(2,bookID2);
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

