package com.tp.libraryuserstory.services;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
import com.tp.libraryuserstory.daos.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    @Autowired
    LibraryDAO dao;

//    String [] possibleBookTitles = {"Pride and Prejudice", "Good Omens", "Game of Thrones", "Crucible", "Hunger Games"};
//    String [] possibleBookAuthors = {"Jane Austen", "Neil Gaiman", "George R.R. Martin", "Arthur Miller", "Suzanne Collins"};
//    Integer [] possiblePubYear = {1813, 1990,1996, 1953, 2008};
//    public Book createBook() throws InvalidBookIDException, NullAuthorException, NullTitleException, NullYearException {
//        //create a new book
//        //list of possible Book titles for testing
//        //real authors and books they wrote should align together
//        //not necessary but I just want a bit of organization
//        int index = RNG.randomIndex(possibleBookTitles.length-1);
//        String title = possibleBookTitles[index];
//        List<String> author = new ArrayList<>();
//        author.add(possibleBookAuthors[index]);
//        Integer year = possiblePubYear[index];
//
//        //insert the book into the dao
//        //get the book ID back from DAO
//        Book newBook = dao.createBook(title,author,year);
//        //return a view model of that book
//        return newBook;
//    }

    public Book createBook(Book book) throws InvalidBookIDException, NullAuthorException, NullTitleException, NullYearException {

        Book newBook = dao.createBook(book);
        //return a view model of that book
        return newBook;
    }


    public List<Book> getCollection()
    {
        List<Book> fullCollection = dao.getCollection();
        return fullCollection;
    }

    public Book getBookByID(Integer bookID) throws InvalidBookIDException{
       Book toReturn = dao.getBookByID(bookID);
       return toReturn;
    }

    public List<Book> getBookByAuthor(String author) throws NullAuthorException{
        List<Book> collection = dao.getBookByAuthor(author);
        return collection;
    }

    public List<Book> getBookByTitle(String title) throws NullTitleException {
        List<Book> collection = dao.getBookByTitle(title);
        return collection;
    }
    public List<Book> getBookByYear(Integer year) throws NullYearException {
        List<Book> collection = dao.getBookByYear(year);
        return collection;
    }


    public void editBook(Integer bookID, String newTitle, List<String>newAuthors, Integer newYear) throws InvalidBookIDException, NullTitleException, NullYearException, NullAuthorException {
        dao.editBook(bookID, newTitle, newAuthors, newYear);
    }


    //
    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        dao.deleteBook(bookID);
    }
//
//    //takes in book id and deletes specified author with an exact match
//    public void deleteByAuthor(String author) throws NullAuthorException{
//        dao.deleteBookByAuthor(author);
//    }
//
//
//    public void deleteByTitle(String title) throws NullTitleException{
//        dao.deleteBookByTitle(title);
//    }
//
//    public void deleteByYear(Integer year) throws NullYearException {
//        dao.deleteBookByYear(year);
//    }
}
