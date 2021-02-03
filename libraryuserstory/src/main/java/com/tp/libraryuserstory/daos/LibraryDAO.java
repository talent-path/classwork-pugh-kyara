package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;

import java.util.List;

public interface LibraryDAO {

    Book createBook(String title, List<String> author, Integer year) throws NullAuthorException, NullTitleException, NullYearException;
    //retrieve a book by its given ID
    Book getBookByID(Integer bookID) throws InvalidBookIDException;
    //return entire book collection
    List<Book> getCollection();
    //return a list of authors
    List<String> getAuthorList();
    //returns
    List<Book> getBookByAuthor(String author) throws NullAuthorException;
    Book getBookByTitle(String title) throws NullTitleException;
    Book getBookByYear(Integer author) throws NullYearException;
    void editBook(Integer bookID, String newTitle, List<String>newAuthors, Integer newYear) throws InvalidBookIDException, NullAuthorException, NullTitleException, NullYearException;
    //delete a book by ID
    void deleteBook(Integer bookID) throws InvalidBookIDException;
    void deleteAuthorByName(Integer bookID) throws NullAuthorException;
}
