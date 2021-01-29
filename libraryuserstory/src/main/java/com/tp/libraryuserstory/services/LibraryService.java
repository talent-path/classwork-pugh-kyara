package com.tp.libraryuserstory.services;


import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryApp;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.persistence.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    }

    public List<LibraryViewModel> getCollection()
    {
        List<LibraryApp> fullCollection = dao.getCollection();
        List<LibraryViewModel> converted = new ArrayList<>();

        for(LibraryApp toConvert : fullCollection)
        {
            
        }
    }

}
