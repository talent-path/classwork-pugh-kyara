package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostgresLibraryDAO implements LibraryDAO {


    @Override
    public Book createBook(Book book) throws NullAuthorException, NullTitleException, NullYearException {
        return null;
    }


    @Override
    public Book getBookByID(Integer bookID) throws InvalidBookIDException {
        return null;
    }

    @Override
    public List<Book> getCollection() {
        return null;
    }

    @Override
    public List<Book> getBookByAuthor(String author) throws NullAuthorException {
        return null;
    }

    @Override
    public Book getBookByTitle(String title) throws NullTitleException {
        return null;
    }

    @Override
    public Book getBookByYear(Integer author) throws NullYearException {
        return null;
    }

    @Override
    public void editBook(Integer bookID, String newTitle, List<String> newAuthors, Integer newYear) throws InvalidBookIDException, NullAuthorException, NullTitleException, NullYearException {

    }

    @Override
    public void deleteBook(Integer bookID) throws InvalidBookIDException {

    }

    @Override
    public void deleteAuthorByName(String author) throws NullAuthorException {

    }
}
