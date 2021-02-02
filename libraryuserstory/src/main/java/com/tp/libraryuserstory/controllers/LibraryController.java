package com.tp.libraryuserstory.controllers;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
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
    public List<Book> getCollection()
    {
        return service.getCollection();
    }

    @GetMapping("/book/{bookID}")
    public ResponseEntity getBookByID(@PathVariable Integer bookID)
    {
        Book toReturn = null;
        try
        {
            toReturn = service.getBookByID(bookID);
        }
        catch (InvalidBookIDException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @PostMapping("/new")
    public Book createLibrary()
    {
        Book app = null;
        try
        {
            app = service.createBook();
        }catch (InvalidBookIDException | NullAuthorException | NullTitleException | NullYearException e)
        {
            e.printStackTrace();
        }
        return app;
    }

    @PutMapping("/editbook/{bookID}")
    public String editBook(@PathVariable Integer bookID, @RequestBody UpdateBookRequest book)
    {
        try{
            service.editBook(bookID, book.getTitle(),book.getAuthors(),book.getYear());
            return "Book with ID "+ bookID + " successfully edited!";
        }
        catch(InvalidBookIDException | NullAuthorException | NullTitleException | NullYearException ex)
        {
            return ex.getMessage();
        }

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




// TO BE DELETED LATER

//
//    @PutMapping("/edittitle")
//    public ResponseEntity editBookTitle(@RequestBody LibraryApp request)
//    {
//        LibraryViewModel toReturn = null;
//        try {
//            toReturn = service.se(request.getBookID());
//        }
//        catch (NullTitleException | InvalidBookIDException e)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//        return ResponseEntity.ok(toReturn);
//    }
//
//    @PutMapping("/editauthor")
//    public ResponseEntity editBookAuthor(@RequestBody LibraryApp request)
//    {
//        LibraryViewModel toReturn = null;
//        try {
//            toReturn = service.editBookAuthor(request.getBookID(), request.getAuthors());
//        }
//        catch(NullAuthorException | InvalidBookIDException e)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//        return ResponseEntity.ok(toReturn);
//    }
//
//    @PutMapping("/edityear")
//    public ResponseEntity editBookYear(@RequestBody LibraryApp request)
//    {
//        LibraryViewModel toReturn = null;
//        try {
//             toReturn = service.editBookYear(request.getBookID(), request.getYear());
//        }
//        catch (InvalidBookIDException e)
//        {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//        return ResponseEntity.ok(toReturn);
//    }

