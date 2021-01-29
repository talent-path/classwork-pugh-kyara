package com.tp.libraryuserstory.persistence;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.models.LibraryApp;

import java.util.List;

public interface LibraryDAO {

    //retrieve a book by its given ID
    LibraryApp getBookByID(Integer bookID);
    //return entire book collection
    List<LibraryApp> getCollection();
    //return a list of authors
    List<LibraryApp> getAuthorList();
    //make any changes to a book
    //TODO:might need to add parameters later
    void editBookID(Integer bookID, Integer newID);
    void editBookTitle(Integer bookID, String title);
    void editBookAuthor(Integer bookID, List<String> author);
    void editBookYear(Integer bookID, Integer year);
    void deleteBook(Integer bookID) throws InvalidBookIDException;
}
