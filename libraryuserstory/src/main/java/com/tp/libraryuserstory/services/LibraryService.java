package com.tp.libraryuserstory.services;


import com.tp.libraryuserstory.models.LibraryApp;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.persistence.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService {
    @Autowired
    LibraryDAO dao;

    public LibraryViewModel createBook()
    {
        //create a new book

        //insert the book into the dao
        //get the book ID back from DAO
        int newBookID = dao.createBook();
        //return a view model of that book

    }

    public List<LibraryViewModel> getCollection()
    {
        List<LibraryApp> fullCollection = dao.getCollection();
    }

}
