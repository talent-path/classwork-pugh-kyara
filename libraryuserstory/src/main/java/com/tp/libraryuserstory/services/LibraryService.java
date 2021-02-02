package com.tp.libraryuserstory.services;


import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryApp;
import com.tp.libraryuserstory.persistence.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService {
    @Autowired
    LibraryDAO dao;

    String [] possibleBookTitles = {"Pride and Prejudice", "Good Omens", "Game of Thrones", "Crucible", "Hunger Games"};
    String [] possibleBookAuthors = {"Jane Austen", "Neil Gaiman", "George R.R. Martin", "Arthur Miller", "Suzanne Collins"};

    public LibraryApp createBook() throws NullAuthorException, NullTitleException {
        //create a new book
        //list of possible Book titles for testing
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


    public List<LibraryApp> getCollection()
    {
        List<LibraryApp> fullCollection = dao.getCollection();
        return fullCollection;
    }

    public LibraryApp getBookByID(Integer bookID) {
        LibraryApp collection = dao.getBookByID(bookID);
        return collection;
    }

    public LibraryApp getBookByAuthor(String author) throws NullAuthorException{
        LibraryApp collection = dao.getBookByAuthor(author);
        return (collection);
    }





    public void editBook() {
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
