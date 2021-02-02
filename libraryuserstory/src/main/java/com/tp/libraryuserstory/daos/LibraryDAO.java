package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;

import java.util.List;

public interface LibraryDAO {

    int createBook(String title, List<String> author, Integer year) throws NullAuthorException, NullTitleException, NullYearException;
    //retrieve a book by its given ID
    Book getBookByID(Integer bookID) throws InvalidBookIDException;
    //return entire book collection
    List<Book> getCollection();
    //return a list of authors
    List<String> getAuthorList();
    Book getBookByAuthor(String author) throws NullAuthorException;
    void editBook(Integer bookID, Book book) throws InvalidBookIDException;
    //delete a book by ID
    void deleteBook(Integer bookID) throws InvalidBookIDException;
    void deleteAuthorByName(Integer bookID) throws NullAuthorException;
}

//TO BE DELETED

//make any changes to a book
//    void editBookTitle(LibraryApp app, String title);
//    void editBookAuthor(LibraryApp app, List<String> author) throws NullAuthorException;
//    void editBookYear(LibraryApp app, Integer year);
