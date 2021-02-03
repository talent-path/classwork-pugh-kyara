package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
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
    public Book createBook(String title, List<String> author, Integer year) throws NullAuthorException, NullTitleException, NullYearException {
        if(title == null)
        {
            throw new NullTitleException("Cannot add a book with a null title!");
        }
        if(author == null)
        {
            throw new NullAuthorException("Cannot add a book with a null author!");
        }
        if(year ==  null)
        {
            throw new NullYearException("Cannot add a book with a null year");
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
        Book bookToAdd = new Book(id,title,author,year);
        fullCollection.add(bookToAdd);
        return bookToAdd;
    }

    //returns a specific book
    @Override
    public Book getBookByID(Integer bookID) throws InvalidBookIDException{
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
    public List<Book> getBookByAuthor(String author) throws NullAuthorException {
        List<Book> toReturn = new ArrayList<>();
        for(Book toCheck : fullCollection)
        {
            for (int i = 0; i < fullCollection.size(); i++) {
                if(toCheck.getAuthors().get(i).equals(author))
                {
                    toReturn.add(toCheck);
                }
            }
        }
        return toReturn;
    }

    @Override
    public Book getBookByTitle(String title) throws NullTitleException {
        return null;
    }

    @Override
    public Book getBookByYear(Integer author) throws NullYearException {
        return null;
    }

    @Override
    public void editBook(Integer bookID, String newTitle, List<String>newAuthors, Integer newYear) throws InvalidBookIDException, NullAuthorException, NullTitleException,NullYearException {
        if(bookID == null)
        {
            throw new InvalidBookIDException("Cannot edit a book with null ID!");
        }
        if(newTitle==null)
        {
            throw new NullTitleException("Cannot edit a book with a null title!");
        }
        if(newAuthors==null)
        {
            throw new NullAuthorException("Cannot edit a book with a null author(s)!");
        }
        if(newYear==null)
        {
            throw new NullYearException("Cannot edit a book with a null year!");
        }
        //create a new book and set values to new passed in values
        Book toEdit = null;
        //find the original book in the collection and replace it with teh new book
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                toEdit = getBookByID(bookID);
                toEdit.setTitle(newTitle);
                toEdit.setAuthors(newAuthors);
                toEdit.setYear(newYear);
                fullCollection.set(i,toEdit);
                break;
            }
        }
        //if that ID is not found
        if(toEdit == null)
        {
            throw new InvalidBookIDException("Cannot find a book with ID "+bookID+"!");
        }

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

