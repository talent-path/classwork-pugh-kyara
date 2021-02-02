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

    String [] possibleBookTitles = {"Pride and Prejudice", "Good Omens", "Game of Thrones", "Crucible", "Hunger Games"};
    String [] possibleBookAuthors = {"Jane Austen", "Neil Gaiman", "George R.R. Martin", "Arthur Miller", "Suzanne Collins"};
    Integer [] possiblePubYear = {1813, 1990,1996, 1953, 2008};
    public Book createBook() throws InvalidBookIDException, NullAuthorException, NullTitleException, NullYearException {
        //create a new book
        //list of possible Book titles for testing
        //real authors and books they wrote should align together
        //not necessary but I just want a bit of organization

        int index = RNG.randomIndex(possibleBookTitles.length-1);
        String title = possibleBookTitles[index];
        List<String> author = new ArrayList<>();
        author.add(possibleBookAuthors[index]);
        Integer year = possiblePubYear[index];

        //insert the book into the dao
        //get the book ID back from DAO
        int newBookID = dao.createBook(title,author,year);
        //return a view model of that book
        return this.getBookByID(newBookID);
    }


    public List<Book> getCollection()
    {
        List<Book> fullCollection = dao.getCollection();
        return fullCollection;
    }

    public Book getBookByID(Integer bookID) throws InvalidBookIDException{

        if(bookID == null)
        {
            throw new InvalidBookIDException("Cannot retrieve a book with a null ID!");
        }
        List<Book> fullCollection = dao.getCollection();
        Book collection = null;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                collection = new Book(fullCollection.get(i));
;            }
        }
        if(collection == null)
        {
            throw new InvalidBookIDException("Cannot retrieve a book with ID "+bookID+"!");
        }
        return collection;
    }

    public Book getBookByAuthor(String author) throws NullAuthorException{
        Book collection = dao.getBookByAuthor(author);
        return (collection);
    }


    public void editBook(Integer bookID, Book editBook) throws InvalidBookIDException {
        dao.editBook(bookID, editBook);
    }


    //
    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        dao.deleteBook(bookID);
    }

    //takes in book id and deletes specified author with an exact match
    public void deleteAuthorByName(Integer bookID, String author) throws InvalidBookIDException, NullAuthorException{
        dao.deleteAuthorByName(bookID);
    }



//VIEW MODEL NOT NEEDED DELETE LATER

    //    private LibraryViewModel convertModel(LibraryApp collection)
//    {
//        LibraryViewModel toReturn = new LibraryViewModel();
//        toReturn.setBookID(collection.getBookID());
//        toReturn.setTitle(collection.getTitle());
//        toReturn.setAuthors(collection.getAuthors());
//        toReturn.setYear(collection.getYear());
//        return toReturn;
//    }


//OLD EDIT MODELS TO BE DELETED!


    //    public LibraryViewModel editBookYear(Integer bookID, Integer newYear) throws InvalidBookIDException {
//
//        LibraryApp toEdit = dao.getBookByID(bookID);
//        toEdit.setYear(newYear);
//        dao.editBookYear(toEdit, newYear);
//        return convertModel(toEdit);
//
//    }
//
//    public LibraryViewModel editBookAuthor(Integer bookID, List<String> newAuthors) throws NullAuthorException, InvalidBookIDException {
//
//        LibraryApp toEdit = dao.getBookByID(bookID);
//        toEdit.setAuthors(newAuthors);
//        dao.editBookAuthor(toEdit, newAuthors);
//        return convertModel(toEdit);
//    }
//
//    public LibraryViewModel editBookTitle(Integer bookID, String newTitle) throws InvalidBookIDException, NullTitleException{
//
//        LibraryApp toEdit = dao.getBookByID(bookID);
//        toEdit.setTitle(newTitle);
//        dao.editBookTitle(toEdit, newTitle);
//        return convertModel(toEdit);
//
//    }


}
