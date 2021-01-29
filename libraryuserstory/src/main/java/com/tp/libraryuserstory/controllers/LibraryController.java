package com.tp.libraryuserstory.controllers;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService service;

    public List<LibraryViewModel> getCollection()
    {
        return service.getCollection();
    }

    @PostMapping("/delete/{bookID}")
    public String deleteBook(@PathVariable Integer bookID)
    {
        try{

            service.deleteBook(bookID);
        }
        catch(InvalidBookIDException ex)
        {
            ex.printStackTrace();
        }
    }

}
