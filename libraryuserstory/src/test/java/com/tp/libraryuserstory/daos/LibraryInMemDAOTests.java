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

    //delete all books made and create 1 new one
    @BeforeEach
    public void setup() throws InvalidBookIDException {

        testDAO.deleteBook(100);
    }


    //creation of a book with no issues
    //everything is assigned properly
    @Test
    public void createBookGood() throws NullAuthorException, NullTitleException, NullYearException
    {
        //create a book
        Book book = new Book();
        book.setTitle("My Book");
        List<String> authors = new ArrayList<>();
        authors.add("Jane Doe");
        book.setAuthors(authors);
        book.setYear(2021);

        //create a 2nd book
        Book book2 = new Book();
        book2.setTitle("My 2nd Book");
        List<String> authors2 = new ArrayList<>();
        authors2.add("Jane Doe");
        authors2.add("John Doe");
        book2.setAuthors(authors2);
        book2.setYear(2021);

        //assign books created
        Book testBook1 = testDAO.createBook(book);
        Book testBook2 = testDAO.createBook(book2);

        //assert tests
        assertEquals(1,testBook1.getBookID());
        assertEquals("My Book",testBook1.getTitle());
        assertEquals("Jane Doe",testBook1.getAuthors().get(0));
        assertEquals(2021,testBook1.getYear());
        assertEquals(2,testBook2.getBookID());
        assertEquals("My 2nd Book",testBook2.getTitle());
        assertEquals("John Doe",testBook2.getAuthors().get(1));
        assertEquals(2021,testBook2.getYear());
    }

    //Creation of a book with a null title
    //goal is to get a NullTitleException
    @Test
    public void createBookNullTitle() throws NullAuthorException, NullTitleException, NullYearException
    {
        //create a book with a null ID
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Jane Doe");
        book.setTitle(null);
        book.setYear(2020);
       // Book toTest = testDAO.createBook(book.getTitle(),book.getAuthors(), book.getYear());
        assertThrows(NullTitleException.class, ()-> testDAO.createBook(book));
    }


    //Creation of a book with a null ID
    //goal is to get a NullAuthorException
    @Test
    public void createBookNullAuthor() throws NullAuthorException
    {

    }
}

