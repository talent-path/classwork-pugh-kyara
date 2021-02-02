package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDAO implements LibraryDAO {

    private List<Book> fullCollection = new ArrayList<>();

    public LibraryInMemDAO()
    {
       Book firstBook = new Book(100, "My Book", "Jane Doe");
       fullCollection.add(firstBook);
    }

    //create a new book
    @Override
    public int createBook(String title, String author) throws NullAuthorException, NullTitleException {
        if(title == null)
        {
            throw new NullTitleException("Cannot add a book with a null title!");
        }
        if(author == null)
        {
            throw new NullAuthorException("Cannot add a book with a null author!");
        }
        int id = 0;
        for(Book toCheck : fullCollection )
        {
            if(toCheck.getBookID()>id)
            {
                id = toCheck.getBookID();
            }
        }
        id++;
        Book bookToAdd = new Book(id,title,author);
        fullCollection.add(bookToAdd);
        return id;
    }

    //returns a specific book
    @Override
    public Book getBookByID(Integer bookID) {
        Book toReturn = null;

        for(Book toCheck : fullCollection)
        {
            if(toCheck.getBookID().equals(bookID))
            {
                toReturn = new Book(toCheck);
                break;
            }
        }
        return toReturn;
    }

    //returns full library collection
    @Override
    public List<Book> getCollection() {
        List<Book> copyCollection = new ArrayList<>();
        for(Book toCopy : fullCollection)
        {
            copyCollection.add(new Book(toCopy));
        }
        return copyCollection;
    }


    //returns a list of authors
    //TODO:create a way to iterate through author list
    @Override
    public List<String> getAuthorList() {
        List<Book> copyCollection = new ArrayList<>();
        List<String> copyAuthorList = new ArrayList<>();
        for(Book toCopy : fullCollection)
        {
         for(String copyAuthor : toCopy.getAuthors())
         {
             copyAuthorList.add(copyAuthor);
         }
        }

        return copyAuthorList;
    }

    @Override
    public Book getBookByAuthor(String author) throws NullAuthorException {
        Book toReturn = null;
        for(Book toCheck : fullCollection)
        {
            if(toCheck.getAuthors().equals(author))
            {
                toReturn = new Book(toCheck);
                break;
            }
        }
        return toReturn;
    }

    //remove a book at a given index
    @Override
    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        int removeIndex = -1;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex!=-1)
        {
            fullCollection.remove(removeIndex);
        }
        else
        {
            throw new InvalidBookIDException("Cannot find book with ID "+ bookID +" to delete!");
        }

    }

    @Override
    public void deleteAuthorByName(Integer bookID) throws NullAuthorException {

    }

}



//OLD EDIT METHODS TO BE DELETED LATER


//    //edits a book title given a book ID
//    public void editBookTitle(LibraryApp app, String title) {
//        int editIndex = -1;
//        for (int i = 0; i < fullCollection.size(); i++) {
//            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
//            {
//                editIndex = i;
//            }
//        }
//        if(editIndex!=-1)
//        {
//            fullCollection.get(editIndex).setTitle(title);
//        }
//
//    }
//
//
//    //edits a books author given an ID
//    @Override
//    public void editBookAuthor(LibraryApp app, List<String> author) {
//        int editIndex = -1;
//        for (int i = 0; i < fullCollection.size(); i++) {
//            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
//            {
//                editIndex = i;
//            }
//        }
//        if(editIndex!=-1)
//        {
//            fullCollection.get(editIndex).setAuthors(author);
//        }
//    }
//
//    //edits a book publish year based on a given ID
//    @Override
//    public void editBookYear(LibraryApp app, Integer year) {
//        int editIndex = -1;
//        for (int i = 0; i < fullCollection.size(); i++) {
//            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
//            {
//                editIndex = i;
//            }
//        }
//        if(editIndex!=-1)
//        {
//            fullCollection.get(editIndex).setYear(year);
//        }
//
//    }
