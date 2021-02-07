package com.tp.libraryuserstory.controllers;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
import com.tp.libraryuserstory.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @GetMapping("/book/author")
    public ResponseEntity getAuthorCollection(@RequestBody String author)
    {
        List<Book> books = null;
        try {
            books = service.getBookByAuthor(author);
        }
        catch (NullAuthorException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
       return ResponseEntity.ok(books);
    }

    @GetMapping("/book/title")
    public ResponseEntity getBookByTitle(@RequestBody String title)
    {
        List<Book> books = null;
        try {
            books = service.getBookByTitle(title);
        }
        catch (NullTitleException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
       return ResponseEntity.ok(books);
    }

    @GetMapping("/book/year")
    public ResponseEntity getBookByTitle(@RequestBody Integer year)
    {
        List<Book> books = null;
        try {
            books = service.getBookByYear(year);
        }
        catch (NullYearException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(books);
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
    public Book createLibrary(@RequestBody Book book)
    {
        Book newBook = null;
        try
        {
            newBook = service.createBook(book);
        }catch (InvalidBookIDException | NullAuthorException | NullTitleException | NullYearException e)
        {
            e.printStackTrace();
        }
        return newBook;
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

    @DeleteMapping("/delete/author")
    public String deleteBook(@RequestBody String author)
    {
        try{

            service.deleteByAuthor(author);
            return "Book with author "+ author + " successfully deleted!";
        }
        catch(NullAuthorException ex)
        {
            return ex.getMessage();
        }
    }

}



