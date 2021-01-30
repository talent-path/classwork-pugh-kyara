package com.tp.libraryuserstory.controllers;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryViewModel;
import com.tp.libraryuserstory.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/new")
    public LibraryViewModel createLibrary()
    {
        LibraryViewModel app = null;
        try
        {
            app = service.createBook();
        }catch (NullAuthorException | NullTitleException e)
        {
            e.printStackTrace();
        }
        return app;
    }


    @GetMapping
    public ResponseEntity getBookByAuthor(@PathVariable String author)
    {
        LibraryViewModel toReturn = null;
        try {
            toReturn = service.getBookByAuthor(author);
        }
        catch (NullAuthorException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(toReturn);

    }

//cannot get this to run as I need
//    @PutMapping("/editid")
//    public ResponseEntity editBookID(@RequestBody UpdateBookRequest request)
//    {
//
//        LibraryViewModel toReturn = null;
//        try {
//            toReturn = service.editBookID(request.getBookID(), request.getNewID());
//        }
//        catch (InvalidBookIDException e)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        } catch (NullTitleException e) {
//            e.printStackTrace();
//        } catch (NullAuthorException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(toReturn);
//    }

    @PutMapping("/edittitle")
    public ResponseEntity editBookTitle(@RequestBody UpdateBookRequest request)
    {
        LibraryViewModel toReturn = null;
        try {
            toReturn = service.editBookTitle(request.getBookID(), request.getNewTitle());
        }
        catch (NullTitleException | InvalidBookIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @PutMapping("/editauthor")
    public ResponseEntity editBookAuthor(@RequestBody UpdateBookRequest request)
    {
        LibraryViewModel toReturn = null;
        try {
            toReturn = service.editBookAuthor(request.getBookID(), request.getAuthorsList());
        }
        catch(NullAuthorException | InvalidBookIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @PutMapping("/edityear")
    public ResponseEntity editBookYear(@RequestBody UpdateBookRequest request)
    {
        LibraryViewModel toReturn = null;
        try {
             service.editBookYear(request.getBookID(), request.getNewYear());
        }
        catch (InvalidBookIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @DeleteMapping("/delete/{bookID}")
    public String deleteBook(@PathVariable Integer bookID)
    {
        try{

            service.deleteBook(bookID);
            return "Book with ID "+ bookID + " successfully deleted!";
        }
        catch(InvalidBookIDException ex)
        {
            return ex.getMessage();
        }
    }

}
