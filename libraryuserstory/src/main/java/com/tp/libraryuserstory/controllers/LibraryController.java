package com.tp.libraryuserstory.controllers;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/book")
    public List<LibraryViewModel> getCollection()
    {
        return service.getCollection();
    }

    @GetMapping("/book/{bookID}")
    public LibraryViewModel getBookByID(@PathVariable Integer bookID)
    {
        return service.getBookByID(bookID);
    }

    @PutMapping("/editid")
    public LibraryViewModel editBookID(@RequestBody UpdateBookRequest request)
    {
        return service.editBookID(request.getBookID(), request.getNewID());
    }

    @PutMapping("/edittitle")
    public LibraryViewModel editBookTitle(@RequestBody UpdateBookRequest request)
    {
        return service.editBookTitle(request.getBookID(), request.getNewTitle());
    }

    @PutMapping("/editauthor")
    public LibraryViewModel editBookAuthor(@RequestBody UpdateBookRequest request)
    {
        return service.editBookAuthor(request.getBookID(), request.getAuthorsList());
    }

    @PutMapping("/edityear")
    public LibraryViewModel editBookYear(@RequestBody UpdateBookRequest request)
    {
        return service.editBookYear(request.getBookID(), request.getNewID());
    }

    @PostMapping("/delete/{bookID}")
    public String deleteBook(@PathVariable Integer bookID)
    {
        try{

            service.deleteBook(bookID);
            return "Book with ID "+ bookID + "sucessfully deleted!";
        }
        catch(InvalidBookIDException ex)
        {
            return ex.getMessage();
        }
    }

}
