package com.tp.libraryuserstory.persistence;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryApp;

import java.util.List;

public interface LibraryDAO {

    int createBook(String title, String author) throws NullAuthorException, NullTitleException;
    //retrieve a book by its given ID
    LibraryApp getBookByID(Integer bookID);
    //return entire book collection
    List<LibraryApp> getCollection();
    //return a list of authors
    List<String> getAuthorList();
    LibraryApp getBookByAuthor(String author) throws NullAuthorException;
    //make any changes to a book
    //TODO:might need to add parameters later
    void editBookID(LibraryApp app, Integer newID) throws InvalidBookIDException;
    void editBookTitle(LibraryApp app, String title);
    void editBookAuthor(LibraryApp app, List<String> author);
    void editBookYear(LibraryApp app, Integer year);
    void deleteBook(Integer bookID) throws InvalidBookIDException;


}
