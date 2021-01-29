package com.tp.libraryuserstory.services;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryApp;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.persistence.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    @Autowired
    LibraryDAO dao;

    public LibraryViewModel createBook() throws NullAuthorException, NullTitleException {
        //create a new book

        //list of possible Book titles for testing
        String [] possibleBookTitles = {"Pride and Prejudice", "Good Omens", "Game of Thrones", "Crucible", "Hunger Games"};
        String [] possibleBookAuthors = {"Jane Austen", "Neil Gaiman", "George R.R. Martin", "Arthur Miller", "Suzanne Collins"};

        //real authors and books they wrote should align together
        //not necessary but I just want a bit of organization
        int index = RNG.randomIndex(possibleBookTitles.length-1);
        String title = possibleBookTitles[index];
        String author = possibleBookAuthors[index];

        //insert the book into the dao
        //get the book ID back from DAO
        int newBookID = dao.createBook(title,author);
        //return a view model of that book
        return this.getBookByID(newBookID);
    }


    public List<LibraryViewModel> getCollection()
    {
        List<LibraryApp> fullCollection = dao.getCollection();
        List<LibraryViewModel> converted = new ArrayList<>();

        for(LibraryApp toConvert : fullCollection)
        {
            converted.add(convertModel(toConvert));
        }
        return converted;
    }

    public LibraryViewModel getBookByID(Integer bookID) {
        LibraryApp collection = dao.getBookByID(bookID);
        return convertModel(collection);
    }

    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        dao.deleteBook(bookID);
    }

    public LibraryViewModel editBookID(Integer bookID, Integer newID)
    {
        LibraryApp toEdit = dao.getBookByID(bookID);
        toEdit.setBookID(newID);
        dao.editBookID(toEdit, newID);
        return getBookByID(bookID);
    }



    private LibraryViewModel convertModel(LibraryApp collection)
    {
        LibraryViewModel toReturn = new LibraryViewModel();

        return toReturn;
    }


    public LibraryViewModel editBookYear(Integer bookID, Integer newYear) {

        LibraryApp toEdit = dao.getBookByID(bookID);
        toEdit.setYear(newYear);
        dao.editBookYear(toEdit, newYear);
        return getBookByID(bookID);

    }

    public LibraryViewModel editBookAuthor(Integer bookID, List<String> newAuthors) {

        LibraryApp toEdit = dao.getBookByID(bookID);
        toEdit.setAuthors(newAuthors);
        dao.editBookAuthor(toEdit, newAuthors);
        return getBookByID(bookID);
    }

    public LibraryViewModel editBookTitle(Integer bookID, String newTitle) {

        LibraryApp toEdit = dao.getBookByID(bookID);
        toEdit.setTitle(newTitle);
        dao.editBookTitle(toEdit, newTitle);
        return getBookByID(bookID);

    }
}
